package com.ipartek.formacion.gestionformacion.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ipartek.formacion.gestionformacion.entidades.Materia;

@RepositoryRestResource(path = "materias", collectionResourceRel = "materias")
public interface MateriaRepository extends JpaRepository<Materia, Long> {

}
