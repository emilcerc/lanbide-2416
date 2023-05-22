package com.ipartek.formacion.mf0226.accesodatos;

public interface FabricaDao {
	ProductoDao obtenerProductoDao();
	UsuarioDao obtenerUsuarioDao();
}
