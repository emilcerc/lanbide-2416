package com.formacion.ipartek.multi.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formacion.ipartek.multi.entidades.Usuario;
import com.formacion.ipartek.multi.repositorios.UsuarioRepository;

@Service
public class AnonimoServiceImpl implements AnonimoService {
	@Autowired
	private UsuarioRepository repo;
	
	@Override
	public Usuario obtenerPorEmail(String email) {
		return repo.findByEmail(email);
	}

}
