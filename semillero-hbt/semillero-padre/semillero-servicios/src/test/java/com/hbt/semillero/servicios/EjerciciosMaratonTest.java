/**
 * EjerciciosMaratonTest.java
 */
package com.hbt.semillero.servicios;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hbt.semillero.pojo.EjerciciosMaratonPojo;

/**
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author FERNANDO
 * @version 
 */
public class EjerciciosMaratonTest {

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
	
	@Test
	/**
	 * 
	 * Metodo encargado de calcular la fecha actual dado fecha nacimiento y años
	 * <b>Caso de Uso</b>
	 * @author FERNANDO
	 *
	 */
	public void testEjercicio4() {
		EjerciciosMaratonPojo e = new EjerciciosMaratonPojo();		
		System.out.println("Fecha Resultado " + e.CalcularFecha("1992-07-23", 27));
	}
	
	
	@Test
	/**
	 * 
	 * Metodo encargado de el ingreso de numeros a un metodo y ordenar un vector
	 * <b>Caso de Uso</b>
	 * @author FERNANDO
	 *
	 */
	public void testEjercicio5() {
		EjerciciosMaratonPojo e = new EjerciciosMaratonPojo();
		
		int[] numeros = new int[4];
		int[] resultado = new int[4];
		
		numeros[0] = 50;
		numeros[1] = 1;
		numeros[2] = 249;
		numeros[3] = -2;
		
//		numeros = e.ingresarNumerosVector(0,50);
//		numeros = e.ingresarNumerosVector(1,1);
//		numeros = e.ingresarNumerosVector(2,249);
//		numeros = e.ingresarNumerosVector(3,-2);
		
		
		resultado = e.ordenarVector(numeros);
		
		Assert.assertEquals(resultado[0], -2);
		Assert.assertEquals(resultado[2], 249);
		System.out.println("Cantidad de elementos: "+ resultado.length);
		
	}
	
	@Test
	/**
	 * 
	 * Metodo encargado de determinar quien gana un juego de tenis
	 * <b>Caso de Uso</b>
	 * @author FERNANDO
	 *
	 */
	public void testEjercicio7() {
		
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(3,"Roger Federer");
		map.put(2,"Roger Federer");
		map.put(6,"Domminic Thiem");
		map.put(6,"Domminic Thiem");
		
//		// Imprimimos el Map con un Iterador
//		Iterator it = map.keySet().iterator();
//		while(it.hasNext()){
//		  Integer key = it.next();
//		  System.out.println("Clave: " + key + " -> Valor: " + map.get(key));
//		}
	}
	
	
	
}
