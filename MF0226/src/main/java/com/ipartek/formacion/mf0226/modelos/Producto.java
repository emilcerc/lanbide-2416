package com.ipartek.formacion.mf0226.modelos;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Producto {
	@Min(0)
	private Long id;
	
	@NotNull
	@Size(min = 3, max = 50)
	private String nombre;
	
	@NotNull(message = "no debe estar vacío")
	@Min(0)
	private BigDecimal precio;
	
	@Future
	private LocalDate garantia;
}
