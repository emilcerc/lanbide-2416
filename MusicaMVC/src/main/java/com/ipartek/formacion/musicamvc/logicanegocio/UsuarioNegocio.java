package com.ipartek.formacion.musicamvc.logicanegocio;

import com.ipartek.formacion.musicamvc.entidades.Cancion;
import com.ipartek.formacion.musicamvc.entidades.Estilo;

public interface UsuarioNegocio {
	Iterable<Cancion> obtenerCancionesUsuario();
	Cancion obtenerCancionPorId(Long id);
	
	Cancion insertarCancion(Cancion cancion);
	Cancion modificarCancion(Cancion cancion);
	void borrarCancion(Long id);
	
	Iterable<Cancion> buscarPorNombre(String nombre);
	Iterable<Cancion> buscarPorEstilo(String estilo);
	Iterable<Cancion> buscarPorGrupo(String grupo);
	Iterable<Estilo> obtenerEstilos();
}
