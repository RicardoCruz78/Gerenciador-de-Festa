package com.ricardo.festa.gerenciarFesta.controller;




import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.ricardo.festa.gerenciarFesta.model.Administrador;
import com.ricardo.festa.gerenciarFesta.repository.Administradores;
import com.ricardo.festa.gerenciarFesta.servico.CookieService;

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
	public String logar(Model model, Administrador admParam, String lembrar, HttpServletResponse response) throws IOException {
		Administrador adm = this.administradores.Login(admParam.getEmail(), admParam.getSenha());
		if (adm != null) {
			int tempoLogado = (60*60);// uma hora de cookie
			if (lembrar != null) tempoLogado = (60*60*24*365); // Um ano de cookie
			CookieService.setCookie(response, "usuarioId", String.valueOf(adm.getId()),tempoLogado);
			CookieService.setCookie(response, "nomeUsuario", String.valueOf(adm.getNome()),tempoLogado);
			return "redirect:/administradores/home";
			// redirect:
			// redirect:/administradores
		}
		
		
		// =======================ate aqui esta funcionando
		model.addAttribute("erro", "Ususário ou Senha Inválido");
		return "/login";
	}
	
	
	
	@GetMapping("/sair")
	public String logar( HttpServletResponse response) throws IOException {		
			CookieService.setCookie(response, "usuarioId","",0);
			return "redirect:/login";
			// redirect:
			// redirect:/administradores
		}
		
	
}













