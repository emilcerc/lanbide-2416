package com.ipartek.formacion.springmvc.repositorios.springdatajpa;

import java.math.BigDecimal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ipartek.formacion.springmvc.entidades.Producto;

@RepositoryRestResource(collectionResourceRel = "productos", path="productos")
public interface ProductoRepository extends CrudRepository<Producto, Long> {
	Iterable<Producto> findByNombreContains(String nombre);
	Iterable<Producto> findByPrecioBetween(BigDecimal min, BigDecimal max);
}
