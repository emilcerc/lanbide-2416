package com.ipartek.formacion.musicamvc.presentacion.controladores;

import com.ipartek.formacion.musicamvc.logicanegocio.AnonimoNegocio;
import com.ipartek.formacion.musicamvc.logicanegocio.AnonimoNegocioImpl;

public class Globales {
	public static final String RAIZ = "/WEB-INF/vistas";
	
	public static final AnonimoNegocio ANONIMO_NEGOCIO = new AnonimoNegocioImpl();
}
