package com.formacion.ipartek.multi.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.formacion.ipartek.multi.entidades.Rol;

/**
 * Repositorio de roles
 * @author javierlete
 * @version 1.0
 */
@RepositoryRestResource(path = "roles", collectionResourceRel = "roles")
public interface RolRepository extends CrudRepository<Rol, Long>{

}
