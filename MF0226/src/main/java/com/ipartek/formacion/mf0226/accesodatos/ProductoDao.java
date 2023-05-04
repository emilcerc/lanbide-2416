package com.ipartek.formacion.mf0226.accesodatos;

import com.ipartek.formacion.mf0226.modelos.Producto;

import java.math.BigDecimal;

public interface ProductoDao extends Dao<Producto> {
	Iterable<Producto> buscarPorNombre(String parteDelNombre);
	Iterable<Producto> buscarPorPrecio(BigDecimal minimo, BigDecimal maximo);
}
