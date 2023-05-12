package com.ipartek.formacion.mf0226.accesodatos;

import java.math.BigDecimal;

import com.ipartek.formacion.mf0226.entidades.Producto;

public interface ProductoDao extends Dao<Producto> {
	Iterable<Producto> buscarPorNombre(String parteDelNombre);
	Iterable<Producto> buscarPorPrecio(BigDecimal minimo, BigDecimal maximo);
	
	default Iterable<Producto> buscar(String nombre, BigDecimal minimo, BigDecimal maximo) {
		throw new AccesoDatosException("NO ESTA IMPLEMENTADO");
	}
}
