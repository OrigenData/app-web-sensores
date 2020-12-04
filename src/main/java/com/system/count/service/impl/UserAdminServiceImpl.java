package com.system.count.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.count.model.Usuarios;
import com.system.count.repository.UsuariosRepository;
import com.system.count.service.UserAdminService;

@Service
public class UserAdminServiceImpl implements UserAdminService{

	@Autowired
	UsuariosRepository repository;
	
	@Override
	public Usuarios createAdmin(Usuarios usuarios) {
		return this.repository.save(usuarios);
	}


	@Override
	public boolean existsAdmin(String rol) {
		var exists = this.repository.findByRol(rol).isEmpty();
		return exists;
		
	}

}
