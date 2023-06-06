package com.formacion.ipartek.multi.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.formacion.ipartek.multi.entidades.Cancion;

/**
 * Repositorio de canciones
 * @author javierlete
 * @version 1.0
 */
@RepositoryRestResource(path = "canciones", collectionResourceRel = "canciones")
public interface CancionRepository extends JpaRepository<Cancion, Long> {
	/**
	 * Buscar canciones por parte del título
	 * @param titulo parte del título de la canción
	 * @return canciones con esa parte del título
	 */
	Iterable<Cancion> findByTituloContains(String titulo);
	
	/**
	 * Obtener canciones por parte del nombre del grupo
	 * @param nombre parte de nombre del grupo
	 * @return canciones incluyendo el grupo asociado
	 */
	@Query("from Cancion c join fetch c.grupo g where g.nombre like %?1%")
	Iterable<Cancion> buscarPorGrupo(String nombre);
	
	/**
	 * Obtener canciones por parte del estilo
	 * @param estilo parte del estilo
	 * @return canciones inluyendo el estilo asociado
	 */
	@Query("from Cancion c join fetch c.estilo e where e.nombre like %?1%")
	Iterable<Cancion> buscarPorEstilo(String estilo);
}
