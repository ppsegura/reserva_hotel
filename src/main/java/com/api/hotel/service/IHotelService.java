package com.api.hotel.service;

import java.util.List;

import com.api.hotel.model.Hotel;

public interface IHotelService {

	Hotel registrar(Hotel hotel);

	Hotel modificar(Hotel hotel);

	List<Hotel> listar();

	Hotel listarPorId(int id);

	void eliminar(int id);
	
}
