package com.system.count.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.system.count.model.Usuarios;
import com.system.count.service.UserAdminService;
import com.system.count.service.impl.UserAdminServiceImpl;

@Component
public class AppStartupRunner implements CommandLineRunner{
	
	@Autowired
	UserAdminService service;
	
	@Override
	public void run(String... args) throws Exception {
		
		var tipo_admin = 0;
		var usuario = "Administrador";
		var password = "@passwd";
		var rol = "ADMIN";
		
		if(service.existsAdmin(rol)) {
			Usuarios admin = new Usuarios(
					rol, 
					usuario, 
					usuario, 
					usuario+"@mail.com", 
					usuario,
					password);
					
			service.createAdmin(admin);
		}
		
		
	}

}
