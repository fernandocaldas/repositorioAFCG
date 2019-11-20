/**
 * GestionarProveedorRest.java
 */
package com.hbt.semillero.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hbt.semillero.dto.ProveedorDTO;
import com.hbt.semillero.dto.ResultadoDTO;
import com.hbt.semillero.ejb.IGestionarProveedorLocal;

/**
 * <b>Descripción:<b> Clase que determina <b>Caso de Uso:<b>
 * 
 * @author FERNANDO
 * @version
 */
@Path("/GestionarProveedor")
public class GestionarProveedorRest {

	/**
	 * Atriburo que permite gestionar un proveedor
	 */
	@EJB
	private IGestionarProveedorLocal gestionarProveedorEJB;

	@GET
	@Path("/saludo")
	@Produces(MediaType.APPLICATION_JSON)
	public String primerRest(@QueryParam("mensaje") String mensaje) {
		System.out.println("Entro a saludo.... mensaje: " + mensaje);
		return "Prueba inicial servicios rest Proveedor en el semillero java hbt";
	}

	/**
	 * Crea los proveedores en sus diferentes roles dentro del sistema.
	 * http://localhost:8085/semillero-servicios/rest/GestionarProveedor/crear
	 * 
	 * @param proveedor
	 * @return
	 */
	@POST
	@Path("/crear")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResultadoDTO crearProveedor(ProveedorDTO proveedorDTO) {
		
		
		System.out.println("Entro a crear proveedor....");
		System.out.println("Valores proveedoorDTO: "+proveedorDTO.toString());
		System.out.println("proveedorDTO: direccion..." + proveedorDTO.getDireccion());
		System.out.println("proveedorDTO: getEstadoEnum..." + proveedorDTO.getEstadoEnum());
		System.out.println("proveedorDTO: getIdPersona getIdentificacion..." + proveedorDTO.getIdPersona().getIdentificacion());
		System.out.println("proveedorDTO: getIdPersona getNombre..." + proveedorDTO.getIdPersona().getNombre());
		gestionarProveedorEJB.crearProveedor(proveedorDTO);
		ResultadoDTO resultadoDTO = new ResultadoDTO(Boolean.TRUE, "Proveedor creado exitosamente");
		return resultadoDTO;

	}

	/**
	 * 
	 * Metodo encargado de traer listado de proveedores
	 * http://localhost:8085/semillero-servicios/rest/GestionarProveedor/
	 */
	@GET
	@Path("/consultarProveedores")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProveedorDTO> consultarProveedores() {
		return gestionarProveedorEJB.consultarProveedores();

	}

	/**
	 * 
	 * Metodo encargado de traer la informacion de un proveedor determiando
	 * http://localhost:8085/semillero-servicios/rest/GestionarProveedor
	 * 
	 */
	@GET
	@Path("/consultarProveedor")
	@Produces(MediaType.APPLICATION_JSON)
	public ProveedorDTO consultarProveedor(@QueryParam("idProveedor") Long idProveedor) {
		if (idProveedor != null) {
			ProveedorDTO proveedorDTO = gestionarProveedorEJB.consultarProveedor(idProveedor.toString());
			return proveedorDTO;
		}
		return null;
	}

	/**
	 * 
	 * Metodo encargado de modificar la informacion de un proveedor
	 * http://localhost:8085/semillero-servicios/rest/GestionarProveedor/
	 * 
	 * @param idProveedor identificador del proveedor a buscar
	 */
	@POST
	@Path("/modificar/{idProveedor}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResultadoDTO modificarProveedor(@PathParam("idProveedor") Long idProveedor, ProveedorDTO proveedorDTO) {
		System.out.println("Entro a modificar proveedor....");
		gestionarProveedorEJB.modificarProveedor(idProveedor, proveedorDTO);
		ResultadoDTO resultadoDTO = new ResultadoDTO(Boolean.TRUE, "Proveedor Actualizado exitosamente");
		return resultadoDTO;
	}

	/**
	 * 
	 * Metodo encargado de eliminar un proveedor dado el id
	 * 
	 * @param idProveedor identificador del proveedor
	 */
	@POST
	@Path("/eliminar")
	public ResultadoDTO eliminarProveedor(Long idProveedor) {
		System.out.println("Entro a eliminar proveedor....");
		System.out.println("idProveedor: " + idProveedor);
		if (idProveedor != null) {
			gestionarProveedorEJB.eliminarProveedor(idProveedor);
			ResultadoDTO resultadoDTO = new ResultadoDTO(Boolean.TRUE, "Proveedor Eliminado exitosamente");
			return resultadoDTO;
		} else {
			ResultadoDTO resultadoDTO = new ResultadoDTO(Boolean.FALSE, "Error al eliminar Proveedor");
			return resultadoDTO;
		}
	}
}
