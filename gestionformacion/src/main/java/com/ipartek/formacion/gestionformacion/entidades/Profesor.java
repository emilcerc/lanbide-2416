package com.ipartek.formacion.gestionformacion.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "profesores")
public class Profesor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@NotBlank
	@Pattern(regexp = "^[\\dXYZ]\\d{7}[A-Z]$")
	@Column(columnDefinition = "CHAR(9)")
	private String nif;
	
	@NotNull
	@NotBlank
	@Size(max = 50)
	private String nombre;
	
	@NotNull
	@NotBlank
	@Size(max = 100)
	private String apellidos;
}
