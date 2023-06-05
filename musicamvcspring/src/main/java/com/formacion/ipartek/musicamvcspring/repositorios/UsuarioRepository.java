package com.formacion.ipartek.musicamvcspring.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.formacion.ipartek.musicamvcspring.entidades.Cancion;
import com.formacion.ipartek.musicamvcspring.entidades.Usuario;

/**
 * Repositorio de usuarios
 * @author javierlete
 * @version 1.0
 */
@RepositoryRestResource(path = "usuarios", collectionResourceRel = "usuarios")
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
	/**
	 * Buscar un usuario por email
	 * @param email email a buscar
	 * @return usuario encontrado o <code>null</code> si no se encuentra
	 */
	Usuario findByEmail(String email);
	
	/**
	 * Buscar canción por <strong>id de usuario</strong>
	 * @param id del <strong>usuario</strong>
	 * @return las canciones del usuario
	 */
	@Query("from Cancion c join fetch c.grupo join fetch c.estilo join fetch c.usuario u where u.id = ?1")
	Iterable<Cancion> buscarPorId(Long id);
	
	/**
	 * Buscar canciones del usuario <code>id</code> y nombre parcial <code>nombre</code>
	 * @param id id del usuario
	 * @param nombre parte del nombre de la canción
	 * @return canciones que concuerdan con la búsqueda
	 */
	@Query("from Cancion c join c.usuario u where u.id = ?1 and c.titulo like %?2%")
	Iterable<Cancion> buscarPorNombre(Long id, String nombre);
	
	/**
	 * Buscar canciones según su estilo parcial
	 * @param id id del usuario
	 * @param estilo parte de nombre del estilo
	 * @return canciones con ese estilo del usuario
	 */
	@Query("from Cancion c join c.usuario u join c.estilo e where u.id = ?1 and e.nombre like %?2%")
	Iterable<Cancion> buscarPorEstilo(Long id, String estilo);

	/**
	 * Buscar canciones según su grupo
	 * @param id id del usuario
	 * @param grupo grupo de la canción
	 * @return canciones del grupo y usuario especificado
	 */
	@Query("from Cancion c join c.usuario u join c.grupo g where u.id = ?1 and g.nombre like %?2%")
	Iterable<Cancion> buscarPorGrupo(Long id, String grupo);
}
