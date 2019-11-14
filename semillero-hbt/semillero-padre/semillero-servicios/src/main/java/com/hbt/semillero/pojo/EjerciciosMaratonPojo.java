/**
 * EjerciciosMaratonPojo.java
 */
package com.hbt.semillero.pojo;

/**
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author FERNANDO
 * @version 
 */
public class EjerciciosMaratonPojo {

		
	public boolean numeroPrimo(int num) {
		
		int contador = 2;
		boolean primo=true;
		while ((primo) && (contador!=num)){
		if (num % contador == 0)
		primo = false;
		contador++;
		}
		return primo;
	}
	
}
