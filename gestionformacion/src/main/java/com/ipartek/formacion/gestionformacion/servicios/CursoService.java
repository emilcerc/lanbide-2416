package com.ipartek.formacion.gestionformacion.servicios;

import com.ipartek.formacion.gestionformacion.entidades.Curso;
import com.ipartek.formacion.gestionformacion.entidades.Materia;
import com.ipartek.formacion.gestionformacion.entidades.Profesor;

public interface CursoService {
	Iterable<Curso> listado();
	Curso alta(Curso curso);
	
	Iterable<Profesor> listadoProfesores();
	Iterable<Materia> listadoMaterias();
}
