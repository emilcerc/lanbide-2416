package com.ipartek.formacion.musicamvc.accesodatos;

import com.ipartek.formacion.musicamvc.entidades.Usuario;

public interface UsuarioDao extends Dao<Usuario> {
	Usuario buscarPorEmail(String email);
}
