package com.formacion.ipartek.musicamvcspring.presentacion.controladores;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {
	@GetMapping("login")
	public String login() {
		return "login";
	}

	@GetMapping("procesar-usuario")
	public String procesarUsuario(Authentication auth) {
		boolean esAdmin = auth.getAuthorities().stream().anyMatch(rol -> rol.getAuthority().equals("ROLE_ADMIN"));
//				new Predicate<GrantedAuthority>() {
//
//			@Override
//			public boolean test(GrantedAuthority rol) {
//				return rol.getAuthority().equals("ADMIN");
//			}
//		});

		if(esAdmin) {
			return "redirect:/admin";
		} else {
			return "redirect:/usuarios";
		}
	}
}
