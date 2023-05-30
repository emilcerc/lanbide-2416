package com.formacion.ipartek.musicamvcspring.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.formacion.ipartek.musicamvcspring.entidades.Cancion;
import com.formacion.ipartek.musicamvcspring.entidades.Usuario;

@RepositoryRestResource(path = "usuarios", collectionResourceRel = "usuarios")
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
	Usuario findByEmail(String email);
	
	@Query("from Cancion c join fetch c.grupo join fetch c.estilo join fetch c.usuario u where u.id = ?1")
	Iterable<Cancion> buscarPorId(Long id);
	
	@Query("from Cancion c join c.usuario u where u.id = ?1 and c.titulo like %?2%")
	Iterable<Cancion> buscarPorNombre(Long id, String nombre);
	
	@Query("from Cancion c join c.usuario u join c.estilo e where u.id = ?1 and e.nombre like %?2%")
	Iterable<Cancion> buscarPorEstilo(Long id, String estilo);

	@Query("from Cancion c join c.usuario u join c.grupo g where u.id = ?1 and g.nombre like %?2%")
	Iterable<Cancion> buscarPorGrupo(Long id, String grupo);
}
