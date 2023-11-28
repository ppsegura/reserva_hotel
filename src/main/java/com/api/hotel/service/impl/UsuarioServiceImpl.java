package com.api.hotel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.api.hotel.model.Usuario;
import com.api.hotel.repository.IUsuarioRepository;
import com.api.hotel.service.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
	IUsuarioRepository iUsuarioRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder; 
	
	@Override
	public Usuario registrar(Usuario usuario) {
		String passwordCodificado = passwordEncoder.encode(usuario.getPassword());
        usuario.setPassword(passwordCodificado);
		return iUsuarioRepository.save(usuario);
	}

	@Override
	public Usuario modificar(Usuario usuario) {
		String passwordCodificado = passwordEncoder.encode(usuario.getPassword());
        usuario.setPassword(passwordCodificado);
		return iUsuarioRepository.save(usuario);
	}

	@Override
	public List<Usuario> listar() {
		// TODO Auto-generated method stub
		return iUsuarioRepository.findAll();
	}

	@Override
	public Usuario listarPorId(int id) {
		// TODO Auto-generated method stub
		return iUsuarioRepository.findById(id).get();
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		iUsuarioRepository.deleteById(id);
	}

	@Override
	public Usuario findByNombre(String nombre) {
	    return iUsuarioRepository.findByUsername(nombre).orElse(null);
	}

}
