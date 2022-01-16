package com.ricardo.festa.gerenciarFesta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.ricardo.festa.gerenciarFesta.model.Administrador;
import com.ricardo.festa.gerenciarFesta.repository.Administradores;

@Controller
public class LoginController {
	@Autowired
	private Administradores administradores;

	@GetMapping("/login")
	public String index() {
		return "/login";
		// OKOKOKOKOK"/gin";
		// return "login/index";

	}

	@PostMapping("/logar")
	public String logar(Model model, Administrador admParam, String Lembrar) {
		Administrador adm = this.administradores.Login(admParam.getEmail(), admParam.getSenha());
		if (adm != null) {
			return "redirect:/administradores";
			// redirect:
			// redirect:/administradores
		}
		// =======================ate aqui esta funcionando
		model.addAttribute("erro", "Ususário ou Senha Inválido");
		return "/login";
	}
}