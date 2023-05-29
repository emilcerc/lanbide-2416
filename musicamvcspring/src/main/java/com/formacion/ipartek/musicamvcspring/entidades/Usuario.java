package com.formacion.ipartek.musicamvcspring.entidades;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// LOMBOK
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
// JPA
@Entity
@Table(name = "usuarios")
public class Usuario {
	// JPA
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// VALIDATION
	@NotNull
	@Email
	@Size(max = 50)
	// JPA
	@Column(unique = true)
	private String email;

	// VALIDATION
	@NotNull
	@NotBlank
	// @Pattern(regexp = "")
	// JPA
	@Column(columnDefinition = "CHAR(60)")
	private String password;

	// VALIDATION
	@NotNull
	@NotBlank
	@Size(max = 50)
	private String nombre;
	
	// JPA
	@ManyToMany(mappedBy = "usuarios")
	private Set<Rol> roles;
}
