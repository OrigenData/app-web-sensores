package com.system.count.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.count.model.Usuarios;
import com.system.count.repository.UsuariosRepository;
import com.system.count.service.UsuariosService;

@Service
public class UsuariosServiceImpl implements UsuariosService {

	@Autowired
	UsuariosRepository usuariosRepository;

	@Override
	public List<Usuarios> findAll() {
		return usuariosRepository.findAll();
	}

	@Override
	public Usuarios save(Usuarios usuarios) {
		return usuariosRepository.save(usuarios);
	}

	@Override
	public Optional<Usuarios> findById(Long id) {
		return usuariosRepository.findById(id);
	}

	@Override
	public Usuarios findByUsername(String usuario) {
		return usuariosRepository.findByUsername(usuario);
	}

	
	@Override
	public void delete(Usuarios usuarios) {
		usuariosRepository.delete(usuarios);
	}

}
