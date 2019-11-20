/**
 * GestionarComicRest.java
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

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.dto.ResultadoDTO;
import com.hbt.semillero.ejb.IGestionarComicLocal;

/**
 * <b>Descripción:<b> Clase que determina el servicio rest que permite gestionar
 * un comic
 * 
 * @author FERNANDO
 * @version
 */
@Path("/GestionarComic")
public class GestionarComicRest {

	/**
	 * Atriburo que permite gestionar un comic
	 */
	@EJB
	private IGestionarComicLocal gestionarComicEJB;

	/**
	 * 
	 * Metodo encargado de traer la informacion de un comic determiando
	 * http://localhost:8085/semillero-servicios/rest/GestionarComic/saludo
	 * 
	 * @param idComic
	 * @return
	 */
	@GET
	@Path("/saludo")
	@Produces(MediaType.APPLICATION_JSON)
	public String primerRest() {
		return "Prueba inicial servicios rest en el semillero java hbt";
	}

	/**
	 * 
	 * Metodo encargado de traer la informacion de un comic determiando
	 * http://localhost:8085/semillero-servicios/rest/GestionarComic/consultarComics
	 * 
	 * @param idComic
	 * @return
	 */
	@GET
	@Path("/consultarComics")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ComicDTO> consultarComic() {
		return gestionarComicEJB.consultarComics();

	}

	/**
	 * 
	 * Metodo encargado de traer la informacion de un comic determiando
	 * http://localhost:8085/semillero-servicios/rest/GestionarComic/consultarComic?idComic=1
	 * 
	 * @param idComic
	 * @return
	 */
	@GET
	@Path("/consultarComic")
	@Produces(MediaType.APPLICATION_JSON)
	public ComicDTO consultarComic(@QueryParam("idComic") Long idComic) {
		if (idComic != null) {
			ComicDTO comicDTO = gestionarComicEJB.consultarComic(idComic.toString());
			return comicDTO;
		}
		return null;
	}

	/**
	 * Crea las personas en sus diferentes roles dentro del sistema.
	 * http://localhost:8085/semillero-servicios/rest/GestionarComic/crear
	 * @param persona
	 * @return
	 */
	@POST
	@Path("/crear")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResultadoDTO crearComic(ComicDTO comicDTO) {
		System.out.println("Entro a crear comic....");
		System.out.println("getId "+comicDTO.getId());
		System.out.println("getNombre "+comicDTO.getNombre());
		System.out.println("getAutores "+comicDTO.getAutores());
		System.out.println("getColeccion "+comicDTO.getColeccion());
		System.out.println("getColeccion "+comicDTO.getColeccion());
		System.out.println("getCantidad "+comicDTO.getCantidad());
		System.out.println("getColor "+comicDTO.getColor());
		System.out.println("getEstadoEnum "+comicDTO.getEstadoEnum());
		System.out.println("getNumeroPaginas "+comicDTO.getNumeroPaginas());
		System.out.println("getPrecio "+comicDTO.getPrecio());
		System.out.println("getTematicaEnum "+comicDTO.getTematicaEnum());
		
		gestionarComicEJB.crearComic(comicDTO);
		ResultadoDTO resultadoDTO = new ResultadoDTO(Boolean.TRUE, "Comic creado exitosamente");
		return resultadoDTO;
		
	}

	/**
	 * 
	 * Metodo encargado de modificar el nombre de un comic
	 * http://localhost:8085/semillero-servicios/rest/GestionarComic/modificar?idComic=1&nombre=nuevonombre
	 * @param idComic identificador del comic a buscar
	 * @param nombre nombre nuevo del comic
	 */
	@POST
	@Path("/modificar/{idComic}/{nombre}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResultadoDTO modificarComic(@PathParam("idComic")Long idComic,@PathParam("nombre") String nombre,ComicDTO comicDTO) {
		System.out.println("Entro a modificar comic....");
		System.out.println("idComic: "+ idComic);
		System.out.println("nombre: "+ nombre);
		gestionarComicEJB.modificarComic(idComic, nombre, comicDTO);
		ResultadoDTO resultadoDTO = new ResultadoDTO(Boolean.TRUE, "Comic Actualizado exitosamente");
		return resultadoDTO;
	}

	/**
	 * 
	 * Metodo encargado de eliminar un comic dado el id
	 * 
	 * @param idComic identificador del comic
	 */
	@POST
	@Path("/eliminar")
	public ResultadoDTO eliminarComic(Long idComic) {
		System.out.println("Entro a eliminar comic....");
		System.out.println("idComic: "+idComic);
		if (idComic != null) {
			//ComicDTO comicDTO = gestionarComicEJB.consultarComic(idComic.toString());
			gestionarComicEJB.eliminarComic(idComic);
			ResultadoDTO resultadoDTO = new ResultadoDTO(Boolean.TRUE, "Comic Eliminado exitosamente");
			return resultadoDTO;
		}else {
			ResultadoDTO resultadoDTO = new ResultadoDTO(Boolean.FALSE, "Error al eliminar comic");
			return resultadoDTO;
		}
	}
}