package com.ipartek.formacion.gestionformacion.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ipartek.formacion.gestionformacion.entidades.Curso;

@RepositoryRestResource(path = "cursos", collectionResourceRel = "cursos")
public interface CursoRepository extends JpaRepository<Curso, Long> {
	@Query("from Curso c join fetch c.materia join fetch c.profesor")
	Iterable<Curso> listadoCompleto();
}
