package com.formacion.ipartek.musicamvcspring.servicios;

import com.formacion.ipartek.musicamvcspring.entidades.Cancion;
import com.formacion.ipartek.musicamvcspring.entidades.Estilo;
import com.formacion.ipartek.musicamvcspring.entidades.Grupo;
import com.formacion.ipartek.musicamvcspring.entidades.Usuario;

public interface UsuarioService {
	Cancion agregarCancion(Cancion cancion);
	Cancion modificarCancion(Cancion cancion);
	void borrarCancion(Long id);
	
	Iterable<Cancion> obtenerSusCanciones();
	Cancion obtenerPorId(Long id);
	
	Iterable<Cancion> buscarCancionesPorNombre(String nombre);
	Iterable<Cancion> buscarCancionesPorEstilo(String estilo);
	Iterable<Cancion> buscarCancionesPorGrupo(String grupo);
	void setUsuario(Usuario usuario);
	Usuario getUsuario();
	Iterable<Estilo> obtenerEstilos();
	Iterable<Grupo> obtenerGrupos();
}
