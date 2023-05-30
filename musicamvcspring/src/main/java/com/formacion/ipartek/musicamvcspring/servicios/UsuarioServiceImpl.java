package com.formacion.ipartek.musicamvcspring.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formacion.ipartek.musicamvcspring.entidades.Cancion;
import com.formacion.ipartek.musicamvcspring.entidades.Usuario;
import com.formacion.ipartek.musicamvcspring.repositorios.CancionRepository;
import com.formacion.ipartek.musicamvcspring.repositorios.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	@Autowired
	private CancionRepository repoCancion;
	
	@Autowired
	private UsuarioRepository repoUsuario;

	private Usuario usuario;

	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	@Override
	public Cancion agregarCancion(Cancion cancion) {
		cancion.setUsuario(usuario);

		repoCancion.save(cancion);

		return cancion;
	}

	@Override
	public Cancion modificarCancion(Cancion cancion) {
		if(cancion.getUsuario().getId() != usuario.getId()) {
			throw new ServiciosException("No se puede modificar una canción que no es del usuario");
		}

		repoCancion.save(cancion);

		return cancion;
	}

	@Override
	public void borrarCancion(Long id) {
		Cancion cancion = obtenerPorId(id);
		
		if(cancion == null) {
			throw new ServiciosException("No se ha encontrado la canción a borrar");
		}
		
		repoCancion.delete(cancion);
	}

	@Override
	public Iterable<Cancion> obtenerSusCanciones() {
		return repoUsuario.buscarPorId(usuario.getId());
	}
	
	@Override
	public Cancion obtenerPorId(Long id) {
		Cancion cancion = repoCancion.findById(id).orElse(null);
		
		if(cancion.getUsuario().getId() != usuario.getId()) {
			return null;
		}
		
		return cancion;
	}


	@Override
	public Iterable<Cancion> buscarCancionesPorNombre(String nombre) {
		return repoUsuario.buscarPorNombre(usuario.getId(), nombre);
	}

	@Override
	public Iterable<Cancion> buscarCancionesPorEstilo(String estilo) {
		return repoUsuario.buscarPorEstilo(usuario.getId(), estilo);
	}

	@Override
	public Iterable<Cancion> buscarCancionesPorGrupo(String grupo) {
		return repoUsuario.buscarPorGrupo(usuario.getId(), grupo);
	}

	
}
