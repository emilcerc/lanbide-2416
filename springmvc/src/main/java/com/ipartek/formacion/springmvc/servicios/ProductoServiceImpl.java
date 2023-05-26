package com.ipartek.formacion.springmvc.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.springmvc.entidades.Producto;
import com.ipartek.formacion.springmvc.repositorios.springdatajpa.ProductoRepository;

import lombok.extern.java.Log;

@Service
@Log
public class ProductoServiceImpl implements ProductoService {
	@Autowired
	private ProductoRepository repo;
	
	@Override
	public Iterable<Producto> listado() {
		log.info("LISTADO");
		return repo.findAll();
	}

	@Override
	public Producto detalle(Long id) {
		log.info("DETALLE");
		return repo.findById(id).orElse(null);
	}

	@Override
	public Producto guardar(Producto producto) {
		log.info("GUARDAR");
		return repo.save(producto);
	}

	@Override
	public Producto modificar(Producto producto) {
		log.info("MODIFICAR");
		return repo.save(producto);
	}

	@Override
	public void borrar(Long id) {
		log.info("BORRAR");
		repo.deleteById(id);
	}

}
