package com.system.count.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.count.model.Usuarios;
import com.system.count.repository.UsuariosRepository;
import com.system.count.service.UsuariosService;

@Service
public class UsuariosServiceImpl implements UsuariosService{

	@Autowired
	UsuariosRepository repository;
	
	@Override
	public List<Usuarios> getAllUsuarios() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuarios saveUsuarios(Usuarios usuarios) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Usuarios> getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuarios getByUsuario(String usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteUsuariosById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
