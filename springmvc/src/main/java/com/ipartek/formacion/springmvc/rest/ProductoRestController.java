package com.ipartek.formacion.springmvc.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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
		Producto producto = servicio.detalle(id);
		
		if(producto == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		return producto;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Producto post(@RequestBody Producto producto) {
		return servicio.guardar(producto);
	}
	
	@PutMapping("/{id}")
	public Producto put(@PathVariable Long id, @RequestBody Producto producto) {
		if(id != producto.getId()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return servicio.modificar(producto);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		servicio.borrar(id);
	}
}
