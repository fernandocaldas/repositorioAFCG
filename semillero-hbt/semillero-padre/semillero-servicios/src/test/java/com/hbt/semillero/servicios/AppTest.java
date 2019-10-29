package com.hbt.semillero.servicios;

import org.testng.Assert;
import org.testng.annotations.Test;

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
			Assert.assertEquals(resultado, resultadoEsperado);
		}
	}

	private String invertirCadena(String cadena) {

		String cadenaInvertida = "";

		for (int x = cadena.length() - 1; x >= 0; x--) {

			cadenaInvertida = cadenaInvertida + cadena.charAt(x);

		}

		return cadenaInvertida;

	}
	
	public void pruebaInvertirCadena() {
		invertirCadena("123456789");
	}
}
