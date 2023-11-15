package com.api.hotel.service;

import java.util.List;

import com.api.hotel.model.Rol;

public interface IRolService {

	Rol registrar(Rol rol);
	
	Rol modificar(Rol rol);
	
	List<Rol> listar();
	
	Rol listarPorId(int id);
	
	void eliminar(int id);
	
}
