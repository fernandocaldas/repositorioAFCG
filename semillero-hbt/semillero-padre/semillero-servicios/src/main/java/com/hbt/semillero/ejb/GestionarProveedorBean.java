/**
 * GestionarProveedorBean.java
 */
package com.hbt.semillero.ejb;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.hbt.semillero.dto.PersonaDTO;
import com.hbt.semillero.dto.ProveedorDTO;
import com.hbt.semillero.entidades.Persona;
import com.hbt.semillero.entidades.Proveedor;

/**
 * <b>Descripción:<b> Clase donde se encuentran los metodos CRUD para gestionar
 * un proveedor <b>Caso de Uso:<b>
 * 
 * @author FERNANDO
 * @version
 */
@Stateless
public class GestionarProveedorBean implements IGestionarProveedorLocal {

	@PersistenceContext
	private EntityManager em;

	/**
	 * 
	 * Metodo encargado de crear un proveedor <b>Caso de Uso</b>
	 * 
	 * @author FERNANDO
	 * 
	 * @param proveedorDTO
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void crearProveedor(ProveedorDTO proveedorDTO) {
		LocalDate fecha = LocalDate.now();
		System.out.println("Entro a metodo crear proveedor en BEAN...");

		Persona persona = convertirPersonaDTOToPersona(proveedorDTO.getPersona());
		em.persist(persona);

		Proveedor proveedor = convertirProveedorDTOToProveedor(proveedorDTO);
		proveedor.setFechaCreacion(fecha);
		proveedor.setPersona(persona);
		em.persist(proveedor);

	}

	/**
	 * @see com.hbt.semillero.ejb.IGestionarProveedorLocal#modificarProveedor(java.lang.Long,
	 *      com.hbt.semillero.dto.ProveedorDTO)
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	//TODO Revisar funcionamiento....
	public void modificarProveedor(Long id, ProveedorDTO proveedorNuevo) {
		Proveedor proveedorModificar;
		Persona personaModificar;
		
		if(proveedorNuevo == null) {
			personaModificar = em.find(Persona.class, id);
		}else {
			personaModificar = convertirPersonaDTOToPersona(proveedorNuevo.getPersona());
		}
		em.merge(personaModificar);
		
		if (proveedorNuevo == null) {
			proveedorModificar = em.find(Proveedor.class, id);			
		} else {			
			proveedorModificar = convertirProveedorDTOToProveedor(proveedorNuevo);
			proveedorModificar.setPersona(personaModificar);			
		}
		em.merge(proveedorModificar);
		

	}

	/**
	 * @see com.hbt.semillero.ejb.IGestionarProveedorLocal#eliminarProveedor(java.lang.Long)
	 */
	@Override
	public void eliminarProveedor(Long idProveedor) {
		if (idProveedor != null) {
			Proveedor proveedor = em.find(Proveedor.class, idProveedor);
			em.remove(proveedor);

			Persona persona = em.find(Persona.class, idProveedor);
			em.remove(persona);
		}
	}

	/**
	 * @see com.hbt.semillero.ejb.IGestionarProveedorLocal#consultarProveedor(java.lang.String)
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public ProveedorDTO consultarProveedor(String idProveedor) {
		Proveedor proveedor = em.find(Proveedor.class, Long.parseLong(idProveedor));

		ProveedorDTO proveedorDTO = convertirProveedorToProveedorDTO(proveedor);

		return proveedorDTO;
	}

	/**
	 * @see com.hbt.semillero.ejb.IGestionarProveedorLocal#consultarProveedores()
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<ProveedorDTO> consultarProveedores() {
		List<ProveedorDTO> resultadosProveedorDTO = new ArrayList<ProveedorDTO>();
		List<Proveedor> resultados = em.createQuery("select p from Proveedor p").getResultList();
		for (Proveedor proveedor : resultados) {
			resultadosProveedorDTO.add(convertirProveedorToProveedorDTO(proveedor));
		}
		return resultadosProveedorDTO;
	}

	private Persona convertirPersonaDTOToPersona(PersonaDTO personaDTO) {
		Persona persona = new Persona();
		if (personaDTO.getId() != null) {
			persona.setId(Long.parseLong(personaDTO.getId()));
		}
		persona.setNombre(personaDTO.getNombre());
		persona.setIdentificacion(personaDTO.getIdentificacion());

		return persona;
	}

	private PersonaDTO convertirPersonaToPersonaDTO(Persona persona) {
		PersonaDTO personaDTO = new PersonaDTO();
		if (persona.getId() != null) {
			personaDTO.setId(persona.getId().toString());
		}
		personaDTO.setNombre(persona.getNombre());
		personaDTO.setIdentificacion(persona.getIdentificacion());

		return personaDTO;
	}

	private Proveedor convertirProveedorDTOToProveedor(ProveedorDTO proveedorDTO) {
		Proveedor proveedor = new Proveedor();
		if (proveedorDTO.getId() != null) {
			proveedor.setId(Long.parseLong(proveedorDTO.getId()));
		}
		proveedor.setDireccion(proveedorDTO.getDireccion());
		proveedor.setFechaCreacion(proveedorDTO.getFechaCreacion());
		proveedor.setPersona(convertirPersonaDTOToPersona(proveedorDTO.getPersona())); 
		proveedor.setEstadoEnum(proveedorDTO.getEstadoEnum());
		proveedor.setMontoCredito(proveedorDTO.getMontoCredito());

		return proveedor;
	}

	private ProveedorDTO convertirProveedorToProveedorDTO(Proveedor proveedor) {
		ProveedorDTO proveedorDTO = new ProveedorDTO();
		if (proveedor.getId() != null) {
			proveedorDTO.setId(proveedor.getId().toString());
		}

		proveedorDTO.setDireccion(proveedor.getDireccion());
		proveedorDTO.setEstadoEnum(proveedor.getEstadoEnum());
		proveedorDTO.setFechaCreacion(proveedor.getFechaCreacion());
		proveedorDTO.setPersona(convertirPersonaToPersonaDTO(proveedor.getPersona()));
		proveedorDTO.setMontoCredito(proveedor.getMontoCredito());

		return proveedorDTO;
	}

}
