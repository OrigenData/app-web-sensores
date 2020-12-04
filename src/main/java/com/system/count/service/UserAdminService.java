package com.system.count.service;

import com.system.count.model.Usuarios;

public interface UserAdminService {

	/**
	 * Buscar si existe un administrador en la base de datos
	 * @param tipo es el capo: 0 es Administrador
	 * @return true si existe
	 */
	public boolean existsAdmin(String rol);
	
	
	/**
	 * Metodo para crear el adiministrador nuevo o actualizar
	 * @param usuarios
	 * @return
	 */
	public Usuarios createAdmin(Usuarios usuarios);
}
