package com.api.hotel.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.api.hotel.model.Usuario;
import com.api.hotel.repository.IUsuarioRepository;


@Service
public class UsuarioDetailsServiceImpl implements UserDetailsService {

	@Autowired
	IUsuarioRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario userEntity = this.userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User " + username + " not found."));

		//String[] roles = userEntity.getRoles().stream().map(Role::getRole).toArray(String[]::new);
		
		
        return User.builder()
                .username(userEntity.getUsername())
                .password(userEntity.getPassword())
                .roles("ADMIN")
                .accountLocked(userEntity.getLocked())
                .disabled(userEntity.getDisabled())
                .build();
	}

}
