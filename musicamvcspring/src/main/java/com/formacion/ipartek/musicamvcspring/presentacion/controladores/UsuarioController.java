package com.formacion.ipartek.musicamvcspring.presentacion.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.formacion.ipartek.musicamvcspring.entidades.Cancion;
import com.formacion.ipartek.musicamvcspring.entidades.Estilo;
import com.formacion.ipartek.musicamvcspring.entidades.Grupo;
import com.formacion.ipartek.musicamvcspring.servicios.UsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping({"", "canciones"})
	public String index(Model modelo) {
		modelo.addAttribute("canciones", usuarioService.obtenerSusCanciones());
		return "usuarios/canciones";
	}
	
	@GetMapping("cancion")
	public String cancion(Cancion cancion, Model modelo) {
		cargarDesplegablesCancion(modelo);
		
		return "usuarios/cancion";
	}

	@GetMapping("cancion/{id}")
	public String cancion(@PathVariable Long id, Model modelo) {
		cargarDesplegablesCancion(modelo);
		
		Cancion cancion = usuarioService.obtenerPorId(id);
		modelo.addAttribute("cancion", cancion);
		
		return "usuarios/cancion";
	}
	
	@GetMapping("cancion/borrar/{id}")
	public String cancionBorrar(@PathVariable Long id) {
		usuarioService.borrarCancion(id);
		
		return "redirect:/usuarios/canciones";
	}

	@PostMapping("cancion")
	public String guardarCancion(Cancion cancion) {
		System.out.println(cancion);
		
		if(cancion.getId() != null) {
			usuarioService.modificarCancion(cancion);
		} else {
			usuarioService.agregarCancion(cancion);
		}
		
		return "redirect:/usuarios/canciones";
	}
	
	private void cargarDesplegablesCancion(Model modelo) {
		Iterable<Estilo> estilos = usuarioService.obtenerEstilos();
		modelo.addAttribute("estilos", estilos);
		
		Iterable<Grupo> grupos = usuarioService.obtenerGrupos();
		modelo.addAttribute("grupos", grupos);
	}
}
