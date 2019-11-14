/**
 * EjerciciosMaratonPojo.java
 */
package com.hbt.semillero.pojo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * <b>Descripción:<b> Clase que determina <b>Caso de Uso:<b>
 * 
 * @author FERNANDO
 * @version
 */
public class EjerciciosMaratonPojo {

	public boolean numeroPrimo(int num) {

		int contador = 2;
		boolean primo = true;
		while ((primo) && (contador != num)) {
			if (num % contador == 0)
				primo = false;
			contador++;
		}
		return primo;
	}

	public String CalcularFecha(String fechaNacimiento, int cantAnios) {

		// Crear un formateador como 2018-10-16
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("uuuu-MM-dd");

		// Lo convertimos a objeto para poder trabajar con él
		LocalDate fechaActual = LocalDate.parse(fechaNacimiento, formato);

		// Sumar los años indicados
		fechaActual = fechaActual.plusYears(cantAnios);

		// Formatear de nuevo y regresar como cadena
		return fechaActual.format(formato);

	}

	/**
	 * 
	 * Metodo encargado de cargar un vector de enteros <b>Caso de Uso</b>
	 * 
	 * @author FERNANDO
	 * 
	 * @param num
	 * @return
	 */
	public int[] ingresarNumerosVector(int index, int num) {

		int[] numeros = new int[4];

		numeros[index] = num;

		return numeros;
	}

	/**
	 * 
	 * Metodo encargado de ordenar de menor a mayor un vector de enteros <b>Caso de
	 * Uso</b>
	 * 
	 * @author FERNANDO
	 * 
	 * @param numeros
	 * @return
	 */
	public int[] ordenarVector(int[] numeros) {
		for (int x = 0; x < numeros.length; x++) {
			for (int i = 0; i < numeros.length - x - 1; i++) {
				if (numeros[i] < numeros[i + 1]) {
					int tmp = numeros[i + 1];
					numeros[i + 1] = numeros[i];
					numeros[i] = tmp;
				}
			}
		}

		int[] resultado = { numeros[0], numeros[numeros.length - 1], numeros.length };

		return resultado;
	}

	/**
	 * 
	 * Metodo encargado de gestionar cantidad de monedas de cambio <b>Caso de
	 * Uso</b>
	 * 
	 * @author FERNANDO
	 * 
	 * @param cambio
	 */

	public static void gestionarMonedas(double cambio) {
		int devolver = (int) (cambio * 1000);

		System.out.println("Para devolver" + cambio + " el Cambio es: ");

		if (devolver >= 1000) {
			System.out.println("Monedas de 1000 pesos:" + devolver / 1000);
			devolver %= 1000;
		}
		if (devolver >= 500) {
			System.out.println("Monedas de 500 pesos: " + devolver / 500);
			devolver %= 500;
		}
		if (devolver >= 200) {
			System.out.println("Monedas de 200 pesos:" + devolver / 200);
			devolver %= 200;
		}
		if (devolver >= 100) {
			System.out.println("Monedas de 100 pesos: " + devolver / 100);
			devolver %= 100;
		}
		if (devolver >= 50) {
			System.out.println("Monedas de 50 pesos: " + devolver / 50);
			devolver %= 50;
		}

	}
	
	/**
	 * 
	 * Metodo encargado Ejercicio 9
	 * <b>Caso de Uso</b>
	 * @author FERNANDO
	 * 
	 * @throws Exception
	 */
	public void ejercicio9() throws Exception {
		throw new Exception();
	}

}
