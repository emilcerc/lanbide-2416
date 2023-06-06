package com.formacion.ipartek.musicamvcspring.entidades;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

//LOMBOK
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//JPA
@Entity
@Table(name = "roles")
public class Rol {
	// JPA
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	// VALIDATION
	@NotNull
	@NotBlank
	@Size(max = 50)
	// JPA
	@Column(unique = true)
	private String nombre;
	
	// VALIDATION
	@Size(max = 255)
	private String descripcion;

	// LOMBOK
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	// JPA
	@ManyToMany
	private Set<Usuario> usuarios;
}
