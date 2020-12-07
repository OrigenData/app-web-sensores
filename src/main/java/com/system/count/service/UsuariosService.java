package com.system.count.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.system.count.model.Usuarios;

public interface UsuariosService {
	
	/**
	 * Metodo para mostrar usuarios
	 * @return
	 */
	public List<Usuarios> findAll();
	
	
	/**
	 * Metodo para guardar usuario nuevo o actualizar
	 * @param usuarios
	 * @return
	 */
	public Usuarios save(Usuarios usuarios);
	
	
	/**
	 * Burcar usuario por id
	 * @param id
	 * @return
	 */
	public Optional<Usuarios> findById(Long id);
	
	
	/**
	 * Burcar usuario por usuario
	 * @param id
	 * @return
	 */
	public Usuarios findByUsername(String usuario);
		
	
	/**
	 * Eliminar usuario por ID
	 * @param id
	 * @return 
	 * @return
	 */
	public void delete(Usuarios usuarios);
	

}
