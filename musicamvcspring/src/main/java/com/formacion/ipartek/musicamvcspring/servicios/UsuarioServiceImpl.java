package com.formacion.ipartek.musicamvcspring.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formacion.ipartek.musicamvcspring.entidades.Cancion;
import com.formacion.ipartek.musicamvcspring.entidades.Estilo;
import com.formacion.ipartek.musicamvcspring.entidades.Grupo;
import com.formacion.ipartek.musicamvcspring.entidades.Usuario;
import com.formacion.ipartek.musicamvcspring.repositorios.CancionRepository;
import com.formacion.ipartek.musicamvcspring.repositorios.EstiloRepository;
import com.formacion.ipartek.musicamvcspring.repositorios.GrupoRepository;
import com.formacion.ipartek.musicamvcspring.repositorios.UsuarioRepository;

import lombok.ToString;

@ToString
@Service
public class UsuarioServiceImpl implements UsuarioService {
	@Autowired
	private CancionRepository repoCancion;
	
	@Autowired
	private UsuarioRepository repoUsuario;
	
	@Autowired
	private EstiloRepository repoEstilo;
	
	@Autowired
	private GrupoRepository repoGrupo;

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
		if(obtenerPorId(cancion.getId())== null) {
			throw new ServiciosException("No se ha encontrado la canción a modificar");
		}
		
		cancion.setUsuario(usuario);

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

	@Override
	public Iterable<Estilo> obtenerEstilos() {
		return repoEstilo.findAll();
	}

	@Override
	public Iterable<Grupo> obtenerGrupos() {
		return repoGrupo.findAll();
	}

	
}
