package com.ipartek.formacion.musicamvc.logicanegocio;

import com.ipartek.formacion.musicamvc.accesodatos.CancionDao;
import com.ipartek.formacion.musicamvc.accesodatos.EstiloDao;
import com.ipartek.formacion.musicamvc.accesodatos.jpa.JpaCancionDao;
import com.ipartek.formacion.musicamvc.accesodatos.jpa.JpaEstiloDao;
import com.ipartek.formacion.musicamvc.entidades.Cancion;
import com.ipartek.formacion.musicamvc.entidades.Estilo;
import com.ipartek.formacion.musicamvc.entidades.Usuario;

public class UsuarioNegocioImpl implements UsuarioNegocio {

	private CancionDao cancionDao = new JpaCancionDao();
	private EstiloDao estiloDao = new JpaEstiloDao();
	
	private Long id;
	
	public UsuarioNegocioImpl(Long idUsuario) {
		this.id = idUsuario;
	}
	
	@Override
	public Iterable<Cancion> obtenerCancionesUsuario() {
		return cancionDao.buscarPorIdUsuario(id);
	}

	@Override
	public Cancion obtenerCancionPorId(Long id) {
		Cancion cancion = cancionDao.obtenerPorId(id);
		
		if(cancion == null || cancion.getUsuario().getId() != id) {
			return null;
		}
		
		return cancion;
	}

	@Override
	public Cancion insertarCancion(Cancion cancion) {
		Usuario usuario = Usuario.builder().id(id).build();
		cancion.setUsuario(usuario);
		
		return cancionDao.insertar(cancion);
	}

	@Override
	public Cancion modificarCancion(Cancion cancion) {
		if(obtenerCancionPorId(cancion.getId()) == null) {
			throw new LogicaNegocioException("No puedes modificar esa canción");
		}
		
		Usuario usuario = Usuario.builder().id(id).build();
		cancion.setUsuario(usuario);
		
		return cancionDao.modificar(cancion);
	}

	@Override
	public void borrarCancion(Long id) {
		if(obtenerCancionPorId(id) == null) {
			throw new LogicaNegocioException("No puedes borrar esa canción");
		}
		
		cancionDao.borrar(id);
	}

	@Override
	public Iterable<Cancion> buscarPorNombre(String nombre) {
		return cancionDao.buscarPorNombreYUsuarioId(nombre, id);
	}

	@Override
	public Iterable<Cancion> buscarPorEstilo(String estilo) {
		return cancionDao.buscarPorEstiloYUsuarioId(estilo, id);
	}

	@Override
	public Iterable<Cancion> buscarPorGrupo(String grupo) {
		return cancionDao.buscarPorGrupoYUsuarioId(grupo, id);
	}

	@Override
	public Iterable<Estilo> obtenerEstilos() {
		return estiloDao.obtenerTodos();
	}

}
