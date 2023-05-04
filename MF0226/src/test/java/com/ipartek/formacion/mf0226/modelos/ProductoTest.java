package com.ipartek.formacion.mf0226.modelos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class ProductoTest {

	@Test
	public void equals() {
		Producto p1 = new Producto(1L, "P1", new BigDecimal("1234"), LocalDate.of(2000, 2, 3));
		Producto p2 = new Producto(1L, "P1", new BigDecimal("1234"), LocalDate.of(2000, 2, 3));
		
		assertEquals(p1, p2);
	}
	
	@Test
	public void builder() {
		Producto p = new Producto(1L, "P1", new BigDecimal("1234"), LocalDate.of(2000, 2, 3));
		
		Producto b = Producto.builder()
				.id(1L)
				.nombre("P1")
				.precio(new BigDecimal("1234"))
				.garantia(LocalDate.of(2000,  2, 3))
			.build();
		
		assertEquals(p, b);
	}
}
