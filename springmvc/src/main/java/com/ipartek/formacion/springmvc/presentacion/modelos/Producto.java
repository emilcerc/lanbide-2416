package com.ipartek.formacion.springmvc.presentacion.modelos;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Data;

@Data
public class Producto {
	private Long id;
	private String nombre;
	private BigDecimal precio;
	private LocalDate caducidad;
}
