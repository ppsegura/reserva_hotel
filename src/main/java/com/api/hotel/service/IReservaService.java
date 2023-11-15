package com.api.hotel.service;

import java.util.List;

import com.api.hotel.model.Reserva;

public interface IReservaService {

	Reserva registrar(Reserva reserva);

	Reserva modificar(Reserva reserva);

	List<Reserva> listar();

	Reserva listarPorId(int id);

	void eliminar(int id);
	
	
}
