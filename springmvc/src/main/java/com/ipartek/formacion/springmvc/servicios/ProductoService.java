package com.ipartek.formacion.springmvc.servicios;

import com.ipartek.formacion.springmvc.presentacion.modelos.Producto;

public interface ProductoService {
	Iterable<Producto> listado();
	Producto detalle(Long id);
	
	Producto guardar(Producto producto);
	Producto modificar(Producto producto);
	void borrar(Long id);
}
