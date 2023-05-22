package com.ipartek.formacion.mf0226.logicanegocio;

import com.ipartek.formacion.mf0226.accesodatos.FabricaDao;
import com.ipartek.formacion.mf0226.accesodatos.FabricaDaoImpl;

class Globales {
	static final FabricaDao FABRICA_DAO = new FabricaDaoImpl(); 
}
