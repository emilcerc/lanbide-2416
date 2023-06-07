package com.ipartek.formacion.gestionformacion.presentacion.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.formacion.gestionformacion.entidades.Curso;
import com.ipartek.formacion.gestionformacion.servicios.CursoService;

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
	public String formularioPost(Curso curso) {
		servicio.alta(curso);
		return "redirect:/";
	}
}
