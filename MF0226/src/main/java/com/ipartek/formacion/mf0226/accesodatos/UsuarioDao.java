package com.ipartek.formacion.mf0226.accesodatos;

import com.ipartek.formacion.mf0226.modelos.Usuario;

public interface UsuarioDao {
	Usuario obtenerPorEmail(String email);
}
