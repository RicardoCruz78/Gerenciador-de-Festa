package com.ricardo.festa.gerenciarFesta.servico.autenticacao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;

import com.ricardo.festa.gerenciarFesta.servico.CookieService;


@Component
public class LoginInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle
	(HttpServletRequest request, HttpServletResponse response, Object handler)
	throws Exception{
		
	
		
		if (CookieService.getCookie(request, "usuarioId") != null) {
			return true;
		}
		
		response.sendRedirect("/login");
		return false;
		
	}
	
	/*
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("Post Handle method is calling");
		
	}
	@Override
	public void afterCompletion
	(HttpServletRequest request,HttpServletResponse response, Object
			handler, Exception exception) throws Exception{
		System.out.println("Request and Response is completed");
	}
*/
}










