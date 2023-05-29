package com.formacion.ipartek.musicamvcspring.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.formacion.ipartek.musicamvcspring.entidades.Rol;

@RepositoryRestResource(path = "roles", collectionResourceRel = "roles")
public interface RolRepository extends CrudRepository<Rol, Long>{

}
