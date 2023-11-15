package com.api.hotel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.hotel.model.Usuario;
import com.api.hotel.repository.IUsuarioRepository;
import com.api.hotel.service.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
	IUsuarioRepository iUsuarioRepository;
	
	@Override
	public Usuario registrar(Usuario usuario) {
		// TODO Auto-generated method stub
		return iUsuarioRepository.save(usuario);
	}

	@Override
	public Usuario modificar(Usuario usuario) {
		// TODO Auto-generated method stub
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

}
