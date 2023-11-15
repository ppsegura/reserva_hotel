package com.api.hotel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.hotel.model.Hotel;
import com.api.hotel.repository.IHotelRepository;
import com.api.hotel.service.IHotelService;

@Service
public class HotelServiceImpl implements IHotelService {

	@Autowired
	IHotelRepository ihotelRepository;
	
	@Override
	public Hotel registrar(Hotel hotel) {
		// TODO Auto-generated method stub
		return ihotelRepository.save(hotel);
	}

	@Override
	public Hotel modificar(Hotel hotel) {
		// TODO Auto-generated method stub
		return ihotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> listar() {
		// TODO Auto-generated method stub
		return ihotelRepository.findAll();
	}

	@Override
	public Hotel listarPorId(int id) {
		// TODO Auto-generated method stub
		return ihotelRepository.findById(id).get();
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		ihotelRepository.deleteById(id);
	}

}
