/**
 * GestionarComicBean.java
 */
package com.hbt.semillero.ejb;

import java.util.ArrayList;
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
public class GestionarComicBean implements IGestionarComicLocal {

	@PersistenceContext
	private EntityManager em;

	/**
	 * 
	 * Metodo encargado de crear un comic <b>Caso de Uso</b>
	 * 
	 * @author FERNANDO
	 * 
	 * @param comicDTO
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW) // Verifica si hay transaccion activa, y sino la crea
	public void crearComic(ComicDTO comicDTO) {

		Comic comic = convertirComicDTOToComic(comicDTO);
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
		comic.setId(Long.parseLong(comicModificar.getId()));
		comic.setNombre(comicModificar.getNombre());
		comic.setEditorial(comicModificar.getEditorial());
		comic.setTematicaEnum(comicModificar.getTematicaEnum());
		comic.setColeccion(comicModificar.getColeccion());
		comic.setNumeroPaginas(comicModificar.getNumeroPaginas());
		comic.setPrecio(comicModificar.getPrecio());
		comic.setAutores(comicModificar.getAutores());
		comic.setColor(comicModificar.getColor());
		comic.setFechaVenta(comicModificar.getFechaVenta());
		comic.setEstadoEnum(comicModificar.getEstadoEnum());
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

		Comic comic = em.find(Comic.class, Long.parseLong(idComic));
		// ComicDTO comicDTO = new ComicDTO(comic.getId(), comic.getNombre());
		ComicDTO comicDTO = convertirComicToComicDTO(comic);

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

		// em.createNamedQuery("SELECT c form Comic");
		List<Comic> resultados = (List<Comic>) em.createQuery("select c from Comic").getResultList();

		return null;
	}

	/**
	 * @see com.hbt.semillero.ejb.IGestionarComicLocal#modificarComic(java.lang.Long,
	 *      java.lang.String, com.hbt.semillero.dto.ComicDTO)
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	// TODO cual es el resultado de llamar a modificarComic
	public void modificarComic(Long id, String nombre, ComicDTO comicNuevo) {
		Comic comicModificar;

		if (comicNuevo == null) {
			comicModificar = em.find(Comic.class, id); // por debajo hace un select en la BD
		} else {
			comicModificar = convertirComicDTOToComic(comicNuevo);
		}
		//comicModificar.setNombre(nombre);
		// TODO hacer validacion si el comic a modificar llega con datos
		em.merge(comicModificar);

	}

	/**
	 * @see com.hbt.semillero.ejb.IGestionarComicLocal#eliminarComic(java.lang.Long)
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void eliminarComic(Long idComic) {
		if(idComic != null) {
			Comic comic = em.find(Comic.class, idComic);			
			em.remove(comic);	
		}			
	}

	/**
	 * @see com.hbt.semillero.ejb.IGestionarComicLocal#consultarComics()
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<ComicDTO> consultarComics() {
		// TODO hacer que la lista que retorna sea nula y ver que sucede
		List<ComicDTO> resultadosComicDTO = new ArrayList<ComicDTO>();
		List<Comic> resultados = em.createQuery("select c from Comic c").getResultList();
		for (Comic comic : resultados) {
			resultadosComicDTO.add(convertirComicToComicDTO(comic));
		}
		return resultadosComicDTO;
	}

	/**
	 * 
	 * Metodo encargado de traspasar informacion de un lugar a otro, no tiene
	 * transaccionalidad <b>Caso de Uso</b>
	 * 
	 * @author FERNANDO
	 * 
	 * @param comicDTO
	 * @return
	 */
	private Comic convertirComicDTOToComic(ComicDTO comicDTO) {
		Comic comic = new Comic();
		if (comicDTO.getId() != null) {
			comic.setId(Long.parseLong(comicDTO.getId()));
		}
		comic.setNombre(comicDTO.getNombre());
		comic.setEditorial(comicDTO.getEditorial());
		comic.setTematicaEnum(comicDTO.getTematicaEnum());
		comic.setColeccion(comicDTO.getColeccion());
		comic.setNumeroPaginas(comicDTO.getNumeroPaginas());
		comic.setPrecio(comicDTO.getPrecio());
		comic.setAutores(comicDTO.getAutores());
		comic.setColor(comicDTO.getColor());
		comic.setFechaVenta(comicDTO.getFechaVenta());
		comic.setEstadoEnum(comicDTO.getEstadoEnum());
		comic.setCantidad(comicDTO.getCantidad());
		return comic;
	}

	private ComicDTO convertirComicToComicDTO(Comic comic) {
		ComicDTO comicDTO = new ComicDTO();
		if (comic.getId() != null) {
			comicDTO.setId(comic.getId().toString());
		}
		comicDTO.setNombre(comic.getNombre());
		comicDTO.setEditorial(comic.getEditorial());
		comicDTO.setTematicaEnum(comic.getTematicaEnum());
		comicDTO.setColeccion(comic.getColeccion());
		comicDTO.setNumeroPaginas(comic.getNumeroPaginas());
		comicDTO.setPrecio(comic.getPrecio());
		comicDTO.setAutores(comic.getAutores());
		comicDTO.setColor(comic.getColor());
		comicDTO.setFechaVenta(comic.getFechaVenta());
		comicDTO.setEstadoEnum(comic.getEstadoEnum());
		comicDTO.setCantidad(comic.getCantidad());
		return comicDTO;
	}

}
