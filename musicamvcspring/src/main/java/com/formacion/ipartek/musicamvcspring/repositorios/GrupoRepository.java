package com.formacion.ipartek.musicamvcspring.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.formacion.ipartek.musicamvcspring.entidades.Grupo;

@RepositoryRestResource(path = "grupos", collectionResourceRel = "grupos")
public interface GrupoRepository extends CrudRepository<Grupo, Long>{
	Iterable<Grupo> findByNombreContains(String nombre);
}
