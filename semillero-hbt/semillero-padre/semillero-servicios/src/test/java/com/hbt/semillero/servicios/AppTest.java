package com.hbt.semillero.servicios;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.entidades.Comic;
import com.hbt.semillero.entidades.EstadoEnum;
import com.hbt.semillero.pojo.EjerciciosMaratonPojo;
import com.hbt.semillero.pojo.GestionarComicPOJO;

public class AppTest {

	public void shouldAnswerWithTrue() {

	}

	
	@Test(enabled = false)
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

	@Test(enabled = false)
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
	
	@Test(enabled = false)
	public void pruebaComicToString() {
		Comic comic = new Comic();
		comic.setAutores("NombreAutor");
		System.out.println("El metodo toString de Comic Contiene: "+ comic.toString());		
	}
	
	@Test (enabled = false)
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
	
//	@Test //(enabled = false)
//	public void pruebaTiposString() {
//		String s1 = "street";
//		String s2;
//		
//		s2 = new String ("street");
//		
//		
//		if(s1 == s2) {
//			Assert.assertEquals(s1, s2);
//		}
//		Assert.assertNotEquals(s1, s2);
//	}
	
	
//	public void pruebaEjecricio1() {
//		 
//		
//		String A$B =null;
//		String _helloword =null;
//		String Public =null;
//		
//		Assert.assertNotNull(A$B);
//		Assert.assertNotNull(_helloword);
//		Assert.assertNotNull(_helloword);
//		
//		System.out.println("Opcion C: true: es una palabra reservada");
//		
//	}
//	private static  String brand = "";
//	private static  boolean empty = false;
//	@Test
//	public static void testejercicio2(){
//		
//		
//		//WaterBottle wb = new WaterBottle();
//		System.out.println("Empty ="+ empty);
//		System.out.println("Brand = "+brand);
//	}
	
	@Test
	public void testEjercicio3() {
		
		EjerciciosMaratonPojo e = new EjerciciosMaratonPojo();

		System.out.println("Es numero "+5 +" es primo? "+e.numeroPrimo(5));
		System.out.println("Es numero "+222 +" es primo? "+e.numeroPrimo(222));
		System.out.println("Es numero "+0 +" es primo? "+e.numeroPrimo(0));
		
		Assert.assertEquals(e.numeroPrimo(5), true);
		Assert.assertEquals(e.numeroPrimo(222), false);
		Assert.assertEquals(e.numeroPrimo(0), false);

		
	}

}
