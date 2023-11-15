package com.api.hotel.service;

import java.util.List;

import com.api.hotel.model.User_Roles;

public interface IUser_RolesService {

	User_Roles registrar(User_Roles userRoles);
	
	User_Roles modificar(User_Roles userRoles);
	
	List<User_Roles> listar();
	
	User_Roles listarPorId(int id);
	
	void eliminar(int id);
	
}
