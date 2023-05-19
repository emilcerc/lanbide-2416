package com.ipartek.formacion.musicamvc.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
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

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "canciones")
public class Cancion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@NotBlank
	@Size(max = 50)
	private String titulo;
	
	@NotNull
	@NotBlank
	@Size(max = 255)
	private String enlace;
	
	@NotNull
	@NotBlank
	@Size(max = 100)
	private String grupo;
	
	@NotNull
	@Builder.Default
	@Column(columnDefinition = "TINYINT")
	private Boolean borrado = false;
	
	@NotNull
	@ManyToOne
	private Estilo estilo;
	
	@NotNull
	@ManyToOne
	@JsonIgnore
	private Usuario usuario;
}
