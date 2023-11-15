package com.api.hotel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.hotel.model.User_Roles;
import com.api.hotel.repository.IUser_RolesRepository;
import com.api.hotel.service.IUser_RolesService;

@Service
public class User_RolesServiceImpl implements IUser_RolesService {

	@Autowired
	IUser_RolesRepository iUser_RolesRepository;
	
	@Override
	public User_Roles registrar(User_Roles userRoles) {
		// TODO Auto-generated method stub
		return iUser_RolesRepository.save(userRoles);
	}

	@Override
	public User_Roles modificar(User_Roles userRoles) {
		// TODO Auto-generated method stub
		return iUser_RolesRepository.save(userRoles);
	}

	@Override
	public List<User_Roles> listar() {
		// TODO Auto-generated method stub
		return iUser_RolesRepository.findAll();
	}

	@Override
	public User_Roles listarPorId(int id) {
		// TODO Auto-generated method stub
		return iUser_RolesRepository.findById(id).get();
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		iUser_RolesRepository.deleteById(id);
	}

}
