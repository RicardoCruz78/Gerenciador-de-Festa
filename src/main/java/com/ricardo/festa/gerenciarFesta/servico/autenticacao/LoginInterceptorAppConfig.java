package com.ricardo.festa.gerenciarFesta.servico.autenticacao;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class LoginInterceptorAppConfig extends WebMvcConfigurerAdapter {
	@Override
public void addInterceptors (InterceptorRegistry registry) {
	 registry.addInterceptor(new LoginInterceptor())
	 //.excludePaPatterns (
	 .excludePathPatterns(
			 "/login",
			"/error",
			"/logar",
			"/vendor/**",
			"/img/**",
			"/js/**",
			"/favicon.ico",
			"/css/**"		
			
			);
	
}
	
}
