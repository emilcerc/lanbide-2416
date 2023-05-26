package com.ipartek.formacion.springmvc.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.springmvc.presentacion.modelos.Producto;
import com.ipartek.formacion.springmvc.repositorios.ProductoRepository;

import lombok.extern.java.Log;

@Service
@Log
public class ProductoServiceImpl implements ProductoService {
	@Autowired
	private ProductoRepository repo;
	
	@Override
	public Iterable<Producto> listado() {
		log.info("LISTADO");
		return repo.obtenerTodos();
	}

	@Override
	public Producto detalle(Long id) {
		log.info("DETALLE");
		return repo.obtenerPorId(id);
	}

	@Override
	public Producto guardar(Producto producto) {
		log.info("GUARDAR");
		return repo.insertar(producto);
	}

	@Override
	public Producto modificar(Producto producto) {
		log.info("MODIFICAR");
		return repo.modificar(producto);
	}

	@Override
	public void borrar(Long id) {
		log.info("BORRAR");
		repo.borrar(id);
	}

}
