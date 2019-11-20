/**
 * IGestionarProveedorLocal.java
 */
package com.hbt.semillero.ejb;

import java.util.List;

import javax.ejb.Local;

import com.hbt.semillero.dto.PersonaDTO;
import com.hbt.semillero.dto.ProveedorDTO;

/**
 * Expone los métodos del EJB GestionarProveedor Las interfaces determinan una
 * especie de contrato donde se define las firmas de los metodos, define que se
 * necesita implementar pero no el como eso lo realiza la clase que la
 * implementa Palabras claves interface e implements
 * <b>Caso de Uso:<b> 
 * @author FERNANDO
 * @version 
 */
@Local
public interface IGestionarProveedorLocal {

	
	/**
	 * 
	 * Metodo encargado de crear un proveedor y persistirlo
	 * 
	 * @author FERNANDO
	 * 
	 * @param proveedorNuevo informacion nueva a crear
	 */
	public void crearProveedor(ProveedorDTO proveedorDTO,PersonaDTO personaDTO);

	/**
	 * 
	 * Metodo encargado de consultar un proveedor modificarlo y guardarlo
	 * 
	 * @author FERNANDO
	 * 
	 * @param Modificar informacion nueva a modificar
	 */
	public void modificarProveedor(Long id, ProveedorDTO proveedorNuevo);

	/**
	 * 
	 * Metodo encargado de eliminar un proveedor modificarlo y guardarlo
	 * 
	 * @author FERNANDO
	 * 
	 * @param Eliminar informacion a eliminar
	 */
	public void eliminarProveedor(Long idProveedor);

	/**
	 * 
	 * Metodo encargado de retornar la informacion de un proveedor
	 * 
	 * @param idProveedor identificador del proveedor a ser consultado
	 * @return proveedor Resultado de la consulta
	 * @throws Exception si no se recibe idProveedor
	 */
	public ProveedorDTO consultarProveedor(String idProveedor);

	/**
	 * 
	 * Metodo encargado de retornar una lista de comics
	 * 
	 * @return
	 */
	public List<ProveedorDTO> consultarProveedores();
	
}
