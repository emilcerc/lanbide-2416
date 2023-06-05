package com.formacion.ipartek.musicamvcspring.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.formacion.ipartek.musicamvcspring.entidades.Grupo;

/**
 * Repositorio de grupo
 * @author javierlete
 * @version 1.0
 */
@RepositoryRestResource(path = "grupos", collectionResourceRel = "grupos")
public interface GrupoRepository extends CrudRepository<Grupo, Long>{
	/**
	 * Buscar por parte del nombre del grupo
	 * @param nombre parte de nombre del grupo
	 * @return grupos grupos que contienen esa parte del nombre
	 */
	Iterable<Grupo> findByNombreContains(String nombre);
}
