package com.api.hotel.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.api.hotel.model.Habitacion;
import com.api.hotel.service.IHabitacionService;


@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/habitacion")
public class HabitacionController {

	@Autowired
	IHabitacionService iHabitacionService;
		
	@GetMapping
	public ResponseEntity<List<Habitacion>> listar() {
		List<Habitacion> lista = iHabitacionService.listar();
		return new ResponseEntity<List<Habitacion>>(lista, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Habitacion> listarPorId(@PathVariable("id") int id) {
		Habitacion hab = iHabitacionService.listarPorId(id);
		if(hab.getId() > 0 ) {
			return new ResponseEntity<Habitacion>(hab,HttpStatus.OK);
			} else
		return new ResponseEntity<Habitacion>(hab,HttpStatus.NO_CONTENT);
	}

	
	@PostMapping
	public ResponseEntity<Habitacion> registrar(@RequestBody Habitacion h) {

		Habitacion hab = iHabitacionService.registrar(h);
		return new ResponseEntity<Habitacion>(hab,HttpStatus.CREATED);
	}
			

	@PutMapping("/{id}")
	public ResponseEntity<Habitacion> modificar(@RequestBody Habitacion h, @PathVariable("id") int id) {
		Habitacion habitacionExistente = iHabitacionService.listarPorId(id);
		
		if (habitacionExistente == null) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
		
		habitacionExistente.setNombre(h.getNombre());
		habitacionExistente.setNumero(h.getNumero());
		habitacionExistente.setTipo(h.getTipo());
		habitacionExistente.setCapacidad(h.getCapacidad());
		habitacionExistente.setPrecio(h.getPrecio());
		habitacionExistente.setImagen(h.getImagen());
		habitacionExistente.setHotel(h.getHotel());
		
		Habitacion habitacionActualizada = iHabitacionService.modificar(habitacionExistente);
		return new ResponseEntity<Habitacion>(habitacionActualizada,HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") int id) {

		Habitacion hab = iHabitacionService.listarPorId(id);
		if (hab != null)
			iHabitacionService.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
}
