package com.api.hotel.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http
			.csrf(csrf -> csrf.disable())
			.authorizeHttpRequests((requests) -> requests
					
			// Accesible para todos
			.requestMatchers(HttpMethod.POST, "/usuario*").permitAll()
			.requestMatchers(HttpMethod.GET, "/hotel*").permitAll()
			.requestMatchers(HttpMethod.GET, "/tipoHabitacion*").permitAll()
			.requestMatchers(HttpMethod.GET, "/habitacion*").permitAll()
			
			// Reserva
			.requestMatchers("reserva*").hasAnyRole("ADMIN", "USER")
			
			// Hotel : admin
			.requestMatchers(HttpMethod.POST, "hotel*").hasRole("ADMIN")
			.requestMatchers(HttpMethod.PUT, "hotel/{id}").hasRole("ADMIN")
			.requestMatchers(HttpMethod.DELETE, "hotel/{id}").hasRole("ADMIN")
			
			//Habitacion : admin
			.requestMatchers(HttpMethod.POST, "habitacion*").hasRole("ADMIN")
			.requestMatchers(HttpMethod.PUT, "habitacion/{id}").hasRole("ADMIN")
			.requestMatchers(HttpMethod.DELETE, "habitacion/{id}").hasRole("ADMIN")
			
			// Usuario : user
			.requestMatchers(HttpMethod.GET, "usuario*").hasAnyRole("ADMIN", "USER")
			.requestMatchers(HttpMethod.PUT, "usuario/{id}").hasAnyRole("ADMIN", "USER")
			
			// Usuario : admin
			.requestMatchers(HttpMethod.DELETE, "usuario/{id}").hasRole("ADMIN")
			
			.anyRequest().authenticated())
			.httpBasic(Customizer.withDefaults());
		
		return http.build();
	}
		
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
    }
	
	
	
}
