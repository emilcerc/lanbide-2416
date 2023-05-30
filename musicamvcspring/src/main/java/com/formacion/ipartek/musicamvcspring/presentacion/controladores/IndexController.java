package com.formacion.ipartek.musicamvcspring.presentacion.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.formacion.ipartek.musicamvcspring.entidades.Usuario;
import com.formacion.ipartek.musicamvcspring.servicios.AnonimoService;
import com.formacion.ipartek.musicamvcspring.servicios.UsuarioService;

@Controller
@RequestMapping("/")
public class IndexController {
	@Autowired
	private AnonimoService anonimoService;
	
	@Autowired
	private UsuarioService usuarioService;
	
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

		Usuario usuario = anonimoService.obtenerPorEmail(auth.getName());
		usuarioService.setUsuario(usuario);
		
		if(esAdmin) {
			return "redirect:/admin";
		} else {
			return "redirect:/usuarios";
		}
	}
}
