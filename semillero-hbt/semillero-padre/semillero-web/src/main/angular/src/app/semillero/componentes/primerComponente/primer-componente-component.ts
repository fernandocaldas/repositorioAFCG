import { Component } from '@angular/core';

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
export class PrimerComponenteComponent {

    /**
     *  Nombre - estudiante Semillero
     */
    nombre: string = "Alex Fernando Caldas Garcia";
    /**
     *  Ciudad - estudiante Semillero
     */
    ciudad: string = "Tunja";
    /**
     *  Repositorio - estudiante Semillero
     */
    repositorio: string = "https://github.com/fernandocaldas/repositorioAFCG.git";

    constructor() {

    }

    ngOninit() {

    }
}
