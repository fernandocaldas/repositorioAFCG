import { ProveedorDTO } from '../../dto/proveedor.dto';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { GestionarProveedorService } from '../../servicios/gestionar.proveedor.service';
import { PersonaDTO } from '../../dto/persona.dto';

/**
 * @description Componenete gestionar proveedores, el cual contiene la logica CRUD
 * 
 * @author Alex Fernando Caldas Garcia <>
 */
@Component({
  selector: 'gestionar-proveedor',
  templateUrl: './gestionar-proveedor.component.html',
  styleUrls: ['./gestionar-proveedor.component.css']
})
export class GestionarProveedorComponent implements OnInit {
  /**
   * Atributo que contiene los controles del formulario
   */
  public gestionarProveedorForm: FormGroup;

  /**
   * Atributo que contendra la informacion del proveedor
   */
  public proveedor: ProveedorDTO;
  public persona: PersonaDTO;

  /**
   * Atributo que contendra la lista de proveedores creados
   */
  public listaProveedores: Array<ProveedorDTO>;

  /**
     * Atributo que indica si se envio a validar el formulario
     */
  public submitted: boolean;

  /**
  *  variable para mostrar o ocultar mensaje Alert Boostrap
  */
  public mostrar: boolean = false;

  /**
 *  Nombre proveedorDTO
 */
  public nombreProveedor: string = null;

  public idProveedorActualizar: number = null;

  public proveedorActualizar: ProveedorDTO;

  /**
   * @description Este es el constructor del componente GestionarProveedorComponent
   * @author Alex Fernando Caldas Garcia <>
   */
  constructor(private fb: FormBuilder,
    private router: Router,
    private gestionarProveedorService: GestionarProveedorService) {
    this.gestionarProveedorForm = this.fb.group({
      nombre: [null, Validators.required],
      identificacion: [null],
      direccion: [null],
      montoCredito: [null],
      estado: [null]
    });

  }

  /**
     * @description Evento angular que se ejecuta al invocar el componente
     * @author Alex Fernando Caldas Garcia <>
     */
  ngOnInit() {
    this.proveedor = new ProveedorDTO();
    this.persona = new PersonaDTO();
    this.listaProveedores = new Array<ProveedorDTO>();
    this.consultarProveedores();
  }

  /**
   * @description Metodo que permite buscar un proveedor de la lista de acuerdo al indice
   * @author Alex Fernando Caldas Garcia
   */
  public consultarProveedor(posicion: number): void {
    let proveedor = this.listaProveedores[posicion];
    this.gestionarProveedorForm.controls.nombre.setValue(proveedor.persona.nombre);
    this.gestionarProveedorForm.controls.identificacion.setValue(proveedor.persona.identificacion);
    this.gestionarProveedorForm.controls.direccion.setValue(proveedor.direccion);
    this.gestionarProveedorForm.controls.fechaCreacion.setValue(proveedor.fechaCreacion);
    this.gestionarProveedorForm.controls.estado.setValue(proveedor.estado);
    this.gestionarProveedorForm.controls.montoCredito.setValue(proveedor.montoCredito);

    this.gestionarProveedorForm.controls.nombre.disable();
    this.gestionarProveedorForm.controls.identificacion.disable();
    this.gestionarProveedorForm.controls.direccion.disable();
    this.gestionarProveedorForm.controls.fechaCreacion.disable();
    this.gestionarProveedorForm.controls.estado.disable();
    this.gestionarProveedorForm.controls.montoCredito.disable();

    this.idProveedorActualizar = null;
  }

