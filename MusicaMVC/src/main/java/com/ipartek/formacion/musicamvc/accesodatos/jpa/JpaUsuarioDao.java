package com.ipartek.formacion.musicamvc.accesodatos.jpa;

import java.util.List;

import com.ipartek.formacion.musicamvc.accesodatos.UsuarioDao;
import com.ipartek.formacion.musicamvc.entidades.Usuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

public class JpaUsuarioDao implements UsuarioDao {

	@Override
	public Iterable<Usuario> obtenerTodos() {
		EntityManager em = Globales.EMF.createEntityManager();
		em.getTransaction().begin();
		
		List<Usuario> usuarios = em.createQuery("from Usuario", Usuario.class).getResultList();
		
		em.getTransaction().commit();
		em.close();
		
		return usuarios;
	}

	@Override
	public Usuario obtenerPorId(Long id) {
		EntityManager em = Globales.EMF.createEntityManager();
		em.getTransaction().begin();
		
		Usuario usuario = em.find(Usuario.class, id);
		
		em.getTransaction().commit();
		em.close();
		
		return usuario;
	}

	@Override
	public Usuario insertar(Usuario usuario) {
		EntityManager em = Globales.EMF.createEntityManager();
		em.getTransaction().begin();
		
		em.persist(usuario);
		
		em.getTransaction().commit();
		em.close();
		
		return usuario;
	}

	@Override
	public Usuario modificar(Usuario usuario) {
		EntityManager em = Globales.EMF.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(usuario);
		
		em.getTransaction().commit();
		em.close();
		
		return usuario;
	}

	@Override
	public void borrar(Long id) {
		EntityManager em = Globales.EMF.createEntityManager();
		em.getTransaction().begin();
		
		em.remove(em.find(Usuario.class, id));
		
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Usuario buscarPorEmail(String email) {
		EntityManager em = Globales.EMF.createEntityManager();
		em.getTransaction().begin();
		
		TypedQuery<Usuario> consulta = em.createQuery("from Usuario where email = ?1", Usuario.class);
		
		consulta.setParameter(1, email);
		
		Usuario usuario;
		
		try {
			usuario = consulta.getSingleResult();
		} catch (NoResultException e) {
			usuario = null;
		}
		
		em.getTransaction().commit();
		em.close();
		
		return usuario;
	}
}
