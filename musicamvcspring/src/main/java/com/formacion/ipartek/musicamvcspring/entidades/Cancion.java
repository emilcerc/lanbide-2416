package com.formacion.ipartek.musicamvcspring.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//LOMBOK
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//JPA
@Entity
@Table(name = "canciones")
public class Cancion {
	// JPA
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// VALIDATION
	@NotNull
	@NotBlank
	@Size(max = 50)
	private String titulo;

	// VALIDATION
	@NotNull
	@NotBlank
	@Size(max = 255)
	private String url;

	// JPA
	@NotNull
	@ManyToOne
	private Grupo grupo;
	
	// JPA
	@NotNull
	@ManyToOne
	private Estilo estilo;
	
	// JPA
	@NotNull
	@ManyToOne
	private Usuario usuario;
}
