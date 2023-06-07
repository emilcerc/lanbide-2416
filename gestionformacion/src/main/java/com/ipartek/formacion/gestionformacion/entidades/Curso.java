package com.ipartek.formacion.gestionformacion.entidades;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "cursos")
public class Curso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@NotBlank
	@Pattern(regexp = "[A-Z]{4}\\d{4}")
	@Size(min = 8, max = 8)
	private String identificador;
	
	@NotNull
	private LocalDate fechaInicio;
	
	@NotNull
	private Integer horas;
	
	@NotNull
	@ManyToOne
	private Materia materia;
	
	@NotNull
	@ManyToOne
	private Profesor profesor;
}
