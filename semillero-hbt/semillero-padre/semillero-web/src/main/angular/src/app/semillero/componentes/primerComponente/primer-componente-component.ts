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
    public nombre: string;
    /**
     *  Ciudad - estudiante Semillero
     */
    public ciudad: string;
    /**
     *  Repositorio - estudiante Semillero
     */
    public repositorio: string;

    public listaRevistaDTO : Array<RevistaDTO>;

    public revistaDTO : RevistaDTO;

    public nombreRevista : string;

    constructor() {

    }

    ngOnInit() : void {
        //Inicializar variables en OnInit siempre...
        this.nombre = "Alex Fernando Caldas Garcia";
        this.ciudad = "Tunja";
        this.repositorio = "https://github.com/fernandocaldas/repositorioAFCG.git";
       this.inicializarComponente();
       this.nombreRevista = null;
    }

    public inicializarComponente() : Array<RevistaDTO> {

        this.listaRevistaDTO = new Array<RevistaDTO>();
        this.revistaDTO = new RevistaDTO();
        this.revistaDTO.id =1;
        this.revistaDTO.nombre="batman";
        this.revistaDTO.editorial="marvel";
        this.revistaDTO.numeroPaginas=50;
        this.revistaDTO.precio= 60,500.99;
        this.revistaDTO.aColor=true;
        this.revistaDTO.fechaVenta=new Date();
        this.revistaDTO.estado="ACTIVO";
        this.listaRevistaDTO.push(this.revistaDTO);

        this.revistaDTO = new RevistaDTO();
        this.revistaDTO.id =2;
        this.revistaDTO.nombre="SuperMan";
        this.revistaDTO.editorial="DC";
        this.revistaDTO.numeroPaginas=60;
        this.revistaDTO.precio= 75,600.99;
        this.revistaDTO.aColor=true;
        this.revistaDTO.fechaVenta=new Date();
        this.revistaDTO.estado="ACTIVO";
        this.listaRevistaDTO.push(this.revistaDTO);

        this.revistaDTO = new RevistaDTO();
        this.revistaDTO.id =3;
        this.revistaDTO.nombre="Linterna Verde";
        this.revistaDTO.editorial="DC";
        this.revistaDTO.numeroPaginas=80;
        this.revistaDTO.precio= 45,550.99;
        this.revistaDTO.aColor=true;
        this.revistaDTO.fechaVenta=new Date();
        this.revistaDTO.estado="ACTIVO";
        this.listaRevistaDTO.push(this.revistaDTO);

        this.revistaDTO = new RevistaDTO();
        this.revistaDTO.id =4;
        this.revistaDTO.nombre="Spider Man";
        this.revistaDTO.editorial="marvel";
        this.revistaDTO.numeroPaginas=60;
        this.revistaDTO.precio= 50,800.99;
        this.revistaDTO.aColor=true;
        this.revistaDTO.fechaVenta=new Date();
        this.revistaDTO.estado="ACTIVO";
        this.listaRevistaDTO.push(this.revistaDTO);

        this.revistaDTO = new RevistaDTO();
        this.revistaDTO.id =5;
        this.revistaDTO.nombre="batman vs superman";
        this.revistaDTO.editorial="marvel";
        this.revistaDTO.numeroPaginas=85;
        this.revistaDTO.precio= 90,400.99;
        this.revistaDTO.aColor=true;
        this.revistaDTO.fechaVenta=new Date();
        this.revistaDTO.estado="ACTIVO";
        this.listaRevistaDTO.push(this.revistaDTO);  

        console.log(this.listaRevistaDTO);

        let lista = this.listaRevistaDTO;
        for (let i = 0; i < lista.length; i++) {
            const element = lista[i];
            console.log(element);            
        }

        return null;
    }

    public eliminarRevistaDTO(index : number) : string {

        //Consultar por index no por atributo del objeto | revisar
        this.nombreRevista = this.consultarRevistaDTO(index);

        console.log("Elimino la revista #: "+index);
        this.listaRevistaDTO.splice(index,1);

        return this.nombreRevista;
    }

    public consultarRevistaDTO(index : number) : string {

        let revista = this.listaRevistaDTO.find(revistaDTO => revistaDTO.id === index);
        alert("Consulto la revista #: "+revista.nombre);
        return revista.nombre;
    }

}
