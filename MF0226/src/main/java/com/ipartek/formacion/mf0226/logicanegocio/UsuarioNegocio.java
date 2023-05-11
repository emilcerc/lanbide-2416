package com.ipartek.formacion.mf0226.logicanegocio;

import java.math.BigDecimal;

import com.ipartek.formacion.mf0226.entidades.Producto;
import com.ipartek.formacion.mf0226.entidades.Usuario;

public interface UsuarioNegocio {
	Iterable<Producto> listado();
	Producto detalle(Long id);
	
	Iterable<Producto> buscarPorPrecios(BigDecimal minimo, BigDecimal maximo);
	Iterable<Producto> buscarPorNombre(String parteDelNombre);
	
	Usuario autenticarUsuario(Usuario usuario);
}
