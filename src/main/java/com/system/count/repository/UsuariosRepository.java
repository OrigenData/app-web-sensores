package com.system.count.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.count.model.Usuarios;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Long>{
    
	public abstract Usuarios findByUsername(String usuario);
	
	public abstract List<Usuarios> findByRol(String rol);
	
   
}
