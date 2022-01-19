package com.ricardo.festa.gerenciarFesta.controller;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ricardo.festa.gerenciarFesta.servico.CookieService;
@Controller
public class HomeController {
	
	@GetMapping("/")
	public String index (Model model, HttpServletRequest request) throws UnsupportedEncodingException  {
		model.addAttribute("nome",CookieService.getCookie(request,"nomeUsuario"));
		return "/home/index" ;
	}
	

}












