package com.ipartek.formacion.musicamvc.accesodatos.jpa;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

class Globales {
	static final EntityManagerFactory EMF =Persistence
			.createEntityManagerFactory("com.ipartek.formacion.musicamvc.entidades"); 
}
