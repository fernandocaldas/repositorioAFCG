package com.hbt.semillero.servicios;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hbt.semillero.entidades.Comic;
import com.hbt.semillero.entidades.EstadoEnum;

public class AppTest {

	public void shouldAnswerWithTrue() {

	}

	@Test
	public void primeraPU() {
		Long sumando1 = 150L;
		Long sumando2 = 50L;
		Long resultadoEsperado = 150L;
		Long resultado = sumando1 + sumando2;

		if (resultado == resultadoEsperado) {
			Assert.assertEquals(resultado, resultadoEsperado);
			resultadoEsperado = 200L;
			Assert.assertNotEquals(resultado, resultadoEsperado);
		}
	}

	private String invertirCadena(String cadena) {

		String cadenaInvertida = "";

		for (int x = cadena.length() - 1; x >= 0; x--) {

			cadenaInvertida = cadenaInvertida + cadena.charAt(x);

		}

		return cadenaInvertida;

	}

	@Test
	public void pruebaInvertirCadena() {

		String cadenaInvertidaResult = invertirCadena("123456789");
		String cadenaInvertidaEsperada = "987654321";

		if (cadenaInvertidaResult == cadenaInvertidaEsperada || cadenaInvertidaResult.equals(cadenaInvertidaEsperada)) {
			
			Assert.assertEquals(cadenaInvertidaResult, cadenaInvertidaEsperada);
			
			cadenaInvertidaEsperada = "";
			Assert.assertNotEquals(cadenaInvertidaResult, cadenaInvertidaEsperada);
			
			cadenaInvertidaEsperada = null;
			Assert.assertNotEquals(cadenaInvertidaResult, cadenaInvertidaEsperada);
			
			cadenaInvertidaEsperada = "123456789";
			Assert.assertNotEquals(cadenaInvertidaResult, cadenaInvertidaEsperada);
			
			cadenaInvertidaEsperada = null;
			Assert.assertNull(cadenaInvertidaEsperada);
			
			cadenaInvertidaEsperada = "987654321";
			Assert.assertTrue(cadenaInvertidaResult.equals(cadenaInvertidaEsperada));
			
			Assert.assertNotNull(cadenaInvertidaResult);
			
		}

	}
	
	// TODO
	/*
	 * Pendiente hacer metodo que use el metodo ToString de la entidad Comic
	 */
	@Test
	public void pruebaComicToString() {
		Comic comic = new Comic();
		comic.setAutores("NombreAutor");
		System.out.println("El metodo toString de Comic Contiene: "+ comic.toString());		
	}
	
	@Test
	public void pruebaEstadoEnum() {
		
		//Devuelve un String con el nombre de la constante ACTIVO
		EstadoEnum estadoEnumActivo = EstadoEnum.ACTIVO;		
		System.out.println("estadoEnumActivo.name(): "+estadoEnumActivo.name());
		
		//Devuelve un String con el nombre de la constante INACTIVO
		EstadoEnum estadoEnumInactivo = EstadoEnum.	INACTIVO;
		System.out.println("estadoEnumInactivo.name(): "+estadoEnumInactivo.name());
		
		//Devolver un entero con la posición del enum según está declarada
		System.out.println("estadoEnumActivo.ordinal(): "+estadoEnumActivo.ordinal());
		System.out.println("estadoEnumInactivo.ordinal(): "+estadoEnumInactivo.ordinal());
		
		//Comparar el enum con el parámetro según el orden en el que están declarados lo enum
		System.out.println("estadoEnumActivo.compareTo(estadoEnumInactivo)= "+estadoEnumActivo.compareTo(estadoEnumInactivo));
		
		//Devolver un array que contiene todos los enum
		for(EstadoEnum estEnum: EstadoEnum.values()){
			System.out.println("Estado: "+estEnum.toString());
		}
		
	}
}
