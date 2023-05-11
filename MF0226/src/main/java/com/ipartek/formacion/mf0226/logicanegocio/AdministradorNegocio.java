package com.ipartek.formacion.mf0226.logicanegocio;

import java.util.Map;

import com.ipartek.formacion.mf0226.entidades.Producto;

public interface AdministradorNegocio extends UsuarioNegocio {
	Map<String, String> validarProducto(Producto producto);
	
	Producto agregarProducto(Producto producto);
	Producto modificarProducto(Producto producto);
	void borrarProducto(Long id);
}
