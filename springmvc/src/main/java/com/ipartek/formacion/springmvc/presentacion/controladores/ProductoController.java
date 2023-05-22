package com.ipartek.formacion.springmvc.presentacion.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.formacion.springmvc.presentacion.modelos.Producto;

@Controller
@RequestMapping("/producto")
public class ProductoController {
	@GetMapping
	public String mostrarFormulario() {
		return "producto";
	}
	
	@PostMapping
	public String recepcionFormulario(Producto producto) {
		System.out.println(producto);
		
		return null;
	}
}
