/**
 * Proveedor.java
 */
package com.hbt.semillero.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * <b>Descripción:<b> Clase que determina la entidad que permite representar la
 * tabla "DB_SEMILLERO"."TC_PROVEEDOR" <b>Caso de Uso:<b>
 * 
 * @author FERNANDO
 * @version
 */
@Entity
@Table(name = "TC_PROVEEDOR")
public class Proveedor implements Serializable {

	/**
	 * Atributo que determina
	 */
	private static final long serialVersionUID = -3125003507987276646L;

	private Long id;
	private String direccion;
	private LocalDate fechaCreacion;
	private Persona persona;
	private EstadoEnum estadoEnum;
	private BigDecimal montoCredito;

	/**
	 * Constructor de la clase.
	 */
	public Proveedor() {
	}

	/**
	 * Metodo encargado de retornar el valor del atributo id
	 * 
	 * @return El id asociado a la clase
	 */
	@Id
	@SequenceGenerator(allocationSize = 1, name = "PROVEEDOR_SPID_GENERATOR", sequenceName = "SEQ_PROVEEDOR")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PROVEEDOR_SPID_GENERATOR")
	@Column(name = "SPID")
	public Long getId() {
		return id;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo id
	 * 
	 * @param id El nuevo id a modificar.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo direccion
	 * 
	 * @return El direccion asociado a la clase
	 */
	@Column(name = "SPDIRECCION")
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
	@Column(name = "SPFECHA_CREACION")
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
	@ManyToOne
	@JoinColumn(name = "SPIDPERSONA")
	public Persona getPersona() {
		return persona;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo idPersona
	 * 
	 * @param idPersona El nuevo idPersona a modificar.
	 */
	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo estadoEnum
	 * 
	 * @return El estadoEnum asociado a la clase
	 */
	@Column(name = "SPESTADO")
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
	@Column(name = "SPMONTO_CREDITO")
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

}
