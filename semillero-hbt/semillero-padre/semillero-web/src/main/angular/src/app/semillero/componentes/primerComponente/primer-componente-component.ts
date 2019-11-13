import { Component, OnInit } from '@angular/core';
import { RevistaDTO } from '../../dto/revista.dto';

/**
 * @description Componente gestiona el primer-componente - Ejercicio Sesion 1 Angular 30102019
 * 
 * @author Alex Fernando Caldas Garcia <fernandocaldasg@gmail.com.co>
 */
@Component({
    selector: 'primer-componente',
    templateUrl: './primer-componente-component.html',
    styleUrls: ['./primer-componente-component.css']
})
export class PrimerComponenteComponent implements OnInit {

    //Declarar variables Globales con public o private segun requerimiento y colocar el tipo de dato.
    /**
     *  Nombre - estudiante Semillero
     */
    public nombreEst: string;
    /**
     *  Ciudad - estudiante Semillero
     */
    public ciudadEst: string;
    /**
     *  Repositorio - estudiante Semillero
     */
    public repositorioEst: string;


    /**
     *  Lista de revistasDTO
     */
    public listaRevistaDTO: Array<RevistaDTO>;

    /**
     *  revistaDTO
     */
    public revistaDTO: RevistaDTO;

    /**
     *  Nombre revistaDTO
     */
    public nombreRevista: string = null;

    /**
     *  variable para mostrar o ocultar mensaje
     */
    public mostrar: boolean = false;

    constructor() {

    }

    ngOnInit(): void {
        //Inicializar variables en OnInit siempre...
        this.nombreEst = "Alex Fernando Caldas Garcia";
        this.ciudadEst = "Tunja";
        this.repositorioEst = "https://github.com/fernandocaldas/repositorioAFCG.git";
        this.inicializarComponente();
    }

    public inicializarComponente(): Array<RevistaDTO> {

        this.listaRevistaDTO = new Array<RevistaDTO>();
        this.revistaDTO = new RevistaDTO();
        this.revistaDTO.id = 101;
        this.revistaDTO.nombre = "batman";
        this.revistaDTO.editorial = "marvel";
        this.revistaDTO.numeroPaginas = 50;
        this.revistaDTO.precio = 60, 500.99;
        this.revistaDTO.aColor = true;
        this.revistaDTO.fechaVenta = new Date();
        this.revistaDTO.estado = "ACTIVO";
        this.listaRevistaDTO.push(this.revistaDTO);

        this.revistaDTO = new RevistaDTO();
        this.revistaDTO.id = 102;
        this.revistaDTO.nombre = "SuperMan";
        this.revistaDTO.editorial = "DC";
        this.revistaDTO.numeroPaginas = 60;
        this.revistaDTO.precio = 75, 600.99;
        this.revistaDTO.aColor = true;
        this.revistaDTO.fechaVenta = new Date();
        this.revistaDTO.estado = "ACTIVO";
        this.listaRevistaDTO.push(this.revistaDTO);

        this.revistaDTO = new RevistaDTO();
        this.revistaDTO.id = 103;
        this.revistaDTO.nombre = "Linterna Verde";
        this.revistaDTO.editorial = "DC";
        this.revistaDTO.numeroPaginas = 80;
        this.revistaDTO.precio = 45, 550.99;
        this.revistaDTO.aColor = true;
        this.revistaDTO.fechaVenta = new Date();
        this.revistaDTO.estado = "ACTIVO";
        this.listaRevistaDTO.push(this.revistaDTO);

        this.revistaDTO = new RevistaDTO();
        this.revistaDTO.id = 104;
        this.revistaDTO.nombre = "Spider Man";
        this.revistaDTO.editorial = "marvel";
        this.revistaDTO.numeroPaginas = 60;
        this.revistaDTO.precio = 50, 800.99;
        this.revistaDTO.aColor = false;
        this.revistaDTO.fechaVenta = new Date();
        this.revistaDTO.estado = "ACTIVO";
        this.listaRevistaDTO.push(this.revistaDTO);

        this.revistaDTO = new RevistaDTO();
        this.revistaDTO.id = 105;
        this.revistaDTO.nombre = "batman vs superman";
        this.revistaDTO.editorial = "marvel";
        this.revistaDTO.numeroPaginas = 85;
        this.revistaDTO.precio = 90, 400.99;
        this.revistaDTO.aColor = true;
        this.revistaDTO.fechaVenta = new Date();
        this.revistaDTO.estado = "ACTIVO";
        this.listaRevistaDTO.push(this.revistaDTO);

        console.log(this.listaRevistaDTO);

        let lista = this.listaRevistaDTO;
        for (let i = 0; i < lista.length; i++) {
            const element = lista[i];
            console.log(element);
        }

        return null;
    }

    /**
     * Metodo que recibe el index para eliminar de la listarevistaDTO una revista
     * @param index 
     */
    public eliminarRevistaDTO(index: number): void {

        let eliminada = this.consultarRevistaDTO(index);

        if (index >= 0 && index !== null && eliminada !== false) {

            console.log("Elimino la revista #: " + index);
            this.listaRevistaDTO.splice(index, 1);
            this.mostrar = true;
            console.log("mostrar vale: " + this.mostrar);

        } else {
            this.mostrar = false;
            console.log("mostrar vale: " + this.mostrar);
        }
    }

    /**
     * Metodo que recibe el index y consulta en el array listarevistaDTO para recuperar el nombre de una revista
     * @param index 
     */
    public consultarRevistaDTO(index: number): boolean {

        let revistaEliminada = this.listaRevistaDTO[index];
        console.log("Revista consultada:  " + revistaEliminada);

        if (revistaEliminada !== null && revistaEliminada !== undefined) {
            this.nombreRevista = revistaEliminada.nombre;
            return true;
        } else {
            alert("¡La revista # "+index+" no existe en la Lista!");
            return false;
        }
    }

}
