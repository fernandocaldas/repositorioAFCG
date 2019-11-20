import { PersonaDTO } from './persona.dto';

/**
 * @description Clase ProveedorDTO que contiene la informacion de un proveedor
 * 
 * @author Alex Fernando Caldas Garcia <>
 */

export class ProveedorDTO {

/**
    * Indicador de resultado.
    */
   public id: string;

   /**
   * Indicador de resultado.
   */
   public direccion: string;

   /**
   * Indicador de resultado.
   */
   public fechaCreacion: string;

   /**
    * Indicador de resultado.
    */
   public persona: PersonaDTO;

   /**
   * Indicador de resultado.
   */
   public estado: string;

   /**
   * Indicador de resultado.
   */
   public montoCredito: string;

    
}