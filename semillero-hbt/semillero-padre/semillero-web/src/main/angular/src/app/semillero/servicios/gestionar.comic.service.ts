import { Injectable } from '@angular/core';
import { Injector } from "@angular/core";
import { Observable } from 'rxjs';
import 'rxjs/add/operator/toPromise';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ComicDTO } from '../dto/comic.dto';


/**
 * @description Servicio encargado de llamar a los servicios REST de gestionar comic
 * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
 */
@Injectable({
  providedIn: 'root'
})
export class GestionarComicService  {

  /**
   * Constructor de la clase
   */
  constructor(injector: Injector, private httpClient : HttpClient) {
   // super(injector);
  }
  
  /**
   * @description Metodo encargado de invocar el servicio REST consultar comics
   * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
   */
  public consultarComics(): Observable<any> {
    return this.httpClient.get('http://localhost:8085/semillero-servicios/rest/GestionarComic/consultarComics');
  }

  /**
   * @description Metodo encargado de invocar el servicio REST crear comic
   * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
   * @param comicDTO contiene la informacion del comic a persistir
   */
  public crearComic(comicDTO : ComicDTO): Observable<any> {
    debugger;
    return this.httpClient.post('http://localhost:8085/semillero-servicios/rest/GestionarComic/crear',comicDTO);
  }


    /**
   * @description Metodo encargado de invocar el servicio REST eliminar comic
   * @author Alex Fernando Caldas Garcia <fernandocaldasg@gmail.com>
   * @param comicDTO contiene la informacion del comic a modificar
   */
  public modificarComic(idComic : string, nombre:string,comicDTO:ComicDTO): Observable<any> {
    debugger;
    return this.httpClient.post('http://localhost:8085/semillero-servicios/rest/GestionarComic/modificar/'+idComic+'/'+nombre,comicDTO);
  }

  /**
   * @description Metodo encargado de invocar el servicio REST eliminar comic
   * @author Alex Fernando Caldas Garcia <fernandocaldasg@gmail.com>
   * @param idComic contiene la informacion del comic a eliminar
   */
  public eliminarComic(idComic : string): Observable<any> {
    debugger;
    return this.httpClient.post('http://localhost:8085/semillero-servicios/rest/GestionarComic/eliminar',idComic);
  }
}
