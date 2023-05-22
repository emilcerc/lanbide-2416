package com.ipartek.formacion.springmvc.presentacion.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HolaMundoController {
	@GetMapping({"/", "/index"})
	public String index() {
		return "index";
	}

	@PostMapping("/saludar")
	public String saludar(String nombre, Model modelo) {
		modelo.addAttribute("nombre", nombre);
		return "saludo";
	}
}
