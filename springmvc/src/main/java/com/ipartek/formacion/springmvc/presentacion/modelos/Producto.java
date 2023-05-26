package com.ipartek.formacion.springmvc.presentacion.modelos;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Producto {
	@Min(0)
	private Long id;
	
	@NotNull
	@NotBlank
	@Size(max = 50)
	private String nombre;
	
	@NotNull
	@Min(0)
	private BigDecimal precio;
	
	@DateTimeFormat(iso = ISO.DATE)
	@FutureOrPresent
	private LocalDate caducidad;
}
