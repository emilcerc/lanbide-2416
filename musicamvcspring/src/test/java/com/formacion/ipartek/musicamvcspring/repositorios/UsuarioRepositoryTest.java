package com.formacion.ipartek.musicamvcspring.repositorios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.formacion.ipartek.musicamvcspring.entidades.Usuario;

@SpringBootTest
public class UsuarioRepositoryTest {
	@Autowired
	private UsuarioRepository repo;
	
	@Test
	public void buscarPorEmailTest() {
		Usuario usuario = repo.buscarPorEmail("javier@email.net");
		
		assertNotNull(usuario);
		assertEquals("javier@email.net", usuario.getEmail());
		assertEquals(2, usuario.getRoles().size());
	}
}
