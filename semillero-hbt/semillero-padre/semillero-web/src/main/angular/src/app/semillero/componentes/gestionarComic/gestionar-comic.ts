
import { ComicDTO } from '../../dto/comic.dto';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { GestionarComicService } from '../../servicios/gestionar.comic.service';

/**
 * @description Componenete gestionar comic, el cual contiene la logica CRUD
 * 
 * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
 */
@Component({
    selector: 'gestionar-comic',
    templateUrl: './gestionar-comic.html',
    styleUrls: ['./gestionar-comic.css']
})
export class GestionarComicComponent implements OnInit {

    /**
     * Atributo que contiene los controles del formulario
     */
    public gestionarComicForm: FormGroup;

    /**
     * Atributo que contendra la informacion del comic
     */
    public comic: ComicDTO;

    /**
     * Atributo que contendra la lista de comics creados
     */
    public listaComics: Array<ComicDTO>;

    public idComic: number = 0;

    /**
     * Atributo que indica si se envio a validar el formulario
     */
    public submitted: boolean;

    /**
     *  variable para mostrar o ocultar mensaje Alert Boostrap
     */
    public mostrar: boolean = false;

    /**
   *  Nombre revistaDTO
   */
    public nombreRevista: string = null;


    public idComicActualizar: number = null;

    public comicActualizar: ComicDTO;
    /**
     * @description Este es el constructor del componente GestionarComicComponent
     * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
     */
    constructor(private fb: FormBuilder,
        private router: Router,
        private gestionarComicService: GestionarComicService) {
        this.gestionarComicForm = this.fb.group({
            nombre: [null, Validators.required],
            editorial: [null],
            tematica: [null],
            coleccion: [null],
            numeroPaginas: [null],
            precio: [null],
            autores: [null],
            color: [null]
        });
    }

    /**
     * @description Evento angular que se ejecuta al invocar el componente
     * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
     */
    ngOnInit(): void {
        console.log("Ingreso al al evento oninit");
        /*    this.comic = new ComicDTO();
            this.listaComics = new Array<ComicDTO>();
            this.idComic++;
            this.comic.id = this.idComic + "";
            this.comic.nombre = "Spider Man";
            this.comic.editorial = "Marvel";
            this.comic.tematica = "AVENTURAS";
            this.comic.coleccion = "12-2019";
            this.comic.numeroPaginas = 80;
            this.comic.precio = 15000;
            this.comic.autores = "Alex";
            this.comic.color = true;
            this.listaComics.push(this.comic); */
        this.comic = new ComicDTO();
        this.listaComics = new Array<ComicDTO>();
        this.consultarComics();
    }

    /**
     * @description Metodo que permite validar el formulario y crear o actualizar un comic
     */
    public crearActualizarComic(): void {
        this.submitted = true;
        if (this.gestionarComicForm.invalid) {
            return;
        }
        console.log("Contador idComic:" + this.idComic);
        console.log("ID ComicActualizar :" + this.idComicActualizar)
        console.log("Valor campo nombre actual:" + this.gestionarComicForm.controls.nombre);

       if (this.idComicActualizar !== null) {
        this.comic = new ComicDTO();
        
            let id = this.listaComics[this.idComicActualizar].id;
          /*  this.listaComics[this.idComicActualizar].nombre = this.gestionarComicForm.controls.nombre.value;
            this.listaComics[this.idComicActualizar].editorial = this.gestionarComicForm.controls.editorial.value;
            this.listaComics[this.idComicActualizar].tematica = this.gestionarComicForm.controls.tematica.value;
            this.listaComics[this.idComicActualizar].coleccion = this.gestionarComicForm.controls.coleccion.value;
            this.listaComics[this.idComicActualizar].numeroPaginas = this.gestionarComicForm.controls.numeroPaginas.value;
            this.listaComics[this.idComicActualizar].precio = this.gestionarComicForm.controls.precio.value;
            this.listaComics[this.idComicActualizar].autores = this.gestionarComicForm.controls.autores.value;
            this.listaComics[this.idComicActualizar].color = this.gestionarComicForm.controls.color.value;
            this.listaComics[this.idComicActualizar].cantidad = 13; */
            this.comic.id = id;
            this.comic.nombre = this.gestionarComicForm.controls.nombre.value;
            this.comic.editorial = this.gestionarComicForm.controls.editorial.value;
            this.comic.tematica = this.gestionarComicForm.controls.tematica.value;
            this.comic.coleccion = this.gestionarComicForm.controls.coleccion.value;
            this.comic.numeroPaginas = this.gestionarComicForm.controls.numeroPaginas.value;
            this.comic.precio = this.gestionarComicForm.controls.precio.value;
            this.comic.autores = this.gestionarComicForm.controls.autores.value;
            this.comic.color = this.gestionarComicForm.controls.color.value;
            this.comic.cantidad = 17; // Dato quemado falta arreglar el Backend
            this.gestionarComicService.modificarComic(id,"Ing. Alex",this.comic).subscribe(resultadoDTO => {
                if (resultadoDTO.exitoso) {
                    this.consultarComics();
                    this.limpiarFormulario();
                }
            }, error => {
                console.log(error);
            });
            this.idComicActualizar = null;
        } else { 
            // this.idComic++;
            this.comic = new ComicDTO();
           // this.comic.id = this.idComic + "";
            this.comic.nombre = this.gestionarComicForm.controls.nombre.value;
            this.comic.editorial = this.gestionarComicForm.controls.editorial.value;
            this.comic.tematica = this.gestionarComicForm.controls.tematica.value;
            this.comic.coleccion = this.gestionarComicForm.controls.coleccion.value;
            this.comic.numeroPaginas = this.gestionarComicForm.controls.numeroPaginas.value;
            this.comic.precio = this.gestionarComicForm.controls.precio.value;
            this.comic.autores = this.gestionarComicForm.controls.autores.value;
            this.comic.color = this.gestionarComicForm.controls.color.value;
            this.comic.cantidad = 12; // Dato quemado falta arreglar el Backend
            //      this.listaComics.push(this.comic);
            //      console.log("Contador idComic++:" + this.idComic);
            this.gestionarComicService.crearComic(this.comic).subscribe(resultadoDTO => {
                if (resultadoDTO.exitoso) {
                    this.consultarComics();
                    this.limpiarFormulario();
                }
            }, error => {
                console.log(error);
            });
        }
        this.limpiarFormulario();

    }

