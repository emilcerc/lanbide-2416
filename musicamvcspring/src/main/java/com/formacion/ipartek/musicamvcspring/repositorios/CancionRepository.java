package com.formacion.ipartek.musicamvcspring.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.formacion.ipartek.musicamvcspring.entidades.Cancion;

@RepositoryRestResource(path = "canciones", collectionResourceRel = "canciones")
public interface CancionRepository extends CrudRepository<Cancion, Long> {
	Iterable<Cancion> findByTituloContains(String titulo);
	
	@Query("from Cancion c join fetch c.grupo g where g.nombre like %?1%")
	Iterable<Cancion> buscarPorGrupo(String nombre);
	
	@Query("from Cancion c join fetch c.estilo e where e.nombre like %?1%")
	Iterable<Cancion> buscarPorEstilo(String estilo);
}
