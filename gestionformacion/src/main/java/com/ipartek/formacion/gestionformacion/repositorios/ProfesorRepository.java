package com.ipartek.formacion.gestionformacion.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ipartek.formacion.gestionformacion.entidades.Profesor;

@RepositoryRestResource(path = "profesores", collectionResourceRel = "profesores")
public interface ProfesorRepository extends JpaRepository<Profesor, Long> {

}
