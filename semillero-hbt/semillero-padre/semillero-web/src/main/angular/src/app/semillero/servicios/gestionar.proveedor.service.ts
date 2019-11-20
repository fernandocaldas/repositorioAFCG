import { Injectable } from '@angular/core';
import { Injector } from "@angular/core";
import { Observable } from 'rxjs';
import 'rxjs/add/operator/toPromise';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ProveedorDTO } from '../dto/proveedor.dto';


/**
 * @description Servicio encargado de llamar a los servicios REST de gestionar proveedor
 * @author Alex Fernando Caldas Garcia <>
 */
@Injectable({
  providedIn: 'root'
})
export class GestionarProveedorService  {

  /**
   * Constructor de la clase
   */
  constructor(injector: Injector, private httpClient : HttpClient) {
   // super(injector);
  }
  
  /**
   * @description Metodo encargado de invocar el servicio REST consultar proveedores
   * @authorAlex Fernando Caldas Garcia <>
   */
  public consultarProveedores(): Observable<any> {
    return this.httpClient.get('http://localhost:8085/semillero-servicios/rest/GestionarProveedor/consultarProveedores');
  }

  /**
   * @description Metodo encargado de invocar el servicio REST crear un proveedor
   * @author Alex Fernando Caldas Garcia <>
   * @param proveedorDTO contiene la informacion del proveedor a persistir
   */
  public crearProveedor(proveedorDTO : ProveedorDTO): Observable<any> {
    debugger;
    return this.httpClient.post('http://localhost:8085/semillero-servicios/rest/GestionarProveedor/crear',proveedorDTO);
  }


    /**
   * @description Metodo encargado de invocar el servicio REST modificar proveedor
   * @author Alex Fernando Caldas Garcia <fernandocaldasg@gmail.com>
   * @param proveedorDTO contiene la informacion del proveedor a modificar
   */
  public modificarProveedor(idProveedor : string, proveedorDTO : ProveedorDTO): Observable<any> {
    debugger;
    return this.httpClient.post('http://localhost:8085/semillero-servicios/rest/GestionarProveedor/modificar/'+idProveedor,proveedorDTO);
  }

  /**
   * @description Metodo encargado de invocar el servicio REST eliminar proveedor
   * @author Alex Fernando Caldas Garcia <fernandocaldasg@gmail.com>
   * @param idProveedor contiene la informacion del proveedor a eliminar
   */
  public eliminarProveedor(idProveedor : string): Observable<any> {
    debugger;
    return this.httpClient.post('http://localhost:8085/semillero-servicios/rest/GestionarProveedor/eliminar',idProveedor);
  }
}
