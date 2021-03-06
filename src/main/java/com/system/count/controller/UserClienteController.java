package com.system.count.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.system.count.service.impl.UsuariosServiceImpl;

@Controller
@RequestMapping(value = "/dashboard")
public class UserClienteController {
	
	
	@Autowired
	UsuariosServiceImpl usuarioService;
	
	@GetMapping(value = "")
	public String home(Model model) {
		return "/user/home";
	}
	
	

}
										