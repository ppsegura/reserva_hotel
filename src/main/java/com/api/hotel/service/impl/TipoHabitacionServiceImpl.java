package com.api.hotel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.hotel.model.TipoHabitacion;
import com.api.hotel.repository.ITipoHabitacionRepository;
import com.api.hotel.service.ITipoHabitacionService;

@Service
public class TipoHabitacionServiceImpl implements ITipoHabitacionService{

	@Autowired
	ITipoHabitacionRepository iTipoHabitacionRepository;

	@Override
	public List<TipoHabitacion> listar() {
		// TODO Auto-generated method stub
		return iTipoHabitacionRepository.findAll();
	}
	
	
	
}
