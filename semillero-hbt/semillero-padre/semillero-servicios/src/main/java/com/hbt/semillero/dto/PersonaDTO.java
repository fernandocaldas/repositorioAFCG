/**
 * PersonaDTO.java
 */
package com.hbt.semillero.dto;

import java.io.Serializable;

/**
 * <b>Descripción:<b> Clase que determina <b>Caso de Uso:<b>
 * 
 * @author FERNANDO
 * @version
 */
public class PersonaDTO implements Serializable {

	/**
	 * Atributo que determina  
	 */
	private static final long serialVersionUID = -646313915285615348L;
	
	private String id;
	private String nombre;
	private String identificacion;

	/**
	 * Constructor de la clase.
	 */
	public PersonaDTO() {
	}

	/**
	 * Constructor de la clase.
	 * 
	 * @param id
	 * @param nombre
	 * @param identificacion
	 */
	public PersonaDTO(String id, String nombre, String identificacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.identificacion = identificacion;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo id
	 * 
	 * @return El id asociado a la clase
	 */
	public String getId() {
		return id;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo id
	 * 
	 * @param id El nuevo id a modificar.
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo nombre
	 * 
	 * @return El nombre asociado a la clase
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo nombre
	 * 
	 * @param nombre El nuevo nombre a modificar.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo identificacion
	 * 
	 * @return El identificacion asociado a la clase
	 */
	public String getIdentificacion() {
		return identificacion;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo identificacion
	 * 
	 * @param identificacion El nuevo identificacion a modificar.
	 */
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

}
