package com.formacion.ipartek.musicamvcspring.presentacion.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
	@GetMapping
	public String index() {
		return "usuarios/index";
	}
}
