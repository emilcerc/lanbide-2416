package com.formacion.ipartek.musicamvcspring.servicios;

import com.formacion.ipartek.musicamvcspring.entidades.Usuario;

/**
 * Funcionalidades de la aplicación que no requieren estar logueado
 * a nivel interno
 * @author javierlete
 * @version 1.0
 */
public interface AnonimoService {
	/**
	 * Servicio <strong>interno</strong> de la aplicación 
	 * para obtener los datos de un usuario mediante su email
	 * @param email email recibido normalmente mediante login
	 * @return usuario completo con todos sus datos
	 */
	Usuario obtenerPorEmail(String email);
}
