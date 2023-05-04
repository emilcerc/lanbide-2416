package com.ipartek.formacion.mf0226.logicanegocio;

import com.ipartek.formacion.mf0226.modelos.Producto;

import java.math.BigDecimal;

public interface UsuarioNegocio {
	Iterable<Producto> listado();
	Producto detalle(Long id);
	
	Iterable<Producto> buscarPorPrecios(BigDecimal minimo, BigDecimal maximo);
	Iterable<Producto> buscarPorNombre(String parteDelNombre);
}
