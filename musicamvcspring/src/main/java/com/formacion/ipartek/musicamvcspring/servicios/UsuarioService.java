package com.formacion.ipartek.musicamvcspring.servicios;

import com.formacion.ipartek.musicamvcspring.entidades.Cancion;

public interface UsuarioService {
	Cancion agregarCancion(Cancion cancion);
	Cancion modificarCancion(Cancion cancion);
	void borrarCancion(Long id);
	
	Iterable<Cancion> obtenerSusCanciones();
	Cancion obtenerPorId(Long id);
	
	Iterable<Cancion> buscarCancionesPorNombre(String nombre);
	Iterable<Cancion> buscarCancionesPorEstilo(String estilo);
	Iterable<Cancion> buscarCancionesPorGrupo(String grupo);
}
