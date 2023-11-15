package com.api.hotel.service;

import java.util.List;

import com.api.hotel.model.Usuario;

public interface IUsuarioService {

	Usuario registrar(Usuario usuario);
	
	Usuario modificar(Usuario usuario);
	
	List<Usuario> listar();
	
	Usuario listarPorId(int id);
	
	void eliminar(int id);
	
}
