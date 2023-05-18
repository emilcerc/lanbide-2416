package com.ipartek.formacion.musicamvc.logicanegocio;

import com.ipartek.formacion.musicamvc.accesodatos.UsuarioDao;
import com.ipartek.formacion.musicamvc.accesodatos.jpa.JpaUsuarioDao;
import com.ipartek.formacion.musicamvc.entidades.Usuario;

public class AnonimoNegocioImpl implements AnonimoNegocio {
	private UsuarioDao usuarioDao = new JpaUsuarioDao();
	
	@Override
	public Usuario autenticar(Usuario usuario) {
		Usuario usuarioRecibido = usuarioDao.buscarPorEmail(usuario.getEmail());
		
		if(usuarioRecibido == null || !usuarioRecibido.getPassword().equals(usuario.getPassword())) {
			return null;
		}
		
		return usuarioRecibido;
	}
}
