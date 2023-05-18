package com.ipartek.formacion.musicamvc.accesodatos;

import com.ipartek.formacion.musicamvc.entidades.Cancion;

public interface CancionDao extends Dao<Cancion> {
	Iterable<Cancion> buscarPorNombre(String nombre);
	Iterable<Cancion> buscarPorEstilo(String estilo);
	Iterable<Cancion> buscarPorGrupo(String grupo);
	Iterable<Cancion> buscarPorNombreUsuario(String nombre);
	Iterable<Cancion> buscarPorEmail(String email);
	Iterable<Cancion> buscarPorIdUsuario(Long id);
	
	Iterable<Cancion> buscarPorNombreYUsuarioId(String nombre, Long idUsuario);
	Iterable<Cancion> buscarPorEstiloYUsuarioId(String estilo, Long idUsuario);
	Iterable<Cancion> buscarPorGrupoYUsuarioId(String grupo, Long idUsuario);
}
