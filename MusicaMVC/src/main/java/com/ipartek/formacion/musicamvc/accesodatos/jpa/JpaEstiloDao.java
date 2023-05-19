package com.ipartek.formacion.musicamvc.accesodatos.jpa;

import java.util.List;

import com.ipartek.formacion.musicamvc.accesodatos.AccesoDatosException;
import com.ipartek.formacion.musicamvc.accesodatos.EstiloDao;
import com.ipartek.formacion.musicamvc.entidades.Estilo;

import jakarta.persistence.EntityManager;

public class JpaEstiloDao implements EstiloDao {

	@Override
	public Iterable<Estilo> obtenerTodos() {
		EntityManager em = Globales.EMF.createEntityManager();
		em.getTransaction().begin();
		
		List<Estilo> estilos = em.createQuery("from Estilo", Estilo.class).getResultList();
		
		em.getTransaction().commit();
		em.close();
		
		return estilos;
	}

	@Override
	public Estilo obtenerPorId(Long id) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}

	@Override
	public Estilo insertar(Estilo objeto) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}

	@Override
	public Estilo modificar(Estilo objeto) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}

	@Override
	public void borrar(Long id) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}

}
