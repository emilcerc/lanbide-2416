package com.ipartek.formacion.springmvc.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.springmvc.entidades.Producto;
import com.ipartek.formacion.springmvc.servicios.ProductoService;

@RestController
@RequestMapping("/api/v1/productos")
public class ProductoRestController {
	@Autowired
	private ProductoService servicio;
	
	@GetMapping
	public Iterable<Producto> get() {
		return servicio.listado();
	}
	
	@GetMapping("/{id}")
	public Producto getPorId(@PathVariable Long id) {
		return servicio.detalle(id);
	}
	
	@PostMapping
	public Producto post(@RequestBody Producto producto) {
		return servicio.guardar(producto);
	}
	
	@PutMapping("/{id}")
	public Producto put(@PathVariable Long id, @RequestBody Producto producto) {
		return servicio.modificar(producto);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		servicio.borrar(id);
	}
}
