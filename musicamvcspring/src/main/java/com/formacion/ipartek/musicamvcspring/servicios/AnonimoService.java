package com.formacion.ipartek.musicamvcspring.servicios;

import com.formacion.ipartek.musicamvcspring.entidades.Usuario;

public interface AnonimoService {
	Usuario obtenerPorEmail(String email);
}
