package com.system.count.controller;

import java.util.Optional;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.system.count.model.Usuarios;
import com.system.count.service.UsuariosService;
import com.system.count.service.impl.UsuariosServiceImpl;

@Controller
@RequestMapping(value = "/admin/dashboard")
public class UserAdminController {
	
	
	@Autowired
	UsuariosService usuariosService;
	
	//############################# View home #############################\\
	
	
	@GetMapping(value = "")
	public String home(Model model) {
		return "/admin/home";
	}
	
	
	//############################# View agregar-usuarios #############################\\
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping(value="/agregar-usuarios")
	public String agregar(Model model) {
		model.addAttribute("usuarios",new Usuarios());
		model.addAttribute("Lista_Usuarios", usuariosService.findAll());
		return "/admin/agregar-usuarios";
	}
	
	

	/**
	 * 
	 * @param usuarios
	 * @param result
	 * @param model
	 * @return
	 */
	@PostMapping(value = "usuarios/save")
	public RedirectView saveUsuarios(@Valid @ModelAttribute("usuarios") Usuarios usuarios, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return new RedirectView("../agregar-usuarios");
        }
		
		usuariosService.save(usuarios);
		return new RedirectView("../agregar-usuarios");
		
	}
	
	
	/**
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("usuarios/delete/{id}")
	public RedirectView deleteUser(@PathVariable("id") long id, Model model) {
		Usuarios user = usuariosService.findById(id)
	      .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		usuariosService.delete(user);
	    return new RedirectView("../../agregar-usuarios");
	}
	
	
	/**
	 * 
	 * @param id
	 * @param usuarios
	 * @param result
	 * @param model
	 * @return
	 */
	@PostMapping("usuarios/update")
	public RedirectView updateUser(HttpServletRequest request) {
		String id = request.getParameter("id").toString();
		Optional<Usuarios> object = usuariosService.findById(Long.parseLong(id));
		Usuarios usuarios = object.get();
		usuarios.setNombre(request.getParameter("nombre").trim()); 
		usuarios.setApellido(request.getParameter("apellido").trim());
		usuarios.setEmail(request.getParameter("email").trim());
		usuarios.setUsername(request.getParameter("username").trim());
		usuarios.setPassword(request.getParameter("password").trim());
		usuarios.setRol(request.getParameter("group1").trim());
	    usuariosService.save(usuarios);
	    return new RedirectView("../agregar-usuarios");
	}
	
	
	//############################# View template #############################\\
	
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/template")
	public String existencias(Model model) {
		return "/admin/template_main";
	}
	
}
