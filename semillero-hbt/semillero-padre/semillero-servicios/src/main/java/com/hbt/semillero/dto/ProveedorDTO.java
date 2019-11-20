/**
 * ProveedorDTO.java
 */
package com.hbt.semillero.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import com.hbt.semillero.entidades.EstadoEnum;

/**
 * <b>Descripción:<b> Clase que determina <b>Caso de Uso:<b>
 * 
 * @author FERNANDO
 * @version
 */
public class ProveedorDTO implements Serializable {

	/**
	 * Atributo que determina
	 */
	private static final long serialVersionUID = -419762790765410228L;

	private String id;
	private String direccion;
	private LocalDate fechaCreacion;
	private Long idPersona;
	private EstadoEnum estadoEnum;
	private BigDecimal montoCredito;

	/**
	 * Constructor de la clase.
	 */
	public ProveedorDTO() {

	}

	/**
	 * Constructor de la clase.
	 * 
	 * @param id
	 * @param direccion
	 * @param fechaCreacion
	 * @param idPersona
	 * @param estadoEnum
	 * @param montoCredito
	 */
	public ProveedorDTO(String id, String direccion, LocalDate fechaCreacion, Long idPersona, EstadoEnum estadoEnum,
			BigDecimal montoCredito) {
		super();
		this.id = id;
		this.direccion = direccion;
		this.fechaCreacion = fechaCreacion;
		this.idPersona = idPersona;
		this.estadoEnum = estadoEnum;
		this.montoCredito = montoCredito;
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
	 * Metodo encargado de retornar el valor del atributo direccion
	 * 
	 * @return El direccion asociado a la clase
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo direccion
	 * 
	 * @param direccion El nuevo direccion a modificar.
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo fechaCreacion
	 * 
	 * @return El fechaCreacion asociado a la clase
	 */
	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo fechaCreacion
	 * 
	 * @param fechaCreacion El nuevo fechaCreacion a modificar.
	 */
	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo idPersona
	 * 
	 * @return El idPersona asociado a la clase
	 */
	public Long getIdPersona() {
		return idPersona;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo idPersona
	 * 
	 * @param idPersona El nuevo idPersona a modificar.
	 */
	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo estadoEnum
	 * 
	 * @return El estadoEnum asociado a la clase
	 */
	public EstadoEnum getEstadoEnum() {
		return estadoEnum;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo estadoEnum
	 * 
	 * @param estadoEnum El nuevo estadoEnum a modificar.
	 */
	public void setEstadoEnum(EstadoEnum estadoEnum) {
		this.estadoEnum = estadoEnum;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo montoCredito
	 * 
	 * @return El montoCredito asociado a la clase
	 */
	public BigDecimal getMontoCredito() {
		return montoCredito;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo montoCredito
	 * 
	 * @param montoCredito El nuevo montoCredito a modificar.
	 */
	public void setMontoCredito(BigDecimal montoCredito) {
		this.montoCredito = montoCredito;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo serialVersionUID
	 * 
	 * @return El serialversionuid asociado a la clase
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
