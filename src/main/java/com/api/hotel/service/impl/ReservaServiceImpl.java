package com.api.hotel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.hotel.model.Reserva;
import com.api.hotel.repository.IReservaRepository;
import com.api.hotel.service.IReservaService;

@Service
public class ReservaServiceImpl implements IReservaService {

	@Autowired
	IReservaRepository iReservaRepository;
	
	@Override
	public Reserva registrar(Reserva reserva) {
		// TODO Auto-generated method stub
		return iReservaRepository.save(reserva);
	}

	@Override
	public Reserva modificar(Reserva reserva) {
		// TODO Auto-generated method stub
		return iReservaRepository.save(reserva);
	}

	@Override
	public List<Reserva> listar() {
		// TODO Auto-generated method stub
		return iReservaRepository.findAll();
	}

	@Override
	public Reserva listarPorId(int id) {
		// TODO Auto-generated method stub
		return iReservaRepository.findById(id).get();
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		iReservaRepository.deleteById(id);
	}

}
