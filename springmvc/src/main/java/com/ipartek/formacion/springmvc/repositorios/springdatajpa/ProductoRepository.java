package com.ipartek.formacion.springmvc.repositorios.springdatajpa;

import java.math.BigDecimal;

import org.springframework.data.repository.CrudRepository;

import com.ipartek.formacion.springmvc.entidades.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Long> {
	Producto findByNombreContains(String nombre);
	Iterable<Producto> findByPrecioBetween(BigDecimal min, BigDecimal max);
}
