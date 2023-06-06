package com.formacion.ipartek.multi.servicios;

import org.springframework.data.domain.Pageable;

import com.formacion.ipartek.multi.entidades.Cancion;

/**
 * Servicio para usuarios administradores
 * @author javierlete
 * @version 1.0
 *
 */
public interface AdminService {
	/**
	 * Obtención de las canciones <strong>en base a páginas y ordenación a medida</strong>
	 * @param pageable información de paginación y ordenación
	 * @return conjunto de canciones de la página y ordenación correspondiente
	 */
	Iterable<Cancion> obtenerPagina(Pageable pageable);

	/**
	 * Cuenta el número de canciones
	 * @return número de canciones
	 */
	long getNumeroCanciones();
}
