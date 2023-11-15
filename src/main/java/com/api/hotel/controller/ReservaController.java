package com.api.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.hotel.model.Reserva;
import com.api.hotel.service.IReservaService;

@RestController
@RequestMapping("/reserva")
public class ReservaController {

	@Autowired
	IReservaService iReservaService;
	
	@GetMapping
	public ResponseEntity<List<Reserva>> listar() {
		List<Reserva> lista = iReservaService.listar();
		return new ResponseEntity<List<Reserva>>(lista, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Reserva> listarPorId(@PathVariable("id") int id) {
		Reserva res = iReservaService.listarPorId(id);
		if(res.getId() > 0 ) {
			return new ResponseEntity<Reserva>(res,HttpStatus.OK);
			} else
		return new ResponseEntity<Reserva>(res,HttpStatus.NO_CONTENT);
	}

	@PostMapping
	public ResponseEntity<Reserva> registrar(@RequestBody Reserva r) {

		Reserva res = iReservaService.registrar(r);
		return new ResponseEntity<Reserva>(res,HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Reserva> modificar(@RequestBody Reserva r, @PathVariable("id") int id) {
		Reserva reservaExistente = iReservaService.listarPorId(id);
		
		if (reservaExistente == null) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
		
		reservaExistente.setFechaLlegada(r.getFechaLlegada());
		reservaExistente.setFechaSalida(r.getFechaSalida());
		reservaExistente.setNumeroHabitaciones(r.getNumeroHabitaciones());
		reservaExistente.setHabitacion(r.getHabitacion());
		reservaExistente.setUsuario(r.getUsuario());
		
		Reserva reservaActualizada = iReservaService.modificar(reservaExistente);
		return new ResponseEntity<Reserva>(reservaActualizada,HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") int id) {

		Reserva res = iReservaService.listarPorId(id);
		if (res != null)
			iReservaService.eliminar(id);
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
}
