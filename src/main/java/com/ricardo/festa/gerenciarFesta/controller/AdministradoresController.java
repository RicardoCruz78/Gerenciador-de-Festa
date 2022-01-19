package com.ricardo.festa.gerenciarFesta.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ricardo.festa.gerenciarFesta.model.Administrador;
import com.ricardo.festa.gerenciarFesta.repository.Administradores;

@Controller
public class AdministradoresController {

	@Autowired
	private Administradores administradores;

	// ------------------Listar --------------------------------------------
	@GetMapping("/administradores")

	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("administradores", administradores.findAll());
		modelAndView.addObject(new Administrador());
		return modelAndView;
	}
//´´´´´´´´´´´´´´home================
	
	@GetMapping("/administradores/home")
	public String home() {
		return "/home";
	}
	
	
//===================Tela do formulario cadastrar=====================================================================
	@GetMapping("/administradores/novoAdm")
	public String novoAdm() {
		return "/novoAdm";
	}
	// ============================Cadastrando===========================================================

	@PostMapping("/administradores/criar")
	public String criar(Administrador administrador) {
		administradores.save(administrador);
		return "redirect:/administradores";
	}
	// ================================Buscando sem
	// validação======================================================
	/*
	 * @GetMapping ("/administradores/{id}") public String busca(@PathVariable Long
	 * id, Model model) { Optional<Administrador> admin =
	 * administradores.findById(id);
	 * model.addAttribute("administrador",admin.get()); return "/editar" ;
	 * 
	 * }
	 */
	// ============================Buscando com Validação=================

	@GetMapping("/administradores/{id}")
	public String busca(@PathVariable Long id, Model model) {
		Optional<Administrador> admin = administradores.findById(id);
		try {
			model.addAttribute("administrador", admin.get());

		} catch (Exception er) {
			return "redirect:/administradores";
		}
		return "/editar";
	}

	// ===============================Atualizando
	// --------------------------------------

	@PostMapping("/administradores/{id}/atualizar")
	public String atualizar(@PathVariable Long id, Administrador administrador) {
		// if(!administradores.exist(id)){
		if (!administradores.existsById(id)) {
			return "redirect:/administradores";
		}

		administradores.save(administrador);
		return "redirect:/administradores";

	}

	@GetMapping("/administradores/{id}/excluir")
	public String excluir(@PathVariable Long id) {

		administradores.deleteById(id);
		return "redirect:/administradores";
	}

}
