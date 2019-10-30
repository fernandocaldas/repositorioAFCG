/**
 * EstadoEnum.java
 */
package com.hbt.semillero.entidades;

/**
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author FERNANDO
 * @version 
 */
public enum EstadoEnum {

	ACTIVO("enum.estado.activo"),
	INACTIVO("enum.estado.inactivo");
	
	private String CodigoMensaje;

	/**
	 * Constructor de la clase.
	 * 
	 * @param codigoMensaje
	 */
	private EstadoEnum(String codigoMensaje) {
		CodigoMensaje = codigoMensaje;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo CodigoMensaje
	 * 
	 * @return El codigoMensaje asociado a la clase
	 */
	public String getCodigoMensaje() {
		return CodigoMensaje;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo CodigoMensaje
	 * 
	 * @param codigoMensaje El nuevo codigoMensaje a modificar.
	 */
	public void setCodigoMensaje(String codigoMensaje) {
		CodigoMensaje = codigoMensaje;
	}
}
