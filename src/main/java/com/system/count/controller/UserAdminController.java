package com.system.count.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.system.count.model.Usuarios;
import com.system.count.service.impl.UsuariosServiceImpl;

@Controller
@RequestMapping(value = "/admin/dashboard")
public class UserAdminController {
	
	
	@Autowired
	UsuariosServiceImpl usuarioService;
	
	@GetMapping(value = "")
	public String home(Model model) {
		return "/admin/home";
	}
	
	
	@GetMapping(value="/agregar-usuarios")
	public String agregar(Model model) {
		model.addAttribute("usuarios",new Usuarios());
		model.addAttribute("Lista_Usuarios", usuarioService.getAllUsuarios());
		return "/admin/agregar-usuarios";
	}
	
	
	@GetMapping(value = "/template")
	public String existencias(Model model) {
		return "/admin/template_main";
	}
}