    /**
     * Metodo que permite consultar un comic de la tabla y sus detalles e inhabilitar el formulario
     * @param posicion en la lista del comic seleccionado
     */
    public consultarComic(posicion: number): void {
        let comic = this.listaComics[posicion];
        this.gestionarComicForm.controls.nombre.setValue(comic.nombre);
        this.gestionarComicForm.controls.editorial.setValue(comic.editorial);
        this.gestionarComicForm.controls.tematica.setValue(comic.tematica);
        this.gestionarComicForm.controls.coleccion.setValue(comic.coleccion);
        this.gestionarComicForm.controls.numeroPaginas.setValue(comic.numeroPaginas);
        this.gestionarComicForm.controls.precio.setValue(comic.precio);
        this.gestionarComicForm.controls.autores.setValue(comic.autores);
        this.gestionarComicForm.controls.color.setValue(comic.color);
        this.gestionarComicForm.controls.nombre.disable();
        this.gestionarComicForm.controls.editorial.disable();
        this.gestionarComicForm.controls.tematica.disable();
        this.gestionarComicForm.controls.coleccion.disable();
        this.gestionarComicForm.controls.numeroPaginas.disable();
        this.gestionarComicForm.controls.precio.disable();
        this.gestionarComicForm.controls.autores.disable();
        this.gestionarComicForm.controls.color.disable();

        this.idComicActualizar = null;

    }

    public editarComic(comic: any): void {
        this.router.navigate(['bienvenida', comic]);
    }

    private limpiarFormulario(): void {
        this.submitted = false;
        this.gestionarComicForm.controls.nombre.setValue(null);
        this.gestionarComicForm.controls.editorial.setValue(null);
        this.gestionarComicForm.controls.tematica.setValue(null);
        this.gestionarComicForm.controls.coleccion.setValue(null);
        this.gestionarComicForm.controls.numeroPaginas.setValue(null);
        this.gestionarComicForm.controls.precio.setValue(null);
        this.gestionarComicForm.controls.autores.setValue(null);
        this.gestionarComicForm.controls.color.setValue(null);
    }

    /**
     * @description Metodo que obtiene los controles y sus propiedades
     * @author Diego Fernando Alvarez Silva
     */
    get f() {
        return this.gestionarComicForm.controls;
    }

    /**
     * @description Metodo que elimina un comic de la lista de acuerdo al indice
     * @author Alex Fernando Caldas Garcia
     */
    public eliminarComic(posicion: number): void {
        let comic = this.listaComics[posicion];

        if (posicion >= 0 && posicion !== null) {
            console.log("Elimino la revista #: " + posicion);
            
            this.listaComics.splice(posicion, 1);
            console.log("Elimino la revista idComic: " + comic.id);
            this.gestionarComicService.eliminarComic(comic.id).subscribe(resultadoDTO => {
                if (resultadoDTO.exitoso) {
                    this.consultarComics();
                }
            }, error => {
                console.log(error);
            });
            this.nombreRevista = comic.nombre;
            this.mostrar = true;
            console.log("mostrar Alert: " + this.mostrar);

        } else {
            this.mostrar = false;
            console.log("mostrar Alert: " + this.mostrar);
        }
    }

    /**
  * Metodo que permite modificar un comic de la tabla y sus detalles
  * @param posicion en la lista del comic seleccionado
  */
    public modificarComic(posicion: number): void {
        let comic = this.listaComics[posicion];

        this.gestionarComicForm.controls.nombre.setValue(comic.nombre)
        this.gestionarComicForm.controls.editorial.setValue(comic.editorial);
        this.gestionarComicForm.controls.tematica.setValue(comic.tematica);
        this.gestionarComicForm.controls.coleccion.setValue(comic.coleccion);
        this.gestionarComicForm.controls.numeroPaginas.setValue(comic.numeroPaginas);
        this.gestionarComicForm.controls.precio.setValue(comic.precio);
        this.gestionarComicForm.controls.autores.setValue(comic.autores);
        this.gestionarComicForm.controls.color.setValue(comic.color);
        this.gestionarComicForm.controls.nombre.enable();
        this.gestionarComicForm.controls.editorial.enable();
        this.gestionarComicForm.controls.tematica.enable();
        this.gestionarComicForm.controls.coleccion.enable();
        this.gestionarComicForm.controls.numeroPaginas.enable();
        this.gestionarComicForm.controls.precio.enable();
        this.gestionarComicForm.controls.autores.enable();
        this.gestionarComicForm.controls.color.enable();

        this.idComicActualizar = posicion;
    }

    public consultarComics(): void {
        this.gestionarComicService.consultarComics().subscribe(listaComics => {
            this.listaComics = listaComics;
        }, error => {
            console.log(error);
        });
    }
}