package com.api.hotel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.hotel.model.Habitacion;
import com.api.hotel.repository.IHabitacionRepository;
import com.api.hotel.service.IHabitacionService;

@Service
public class HabitacionServiceImpl implements IHabitacionService {

	@Autowired
	IHabitacionRepository ihabitacionRepository;
	
	@Override
	public Habitacion registrar(Habitacion habitacion) {
		// TODO Auto-generated method stub
		return ihabitacionRepository.save(habitacion);
	}

	@Override
	public Habitacion modificar(Habitacion habitacion) {
		// TODO Auto-generated method stub
		return ihabitacionRepository.save(habitacion);
	}

	@Override
	public List<Habitacion> listar() {
		// TODO Auto-generated method stub
		return ihabitacionRepository.findAll();
	}

	@Override
	public Habitacion listarPorId(int id) {
		// TODO Auto-generated method stub
		return ihabitacionRepository.findById(id).get();
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		ihabitacionRepository.deleteById(id);
	}

}
