package com.api.hotel.service;

import java.util.List;

import com.api.hotel.model.Habitacion;

public interface IHabitacionService {

	Habitacion registrar(Habitacion habitacion);

	Habitacion modificar(Habitacion habitacion);

	List<Habitacion> listar();

	Habitacion listarPorId(int id);

	void eliminar(int id);
	
}
