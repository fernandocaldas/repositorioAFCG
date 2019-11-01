/**
 * GestionarComicPOJO.java
 */
package com.hbt.semillero.pojo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.entidades.EstadoEnum;
import com.hbt.semillero.entidades.TematicaEnum;

/**
 * <b>Descripción:<b> Clase que determina <b>Caso de Uso:<b>
 * 
 * @author FERNANDO
 * @version
 */
public class GestionarComicPOJO {

	private List<ComicDTO> listaComics = null;

	/**
	 * 
	 * Metodo encargado de Crear comicDTO
	 * <b>Caso de Uso</b>
	 * @author FERNANDO
	 *
	 */
	public void crearComicDTO() {
		ComicDTO comicDTO = new ComicDTO();

		comicDTO.setId("101");
		comicDTO.setNombre("Dragon ball Yamcha");
		comicDTO.setEditorial("planeta Cómic");
		comicDTO.setTematicaEnum(TematicaEnum.AVENTURAS);
		comicDTO.setColeccion("Manga Shonen");
		comicDTO.setNumeroPaginas(100);
		comicDTO.setPrecio(new BigDecimal(2100));
		comicDTO.setAutores("Dragon Garow lee");
		comicDTO.setColor(Boolean.FALSE);
		comicDTO.setFechaVenta(LocalDate.now());
		comicDTO.setEstadoEnum(EstadoEnum.ACTIVO);
		comicDTO.setCantidad(20L);
		if (listaComics == null) {
			listaComics = new ArrayList<>();
		}
		listaComics.add(comicDTO);
		
		comicDTO = new ComicDTO();
		comicDTO = crearComicDTO("102", "Fantastic Four: Grand Design (2019) #1", "Panini Comics",
				TematicaEnum.FANTASTICO, "BIBLIOTECA MARVEL", 130, new BigDecimal(16000),
				"Daron Jensen, Tom Scioli, Stuart Vandal", Boolean.TRUE, LocalDate.now(), EstadoEnum.ACTIVO, 2L);
		listaComics.add(comicDTO);

		comicDTO = new ComicDTO();
		comicDTO = crearComicDTO("103", "Doctor Strange Anual (2019) # 1", "Panini Comics",
				TematicaEnum.FANTASTICO, "BIBLIOTECA MARVEL", 150, new BigDecimal(14500), "Tini Howard", Boolean.TRUE,
				LocalDate.now(), EstadoEnum.ACTIVO, 3L);
		listaComics.add(comicDTO);
	}

	/**
	 * 
	 * Metodo encargado de Crear Comic DTO ingresando parametros al metodo retorna ComicDTO
	 * <b>Caso de Uso</b>
	 * @author FERNANDO
	 * 
	 * @param id
	 * @param nombre
	 * @param editorial
	 * @param tematicaEnum
	 * @param coleccion
	 * @param numeroPaginas
	 * @param precio
	 * @param autores
	 * @param color
	 * @param fechaVenta
	 * @param estadoEnum
	 * @param cantidad
	 * @return
	 */
	public ComicDTO crearComicDTO(String id, String nombre, String editorial, TematicaEnum tematicaEnum,
			String coleccion, Integer numeroPaginas, BigDecimal precio, String autores, Boolean color,
			LocalDate fechaVenta, EstadoEnum estadoEnum, Long cantidad) {
		ComicDTO comicDTO = new ComicDTO();

		comicDTO.setId(id);
		comicDTO.setNombre(nombre);
		comicDTO.setEditorial(editorial);
		comicDTO.setTematicaEnum(tematicaEnum);
		comicDTO.setColeccion(coleccion);
		comicDTO.setNumeroPaginas(numeroPaginas);
		comicDTO.setPrecio(precio);
		comicDTO.setAutores(autores);
		comicDTO.setColor(color);
		comicDTO.setFechaVenta(fechaVenta);
		comicDTO.setEstadoEnum(estadoEnum);
		comicDTO.setCantidad(cantidad);

		return comicDTO;
	}

	/**
	 * Metodo encargado de agregar un ComicDTO a una lista tipo ComicDTO
	 * 
	 */
	public void agregarComicDTOLista(ComicDTO comicDTO) {
		if (listaComics == null) {
			listaComics = new ArrayList<>();
		}
		listaComics.add(comicDTO);
	}

	/**
	 * 
	 * Metodo encargado de modificar la lista ingresando el indice del array y el objeto comic a modificado
	 * <b>Caso de Uso</b>
	 * @author FERNANDO
	 * 
	 * @param index
	 * @param comicDTO
	 */
	public void modificarComicDTOLista(int index, ComicDTO comicDTO) {
		listaComics.set(index, comicDTO);
	}

	/**
	 * 
	 * Metodo encargado de modificar Comic de la lista ingresando el id del comic y el nuevo nombre
	 * <b>Caso de Uso</b>
	 * @author FERNANDO
	 * 
	 * @param idComic
	 * @param nombre
	 */
	public void modificarComicDTOLista(String idComic, String nombre) {

		ComicDTO comicModificar = null;
		for (int i = 0; i < listaComics.size(); i++) {
			comicModificar = listaComics.get(i);
			if (comicModificar.getId().equals(idComic)) {
				comicModificar.setNombre(nombre);
				return;
			}
		}

	}

	/**
	 * 
	 * Metodo encargado de eliminar un comic de la lista ingresando el id del comic
	 * <b>Caso de Uso</b>
	 * @author FERNANDO
	 * 
	 * @param idComic
	 */
	public void eliminarComicDTO(String idComic) {
		for (int i = 0; i < listaComics.size(); i++) {
			if (listaComics.get(i).getId().equals(idComic)) {
				listaComics.remove(i);
				return;
			}
		}
//		int i = 0;
//		while( i < listaComics.size()) {			
//			if (listaComics.get(i).getId().equals(idComic)) {
//				listaComics.remove(i);
//				return;
//			}
//			i++;
//		}
	}

	/**
	 * Metodo encargado de retornar el valor del atributo listaComics
	 * 
	 * @return El listaComics asociado a la clase
	 */
	public List<ComicDTO> getListaComics() {
		return listaComics;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo listaComics
	 * 
	 * @param listaComics El nuevo listaComics a modificar.
	 */
	public void setListaComics(List<ComicDTO> listaComics) {
		this.listaComics = listaComics;
	}

}
