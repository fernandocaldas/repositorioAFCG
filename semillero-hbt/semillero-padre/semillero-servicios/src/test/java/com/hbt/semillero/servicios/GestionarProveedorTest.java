/**
 * GestionarProveedorTest.java
 */
package com.hbt.semillero.servicios;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.ejb.EJB;

import com.hbt.semillero.dto.PersonaDTO;
import com.hbt.semillero.dto.ProveedorDTO;
import com.hbt.semillero.ejb.IGestionarProveedorLocal;
import com.hbt.semillero.entidades.EstadoEnum;
import com.hbt.semillero.rest.GestionarProveedorRest;

/**
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author FERNANDO
 * @version 
 */
public class GestionarProveedorTest {

	@EJB
	IGestionarProveedorLocal gestionarProveedorEJB;
	
	public static void main(String[] args ) {
		System.out.println("Hola mundo");
		
		GestionarProveedorRest rest = new GestionarProveedorRest();
	
		LocalDate fecha = LocalDate.now();
		PersonaDTO personaDTO = new PersonaDTO();
		personaDTO.setIdentificacion("1049663317");
		personaDTO.setNombre("Alex Caldas");

		ProveedorDTO proveedorDTO = new ProveedorDTO();
		proveedorDTO.setDireccion("Calle 24 35 -80");
		proveedorDTO.setEstadoEnum(EstadoEnum.ACTIVO);
		proveedorDTO.setIdPersona(personaDTO);
		proveedorDTO.setFechaCreacion(fecha);
		proveedorDTO.setMontoCredito(new BigDecimal(5000));

		rest.crearProveedor(proveedorDTO);
	}
}
