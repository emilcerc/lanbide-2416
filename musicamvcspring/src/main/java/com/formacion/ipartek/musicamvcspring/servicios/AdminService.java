package com.formacion.ipartek.musicamvcspring.servicios;

import org.springframework.data.domain.Pageable;

import com.formacion.ipartek.musicamvcspring.entidades.Cancion;

public interface AdminService {
	Iterable<Cancion> obtenerPagina(Pageable pageable);

	long getNumeroCanciones();
}
