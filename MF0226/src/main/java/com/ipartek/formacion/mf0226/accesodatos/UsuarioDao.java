package com.ipartek.formacion.mf0226.accesodatos;

import com.ipartek.formacion.mf0226.entidades.Usuario;

public interface UsuarioDao {
	Usuario obtenerPorEmail(String email);
}
