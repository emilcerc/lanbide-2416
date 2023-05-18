package com.ipartek.formacion.musicamvc.accesodatos.jpa;

import java.util.List;

import com.ipartek.formacion.musicamvc.accesodatos.CancionDao;
import com.ipartek.formacion.musicamvc.entidades.Cancion;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class JpaCancionDao implements CancionDao {

	@Override
	public Iterable<Cancion> obtenerTodos() {
		EntityManager em = Globales.EMF.createEntityManager();
		em.getTransaction().begin();
		
		List<Cancion> canciones = em.createQuery("from Cancion", Cancion.class).getResultList();
		
		em.getTransaction().commit();
		em.close();
		
		return canciones;
	}

	@Override
	public Cancion obtenerPorId(Long id) {
		EntityManager em = Globales.EMF.createEntityManager();
		em.getTransaction().begin();
		
		Cancion cancion = em.find(Cancion.class, id);
		
		em.getTransaction().commit();
		em.close();
		
		return cancion;
	}

	@Override
	public Cancion insertar(Cancion cancion) {
		EntityManager em = Globales.EMF.createEntityManager();
		em.getTransaction().begin();
		
		em.persist(cancion);
		
		em.getTransaction().commit();
		em.close();
		
		return cancion;
	}

	@Override
	public Cancion modificar(Cancion cancion) {
		EntityManager em = Globales.EMF.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(cancion);
		
		em.getTransaction().commit();
		em.close();
		
		return cancion;
	}

	@Override
	public void borrar(Long id) {
		EntityManager em = Globales.EMF.createEntityManager();
		em.getTransaction().begin();
		
		em.remove(em.find(Cancion.class, id));
		
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Iterable<Cancion> buscarPorNombre(String nombre) {
		EntityManager em = Globales.EMF.createEntityManager();
		em.getTransaction().begin();
		
		TypedQuery<Cancion> consulta = em.createQuery("from Cancion where nombre like ?1", Cancion.class);
		
		consulta.setParameter(1, "%" + nombre + "%");
		
		List<Cancion> canciones = consulta.getResultList();
		
		em.getTransaction().commit();
		em.close();
		
		return canciones;
	}

	@Override
	public Iterable<Cancion> buscarPorEstilo(String estilo) {
		EntityManager em = Globales.EMF.createEntityManager();
		em.getTransaction().begin();
		
		TypedQuery<Cancion> consulta = em.createQuery("from Cancion where estilo.nombre like ?1", Cancion.class);
		
		consulta.setParameter(1, "%" + estilo + "%");
		
		List<Cancion> canciones = consulta.getResultList();
		
		em.getTransaction().commit();
		em.close();
		
		return canciones;
	}

	@Override
	public Iterable<Cancion> buscarPorGrupo(String grupo) {
		EntityManager em = Globales.EMF.createEntityManager();
		em.getTransaction().begin();
		
		TypedQuery<Cancion> consulta = em.createQuery("from Cancion where grupo like ?1", Cancion.class);
		
		consulta.setParameter(1, "%" + grupo + "%");
		
		List<Cancion> canciones = consulta.getResultList();
		
		em.getTransaction().commit();
		em.close();
		
		return canciones;
	}

	@Override
	public Iterable<Cancion> buscarPorNombreUsuario(String nombre) {
		EntityManager em = Globales.EMF.createEntityManager();
		em.getTransaction().begin();
		
		TypedQuery<Cancion> consulta = em.createQuery("from Cancion where usuario.nombre like ?1", Cancion.class);
		
		consulta.setParameter(1, "%" + nombre + "%");
		
		List<Cancion> canciones = consulta.getResultList();
		
		em.getTransaction().commit();
		em.close();
		
		return canciones;
	}

	@Override
	public Iterable<Cancion> buscarPorEmail(String email) {
		EntityManager em = Globales.EMF.createEntityManager();
		em.getTransaction().begin();
		
		TypedQuery<Cancion> consulta = em.createQuery("from Cancion where usuario.email = ?1", Cancion.class);
		
		consulta.setParameter(1, email);
		
		List<Cancion> canciones = consulta.getResultList();
		
		em.getTransaction().commit();
		em.close();
		
		return canciones;
	}

	@Override
	public Iterable<Cancion> buscarPorIdUsuario(Long id) {
		EntityManager em = Globales.EMF.createEntityManager();
		em.getTransaction().begin();
		
		TypedQuery<Cancion> consulta = em.createQuery("from Cancion where usuario.id = ?1", Cancion.class);
		
		consulta.setParameter(1, id);
		
		List<Cancion> canciones = consulta.getResultList();
		
		em.getTransaction().commit();
		em.close();
		
		return canciones;
	}

	@Override
	public Iterable<Cancion> buscarPorNombreYUsuarioId(String nombre, Long idUsuario) {
		EntityManager em = Globales.EMF.createEntityManager();
		em.getTransaction().begin();
		
		TypedQuery<Cancion> consulta = em.createQuery("from Cancion where nombre like ?1 and usuario.id = ?2", Cancion.class);
		
		consulta.setParameter(1, "%" + nombre + "%");
		consulta.setParameter(2, idUsuario);
		
		List<Cancion> canciones = consulta.getResultList();
		
		em.getTransaction().commit();
		em.close();
		
		return canciones;
	}

	@Override
	public Iterable<Cancion> buscarPorEstiloYUsuarioId(String estilo, Long idUsuario) {
		EntityManager em = Globales.EMF.createEntityManager();
		em.getTransaction().begin();
		
		TypedQuery<Cancion> consulta = em.createQuery("from Cancion where estilo.nombre like ?1 and usuario.id = ?2", Cancion.class);
		
		consulta.setParameter(1, "%" + estilo + "%");
		consulta.setParameter(2, idUsuario);
		
		List<Cancion> canciones = consulta.getResultList();
		
		em.getTransaction().commit();
		em.close();
		
		return canciones;
	}

	@Override
	public Iterable<Cancion> buscarPorGrupoYUsuarioId(String grupo, Long idUsuario) {
		EntityManager em = Globales.EMF.createEntityManager();
		em.getTransaction().begin();
		
		TypedQuery<Cancion> consulta = em.createQuery("from Cancion where grupo like ?1 and usuario.id = ?2", Cancion.class);
		
		consulta.setParameter(1, "%" + grupo + "%");
		consulta.setParameter(2, idUsuario);
		
		List<Cancion> canciones = consulta.getResultList();
		
		em.getTransaction().commit();
		em.close();
		
		return canciones;
	}

}
