/**
 * GestionarComicPOJOTest.java
 */
package com.hbt.semillero.servicios;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.entidades.EstadoEnum;
import com.hbt.semillero.entidades.TematicaEnum;
import com.hbt.semillero.pojo.GestionarComicPOJO;

/**
 * <b>Descripción:<b> Clase para probar CRUD GestionarComicPOJO <b>Caso de
 * Uso:<b>
 * 
 * @author FERNANDO
 * @version
 */
public class GestionarComicPOJOTest {

	GestionarComicPOJO gestionarComicPOJO = new GestionarComicPOJO();

	public void shouldAnswerWithTrue() {

	}

	@Test
	public void testAgregarComicDTO() {
		// GestionarComicPOJO gestionarComicPOJO = new GestionarComicPOJO();

		ComicDTO comicDTO = gestionarComicPOJO.crearComicDTO("100", "Captain America Corps 1-5 USA", "Panini Comics",
				TematicaEnum.FANTASTICO, "BIBLIOTECA MARVEL", 128, new BigDecimal(5000),
				"Phillippe Briones, Roger Stern", Boolean.FALSE, LocalDate.now(), EstadoEnum.ACTIVO, 5L);

		gestionarComicPOJO.agregarComicDTOLista(comicDTO);

		Assert.assertNotNull(gestionarComicPOJO.getListaComics());
		Assert.assertTrue(!gestionarComicPOJO.getListaComics().isEmpty());
		Assert.assertTrue(gestionarComicPOJO.getListaComics().size() == 1);

		comicDTO = new ComicDTO();
		comicDTO = gestionarComicPOJO.crearComicDTO("101", "Dragon ball Yamcha", "Planeta Cómic",
				TematicaEnum.FANTASTICO, "Manga Shonen", 100, new BigDecimal(2100), "Dragon Garow Lee", Boolean.TRUE,
				LocalDate.now(), EstadoEnum.ACTIVO, 20L);
		gestionarComicPOJO.agregarComicDTOLista(comicDTO);

		Assert.assertTrue(gestionarComicPOJO.getListaComics().size() > 1);

		comicDTO = new ComicDTO();
		comicDTO = gestionarComicPOJO.crearComicDTO("102", "Fantastic Four: Grand Design (2019) #1", "Panini Comics",
				TematicaEnum.FANTASTICO, "BIBLIOTECA MARVEL", 130, new BigDecimal(16000),
				"Daron Jensen, Tom Scioli, Stuart Vandal", Boolean.TRUE, LocalDate.now(), EstadoEnum.ACTIVO, 2L);
		gestionarComicPOJO.agregarComicDTOLista(comicDTO);

		comicDTO = new ComicDTO();
		comicDTO = gestionarComicPOJO.crearComicDTO("103", "Doctor Strange Anual (2019) # 1", "Panini Comics",
				TematicaEnum.FANTASTICO, "BIBLIOTECA MARVEL", 150, new BigDecimal(14500), "Tini Howard", Boolean.TRUE,
				LocalDate.now(), EstadoEnum.ACTIVO, 3L);
		gestionarComicPOJO.agregarComicDTOLista(comicDTO);

		Assert.assertTrue(gestionarComicPOJO.getListaComics().size() == 4);
		
		System.out.println("\nNombresComicIniciales");
		for (int i = 0; i < gestionarComicPOJO.getListaComics().size(); i++) {
			System.out.println(i+" : "+gestionarComicPOJO.getListaComics().get(i).getNombre());
		}
	}

	@Test
	public void testModificarComicDTOListaTest() {
		// GestionarComicPOJO gestionarComicPOJO = new GestionarComicPOJO();

		gestionarComicPOJO.modificarComicDTOLista("102", "Fantastic Four: Grand Design");

		System.out.println("\nNombresComicModificación");
		for (int i = 0; i < gestionarComicPOJO.getListaComics().size(); i++) {
			System.out.println(i+" : "+gestionarComicPOJO.getListaComics().get(i).getNombre());
		}
		
		Assert.assertTrue(gestionarComicPOJO.getListaComics().size() == 3);
	}

	@Test
	public void testEliminarComicDTOLista() {
		//GestionarComicPOJO gestionarComicPOJO = new GestionarComicPOJO();
		gestionarComicPOJO.eliminarComicDTO("101");
		
		System.out.println("\nNombresComicEliminación");
		for (int i = 0; i < gestionarComicPOJO.getListaComics().size(); i++) {
			System.out.println(i+" : "+gestionarComicPOJO.getListaComics().get(i).getNombre());
		}
		
		Assert.assertTrue(gestionarComicPOJO.getListaComics().size() == 3);
	}

}
