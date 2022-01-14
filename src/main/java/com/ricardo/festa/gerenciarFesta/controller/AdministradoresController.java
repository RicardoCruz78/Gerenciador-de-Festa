package com.ricardo.festa.gerenciarFesta.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ricardo.festa.gerenciarFesta.model.Administrador;
import com.ricardo.festa.gerenciarFesta.repository.Administradores;

@Controller
public class AdministradoresController {
	
	 @Autowired
	private Administradores administradores;	 
	 
	
	@GetMapping ("/administradores")

	public ModelAndView index() {
	ModelAndView modelAndView= new  ModelAndView ("index");
	modelAndView.addObject("administradores",administradores.findAll());
		modelAndView.addObject(new Administrador());
		return modelAndView;
	}
	
//========================================================================================
	@GetMapping ("/administradores/novoAdm" )
	public String novoAdm() {
		return "/novoAdm";
	}
	//=======================================================================================
	
	@PostMapping("/administradores/criar" )
	public String criar(Administrador administrador) {
		administradores.save(administrador);
		return "redirect:/administradores" ;
	}
	//======================================================================================
	
	@GetMapping ("/administradores/{id}")
	public String busca(@PathVariable Long id, Model model) {
		Optional<Administrador> admin = administradores.findById(id);
		model.addAttribute("administrador",admin.get());
		return "/editar" ;
		
	}
	
	
	@GetMapping("/administradores/{id}/excluir")
	public String excluir(@PathVariable Long id) {
		
		administradores.deleteById(id);
		return "redirect:/administradores";
	}

		}


