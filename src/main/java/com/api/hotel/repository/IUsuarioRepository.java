package com.api.hotel.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.hotel.model.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	Optional<Usuario> findByUsername(String username);

}
