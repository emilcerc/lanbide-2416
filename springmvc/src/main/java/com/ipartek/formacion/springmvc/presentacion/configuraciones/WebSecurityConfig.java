package com.ipartek.formacion.springmvc.presentacion.configuraciones;

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
	    .usersByUsernameQuery("SELECT usuario, pass, 1 FROM usuarios WHERE usuario = ?")
	    .authoritiesByUsernameQuery("""
	    		SELECT usuario, CONCAT('ROLE_',nombre)
	    		FROM usuarios u
	    		JOIN usuarios_roles ur ON u.id = ur.usuarios_id
	    		JOIN roles r ON ur.roles_id = r.id
	    		WHERE usuario = ?
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
				.permitAll()
			)
			.logout((logout) -> logout.permitAll());

		return http.build();
	}

// https://www.baeldung.com/spring-security-jdbc-authentication

// https://bcrypt-generator.com/	

/*
CREATE TABLE users (
  username VARCHAR(50) NOT NULL,
  password VARCHAR(100) NOT NULL,
  enabled TINYINT NOT NULL DEFAULT 1,
  PRIMARY KEY (username)
);
  
CREATE TABLE authorities (
  username VARCHAR(50) NOT NULL,
  authority VARCHAR(50) NOT NULL,
  FOREIGN KEY (username) REFERENCES users(username)
);

CREATE UNIQUE INDEX ix_auth_username
  on authorities (username,authority);

-- User user/pass
INSERT INTO users (username, password, enabled)
  values ('javier',
    '$2a$12$UptGwHx1AOl42C/0zx0YTO7f5eMlh9x2Yv4PP320JO22vvnCLRJtm',
    1), ('pepe', '$2a$12$o/wy2BHxC62Vg3XBZ42SXul9aHwna33h/hddBAilDGF3OnfvkQikC', 1);

INSERT INTO authorities (username, authority)
  values ('javier', 'ROLE_USER'), ('javier', 'ROLE_ADMIN'), ('pepe', 'ROLE_USER');
*/

}
