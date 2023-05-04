package com.ipartek.formacion.mf0226.logicanegocio;

import com.ipartek.formacion.mf0226.modelos.Producto;

public interface AdministradorNegocio extends UsuarioNegocio {
	Producto agregarProducto(Producto producto);
	Producto modificarProducto(Producto producto);
	void borrarProducto(Long id);
}
