package com.ipartek.formacion.mf0226.accesodatos.jpa;

import com.ipartek.formacion.mf0226.accesodatos.AccesoDatosException;
import com.ipartek.formacion.mf0226.accesodatos.UsuarioDao;
import com.ipartek.formacion.mf0226.entidades.Usuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;

public class JpaUsuarioDao implements UsuarioDao {

	private EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("com.ipartek.formacion.mf0226.entidades");

	@Override
	public Usuario obtenerPorEmail(String email) {
		try {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			
			Usuario usuario;
			
			try {
				usuario = em.createQuery("from Usuario u join fetch u.rol where email = '" + email + "'", Usuario.class).getSingleResult();
			} catch (NoResultException e) {
				usuario = null;
			}
			
			em.getTransaction().commit();
			em.close();

			return usuario;
		} catch (Exception e) {
			throw new AccesoDatosException("No se ha podido buscar el usuario por email", e);
		}
	}
	
}
