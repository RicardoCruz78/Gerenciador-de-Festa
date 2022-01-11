package com.ricardo.festa.gerenciarFesta.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ricardo.festa.gerenciarFesta.model.Administrador;
import com.ricardo.festa.gerenciarFesta.repository.Administradores;

@Controller
public class AdministradoresController {
	
	 @Autowired
	private Administradores administradores;
	
	@RequestMapping ("/administradores")
	public ModelAndView listarAdm() {
	ModelAndView modelAndView= new  ModelAndView ("index");
	modelAndView.addObject("administradores",administradores.findAll());
		modelAndView.addObject(new Administrador());
		return modelAndView;
	}
	@PostMapping("/administradores" )
	public String salvar(Administrador administrador) {
		this.administradores.save(administrador);
		return "redirect:/administradores";
	}

}
