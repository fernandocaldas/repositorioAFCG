import { Component, OnInit } from '@angular/core';
import { ProveedorDTO } from '../../../dto/proveedor.dto';
import { ActivatedRoute } from '@angular/router';

/**
 * @description Componenete consultar proveedor, el cual contiene la logica Consultar, recibe los parametros por URL
 * 
 * @author Alex Fernando Caldas Garcia 
 */
@Component({
    selector: 'consultar-proveedor',
    templateUrl: './consultar-proveedor.component.html',
    styleUrls: ['./consultar-proveedor.component.css']
})
export class ConsultarProveedorComponent implements OnInit {

    /**
     * Atributo que contendra la informacion del proveedor
     */
    public proveedor: ProveedorDTO;

    constructor(private activatedRoute: ActivatedRoute) { }

    /**
     * Evento angular que se ejecuta al invocar el componente
     */
    ngOnInit(): void {
        this.proveedor = new ProveedorDTO();

        let data = this.activatedRoute.snapshot.params;
        let persona =  this.activatedRoute.snapshot.params.persona;
        debugger;
        this.proveedor.direccion = data.direccion;
        this.proveedor.fechaCreacion = data.fechaCreacion;
        this.proveedor.montoCredito = data.montoCredito;
        this.proveedor.persona.nombre = data.persona.nombre;
        this.proveedor.persona.identificacion = data.persona.identificacion;
    }
}