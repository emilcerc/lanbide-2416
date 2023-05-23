package com.ipartek.formacion.springmvc.presentacion.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.formacion.springmvc.presentacion.modelos.Producto;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/producto")
public class ProductoController {
	@GetMapping
	public String mostrarFormulario(Producto producto) {
		return "producto";
	}
	
	@PostMapping
	public String recepcionFormulario(@Valid Producto producto, BindingResult bindingResult, Model modelo) {
		System.out.println(bindingResult);
		System.out.println(producto);
		
		modelo.addAttribute("errores", bindingResult);
		
		if(bindingResult.hasErrors()) {
			return "producto";
		}
		
		return "redirect:/";
	}
}
