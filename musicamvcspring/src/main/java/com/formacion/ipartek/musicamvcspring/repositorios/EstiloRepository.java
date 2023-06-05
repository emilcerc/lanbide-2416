package com.formacion.ipartek.musicamvcspring.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.formacion.ipartek.musicamvcspring.entidades.Estilo;

/**
 * Repositorio de estilos
 * @author javierlete
 * @version 1.0
 */
@RepositoryRestResource(path = "estilos", collectionResourceRel = "estilos")
public interface EstiloRepository extends CrudRepository<Estilo, Long>{
	/**
	 * Buscar por parte del nombre
	 * @param nombre parte del nombre
	 * @return estilos que incluyen esa parte del nombre
	 */
	Iterable<Estilo> findByNombreContains(String nombre);
}
