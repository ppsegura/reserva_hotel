package com.api.hotel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.hotel.model.Rol;
import com.api.hotel.repository.IRolRepository;
import com.api.hotel.service.IRolService;

@Service
public class RolServiceImpl implements IRolService {

	@Autowired
	IRolRepository iRolRepository;
	
	@Override
	public Rol registrar(Rol rol) {
		// TODO Auto-generated method stub
		return iRolRepository.save(rol);
	}

	@Override
	public Rol modificar(Rol rol) {
		// TODO Auto-generated method stub
		return iRolRepository.save(rol);
	}

	@Override
	public List<Rol> listar() {
		// TODO Auto-generated method stub
		return iRolRepository.findAll();
	}

	@Override
	public Rol listarPorId(int id) {
		// TODO Auto-generated method stub
		return iRolRepository.findById(id).get();
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		iRolRepository.deleteById(id);
	}

}
