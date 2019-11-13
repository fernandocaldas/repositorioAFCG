import { Component, OnInit } from '@angular/core';
import { ComicDTO } from '../../../dto/comic.dto';
import { ActivatedRoute } from '@angular/router';

/**
 * @description Componenete consultar comic, el cual contiene la logica Consultar, recibe los parametros por URL
 * 
 * @author Alex Fernando Caldas Garcia 
 */
@Component({
    selector: 'consultar-comic',
    templateUrl: './consultar-comic.html',
    styleUrls: ['./consultar-comic.css']
})
export class ConsultarComicComponent implements OnInit {

    /**
     * Atributo que contendra la informacion del comic
     */
    public comic: ComicDTO;

    constructor(private activatedRoute: ActivatedRoute) { }

    /**
     * Evento angular que se ejecuta al invocar el componente
     */
    ngOnInit(): void {
        this.comic = new ComicDTO();

        let data = this.activatedRoute.snapshot.params;
        //console.log("Parametros recibidos: " + JSON.stringify(data));

        this.comic.nombre = data.nombre;
        this.comic.editorial = data.editorial;
        this.comic.tematica = data.tematica;
        this.comic.coleccion = data.coleccion;
        this.comic.numeroPaginas = data.numeroPaginas;
        this.comic.precio = data.precio;
        this.comic.autores = data.autores;
        this.comic.color = data.color;
    }
}