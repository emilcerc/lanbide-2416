package com.formacion.ipartek.multi.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.formacion.ipartek.multi.entidades.Cancion;
import com.formacion.ipartek.multi.repositorios.CancionRepository;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private CancionRepository repo;
	
	@Override
	public Iterable<Cancion> obtenerPagina(Pageable pageable) {
		return repo.findAll(pageable);
	}
	
	@Override
	public long getNumeroCanciones() {
		return repo.count();
	}

}
