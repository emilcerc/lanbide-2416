package com.formacion.ipartek.musicamvcspring.presentacion.configuraciones;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	@Autowired
	private DataSource dataSource;
	
	@Bean
	PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)
	  throws Exception {
	    auth.jdbcAuthentication().dataSource(dataSource)
	    .usersByUsernameQuery("SELECT email, password, 1 FROM usuarios WHERE email = ?")
	    .authoritiesByUsernameQuery("""
	    		SELECT u.email, CONCAT('ROLE_',r.nombre)
	    		FROM usuarios u
	    		JOIN roles_usuarios ur ON u.id = ur.usuarios_id
	    		JOIN roles r ON ur.roles_id = r.id
	    		WHERE u.email = ?
	    		"""
	    );
	}
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf((csrf) -> csrf.disable())
			.authorizeHttpRequests((requests) -> requests
				.requestMatchers("/admin/**").hasRole("ADMIN")
				.requestMatchers("/usuarios/**").hasRole("USER")
				.anyRequest().permitAll()
			)
			.formLogin((form) -> form
				.loginPage("/login")
				.defaultSuccessUrl("/procesar-usuario")
				.permitAll()
			)
			.logout((logout) -> logout.permitAll());

		return http.build();
	}

// https://www.baeldung.com/spring-security-jdbc-authentication

// https://bcrypt-generator.com/
}
