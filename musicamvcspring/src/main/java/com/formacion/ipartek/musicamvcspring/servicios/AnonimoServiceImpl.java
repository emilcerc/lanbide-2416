package com.formacion.ipartek.musicamvcspring.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formacion.ipartek.musicamvcspring.entidades.Usuario;
import com.formacion.ipartek.musicamvcspring.repositorios.UsuarioRepository;

@Service
public class AnonimoServiceImpl implements AnonimoService {
	@Autowired
	private UsuarioRepository repo;
	
	@Override
	public Usuario obtenerPorEmail(String email) {
		return repo.buscarPorEmail(email);
	}

}
