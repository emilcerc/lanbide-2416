package com.formacion.ipartek.musicamvcspring.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.formacion.ipartek.musicamvcspring.entidades.Cancion;
import com.formacion.ipartek.musicamvcspring.repositorios.CancionRepository;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private CancionRepository repo;
	
	@Override
	public Iterable<Cancion> obtenerPagina(Pageable pageable) {
		return repo.obtenerTodasConEstiloGrupoUsuario(pageable);
	}
	
	@Override
	public long getNumeroCanciones() {
		return repo.count();
	}

}
