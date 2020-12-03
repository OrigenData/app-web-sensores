package com.system.count.service;

import java.util.List;
import java.util.Optional;

import com.system.count.model.Usuarios;

public interface UsuariosService {
	
	/**
	 * Metodo para mostrar usuarios
	 * @return
	 */
	public List<Usuarios> getAllUsuarios();
	
	
	/**
	 * Metodo para guardar usuario nuevo o actualizar
	 * @param usuarios
	 * @return
	 */
	public Usuarios saveUsuarios(Usuarios usuarios);
	
	
	/**
	 * Burcar usuario por id
	 * @param id
	 * @return
	 */
	public Optional<Usuarios> getById(Long id);
	
	
	/**
	 * Burcar usuario por usuario
	 * @param id
	 * @return
	 */
	public Usuarios getByUsuario(String usuario);
		
	
	/**
	 * Eliminar usuario por ID
	 * @param id
	 * @return
	 */
	public boolean deleteUsuariosById(Long id);
	

}
