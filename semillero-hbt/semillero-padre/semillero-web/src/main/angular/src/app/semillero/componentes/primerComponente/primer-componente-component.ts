import { Component } from '@angular/core';


/**
 * @description Componenete gestionar el primer componente - Ejecricio Sesion 1 Angular
 * 
 * @author Alex Fernando Caldas Garcia <fernandocaldasg@gmail.com.co>
 */
@Component({
    selector: 'primer-componente',
    templateUrl: './primer-componente-component.html',
    styleUrls: ['./primer-componente-component.css']
})
export class PrimerComponenteComponent {

    nombre: string = "Alex Fernando Caldas Garcia";
    ciudad: string = "Tunja";
    repositorio: string = "https://github.com/fernandocaldas/repositorioAFCG.git";

    constructor() {

    }

    ngOninit() {

    }
}
