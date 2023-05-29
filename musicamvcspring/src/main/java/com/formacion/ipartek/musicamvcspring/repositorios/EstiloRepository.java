package com.formacion.ipartek.musicamvcspring.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.formacion.ipartek.musicamvcspring.entidades.Estilo;

@RepositoryRestResource(path = "estilos", collectionResourceRel = "estilos")
public interface EstiloRepository extends CrudRepository<Estilo, Long>{
	Iterable<Estilo> findByNombreContains(String nombre);
}
