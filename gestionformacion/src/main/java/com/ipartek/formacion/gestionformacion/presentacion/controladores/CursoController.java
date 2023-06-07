package com.ipartek.formacion.gestionformacion.presentacion.controladores;

import java.util.logging.Level;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.formacion.gestionformacion.entidades.Curso;
import com.ipartek.formacion.gestionformacion.servicios.CursoService;
import com.ipartek.formacion.gestionformacion.servicios.ServiciosException;

import jakarta.validation.Valid;
import lombok.extern.java.Log;

@Log
@Controller
@RequestMapping("/")
public class CursoController {
	@Autowired
	private CursoService servicio;
	
	@GetMapping
	public String listado(Model modelo) {
		modelo.addAttribute("cursos", servicio.listado());
		return "listado";
	}
	
	@GetMapping("/formulario")
	public String formulario(Model modelo, Curso curso) {
		modelo.addAttribute("materias", servicio.listadoMaterias());
		modelo.addAttribute("profesores", servicio.listadoProfesores());
		
		return "formulario";
	}
	
	@PostMapping("/formulario")
	public String formularioPost(@Valid Curso curso, BindingResult bindingResult, Model modelo) {
		if(bindingResult.hasErrors()) {
			return formulario(modelo, curso);
		}
		
		try {
			servicio.alta(curso);
		} catch (ServiciosException e) {
			log.log(Level.WARNING, e.getMessage(), e);
			modelo.addAttribute("error", "No se ha podido insertar el registro: " + e.getMessage());
			return formulario(modelo, curso);
		}
		
		return "redirect:/";
	}
}
