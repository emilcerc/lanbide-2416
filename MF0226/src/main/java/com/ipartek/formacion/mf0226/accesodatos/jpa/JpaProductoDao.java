package com.ipartek.formacion.mf0226.accesodatos.jpa;

import java.math.BigDecimal;
import java.util.List;

import com.ipartek.formacion.mf0226.accesodatos.ProductoDao;
import com.ipartek.formacion.mf0226.entidades.Producto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class JpaProductoDao implements ProductoDao {

	private EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("com.ipartek.formacion.mf0226.entidades");

	@Override
	public Iterable<Producto> obtenerTodos() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		List<Producto> productos = em.createQuery("from Producto", Producto.class).getResultList();
		
		em.getTransaction().commit();
		em.close();

		return productos;
	}

	@Override
	public Producto obtenerPorId(Long id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Producto producto = em.find(Producto.class, id);
		
		em.getTransaction().commit();
		em.close();

		return producto;
	}

	@Override
	public Producto insertar(Producto producto) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		em.persist(producto);
		
		em.getTransaction().commit();
		em.close();

		return producto;
	}

	@Override
	public Producto modificar(Producto producto) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(producto);
		
		em.getTransaction().commit();
		em.close();

		return producto;
	}

	@Override
	public void borrar(Long id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		em.remove(em.find(Producto.class, id));
		
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Iterable<Producto> buscarPorNombre(String parteDelNombre) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		parteDelNombre = "'%" + parteDelNombre + "%'";
		
		// TODO: cambiar la concatenación por parámetros
		List<Producto> productos = em.createQuery("from Producto where nombre like " + parteDelNombre, Producto.class).getResultList();
		
		em.getTransaction().commit();
		em.close();

		return productos;
	}

	@Override
	public Iterable<Producto> buscarPorPrecio(BigDecimal minimo, BigDecimal maximo) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		List<Producto> productos = em.createQuery("from Producto where precio between " + minimo + " and " + maximo , Producto.class).getResultList();
		
		em.getTransaction().commit();
		em.close();

		return productos;
	}

	@Override
	public Iterable<Producto> buscar(String nombre, BigDecimal minimo, BigDecimal maximo) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		TypedQuery<Producto> consulta = em.createQuery("from Producto where nombre like ?1 and precio between ?2 and ?3", Producto.class);
		
		consulta.setParameter(1, "%" + nombre + "%");
		consulta.setParameter(2, minimo);
		consulta.setParameter(3, maximo);
		
		List<Producto> productos = consulta.getResultList();
		
		em.getTransaction().commit();
		em.close();

		return productos;
	}

}
