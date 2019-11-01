/**
 * GestionarComicBean.java
 */
package com.hbt.semillero.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.entidades.Comic;

/**
 * <b>Descripción:<b> Clase que determina <b>Caso de Uso:<b>
 * 
 * @author FERNANDO
 * @version
 */
@Stateless
public class GestionarComicBean {

	@PersistenceContext
	private EntityManager em;

	// TODO agregar interfaz y comentar los metodos
	/**
	 * 
	 * Metodo encargado de crear un comic <b>Caso de Uso</b>
	 * 
	 * @author FERNANDO
	 * 
	 * @param comicDTO
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void crearComic(ComicDTO comicDTO) {

		Comic comic = new Comic();
		comic.setId(comicDTO.getId());
		comic.setNombre(comicDTO.getNombre());
		comic.setEditorial(comicDTO.getEditorial());
		comic.setTematicaEnum(comicDTO.getTematicaEnum().getCodigoMensaje());
		comic.setColeccion(comicDTO.getColeccion());
		comic.setNumeroPaginas(comicDTO.getNumeroPaginas());
		comic.setPrecio(comicDTO.getPrecio());
		comic.setAutores(comicDTO.getAutores());
		comic.setColor(comicDTO.getColor());
		comic.setFechaVenta(comicDTO.getFechaVenta());
		comic.setEstadoEnum(comicDTO.getEstadoEnum().getCodigoMensaje());
		comic.setCantidad(comicDTO.getCantidad());

		em.persist(comic);
	}

	/**
	 * 
	 * Metodo encargado de modificar un comic <b>Caso de Uso</b>
	 * 
	 * @author FERNANDO
	 * 
	 * @param comicModificar
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void modificarComic(ComicDTO comicModificar) {
		
		Comic comic = new Comic();
		comic.setId(comicModificar.getId());
		comic.setNombre(comicModificar.getNombre());
		comic.setEditorial(comicModificar.getEditorial());
		comic.setTematicaEnum(comicModificar.getTematicaEnum().getCodigoMensaje());
		comic.setColeccion(comicModificar.getColeccion());
		comic.setNumeroPaginas(comicModificar.getNumeroPaginas());
		comic.setPrecio(comicModificar.getPrecio());
		comic.setAutores(comicModificar.getAutores());
		comic.setColor(comicModificar.getColor());
		comic.setFechaVenta(comicModificar.getFechaVenta());
		comic.setEstadoEnum(comicModificar.getEstadoEnum().getCodigoMensaje());
		comic.setCantidad(comicModificar.getCantidad());
		
		em.merge(comic);
	}

	/**
	 * 
	 * Metodo encargado de consultar por id un comic <b>Caso de Uso</b>
	 * 
	 * @author FERNANDO
	 * 
	 * @param idComic
	 * @return
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public ComicDTO consultarComic(String idComic) {
		
		Comic comic = em.find(Comic.class, idComic);
		ComicDTO comicDTO = new ComicDTO(comic.getId(), comic.getNombre());
		
		return comicDTO;
	}

	/**
	 * 
	 * Metodo encargado de consultar todos los comic retorna lista Comics <b>Caso de
	 * Uso</b>
	 * 
	 * @author FERNANDO
	 * 
	 * @param idComic
	 * @return
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<ComicDTO> consultarTodosComic() {
		
		//em.createNamedQuery("SELECT c form Comic");
		List<Comic> resultados = (List<Comic>) em.createQuery("select c from Comic").getResultList();

		return null;
	}

}