  /**
    * @description Metodo que permite validar el formulario y crear o actualizar un proveedor 
    */
  public crearActualizarProveedor(): void {
    this.submitted = true;
    if (this.gestionarProveedorForm.invalid) {
      return;
    }

    console.log("ID idProveedorActualizar :" + this.idProveedorActualizar)
   // console.log("Valor campo nombre actual:" + this.gestionarProveedorForm.controls.nombre);

   if (this.idProveedorActualizar !== null) {
      this.proveedor = new ProveedorDTO();
      this.persona = new PersonaDTO();
      let id = this.listaProveedores[this.idProveedorActualizar].id;
      this.proveedor.id = id;
      this.persona.nombre = this.gestionarProveedorForm.controls.nombre.value;
      this.persona.identificacion = this.gestionarProveedorForm.controls.identificacion.value;
      this.proveedor.direccion = this.gestionarProveedorForm.controls.direccion.value;
      this.proveedor.estado = this.gestionarProveedorForm.controls.estado.value;
      this.proveedor.montoCredito = this.gestionarProveedorForm.controls.montoCredito.value;
      this.proveedor.persona = this.persona;
      this.gestionarProveedorService.modificarProveedor(id, this.proveedor).subscribe(resultadoDTO => {
        if (resultadoDTO.exitoso) {
          this.consultarProveedores();
          this.limpiarFormulario();
        }
      }, error => {
        console.log(error);
      });
      this.idProveedorActualizar = null;
    } else {

      this.proveedor = new ProveedorDTO();
      this.persona = new PersonaDTO();
      this.persona.nombre = this.gestionarProveedorForm.controls.nombre.value;
      this.persona.identificacion = this.gestionarProveedorForm.controls.identificacion.value;
      this.proveedor.direccion = this.gestionarProveedorForm.controls.direccion.value;
      this.proveedor.estado = this.gestionarProveedorForm.controls.estado.value;
      this.proveedor.montoCredito = this.gestionarProveedorForm.controls.montoCredito.value;
      this.proveedor.persona = this.persona;
      this.gestionarProveedorService.crearProveedor(this.proveedor).subscribe(resultadoDTO => {
        debugger;
        if (resultadoDTO.exitoso) {
          this.consultarProveedores();
          this.limpiarFormulario();
        }
      }, error => {
        console.log(error);
      });
    }
    this.limpiarFormulario();

  }

  /**
   * @description Metodo que elimina un proveedor de la lista de acuerdo al indice
   * @author Alex Fernando Caldas Garcia
   */
  public eliminarProveedor(posicion: number): void {
    let proveedor = this.listaProveedores[posicion];

    if (posicion >= 0 && posicion !== null) {
      console.log("Elimino el proveedor #: " + posicion);

      this.listaProveedores.splice(posicion, 1);
      console.log("Elimino el proveedor con idProveedor: " + proveedor.id);
      this.gestionarProveedorService.eliminarProveedor(proveedor.id).subscribe(resultadoDTO => {
        if (resultadoDTO.exitoso) {
          this.consultarProveedores();
        }
      }, error => {
        console.log(error);
      });
      this.nombreProveedor = proveedor.persona.nombre;
      this.mostrar = true;
      console.log("mostrar Alert: " + this.mostrar);

    } else {
      this.mostrar = false;
      console.log("mostrar Alert: " + this.mostrar);
    }
  }

  /**
  * Metodo que permite modificar un proveedor de la tabla y sus detalles en la lista
  * @param posicion 
  */
  public modificarProveedor(posicion: number): void {
    let proveedor = this.listaProveedores[posicion];

    this.gestionarProveedorForm.controls.nombre.setValue(proveedor.persona.nombre);
    this.gestionarProveedorForm.controls.identificacion.setValue(proveedor.persona.identificacion);
    this.gestionarProveedorForm.controls.direccion.setValue(proveedor.direccion);
    this.gestionarProveedorForm.controls.fechaCreacion.setValue(proveedor.fechaCreacion);
    this.gestionarProveedorForm.controls.estado.setValue(proveedor.estado);
    this.gestionarProveedorForm.controls.montoCredito.setValue(proveedor.montoCredito);

    this.gestionarProveedorForm.controls.nombre.enable();
    this.gestionarProveedorForm.controls.identificacion.enable();
    this.gestionarProveedorForm.controls.direccion.enable();
    this.gestionarProveedorForm.controls.fechaCreacion.enable();
    this.gestionarProveedorForm.controls.estado.enable();
    this.gestionarProveedorForm.controls.montoCredito.enable();

    this.idProveedorActualizar = posicion;
  }


  public consultarProveedores(): void {
    this.gestionarProveedorService.consultarProveedores().subscribe(listaProveedores => {
      this.listaProveedores = listaProveedores;
    }, error => {
      console.log(error);
    });
  }

  private limpiarFormulario(): void {
    this.submitted = false;
    this.gestionarProveedorForm.controls.nombre.setValue(null);
    this.gestionarProveedorForm.controls.identificacion.setValue(null);
    this.gestionarProveedorForm.controls.direccion.setValue(null);
    this.gestionarProveedorForm.controls.estado.setValue(null);
    this.gestionarProveedorForm.controls.montoCredito.setValue(null);

  }

    /**
     * @description Metodo que obtiene los controles y sus propiedades
     */
    get f() {
      return this.gestionarProveedorForm.controls;
  }
}
