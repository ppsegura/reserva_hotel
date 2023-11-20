package com.api.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.hotel.model.TipoHabitacion;
import com.api.hotel.service.ITipoHabitacionService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/tipoHabitacion")
public class TipoHabitacionController {

	@Autowired
	ITipoHabitacionService iTipoHabitacionService;
	
	@GetMapping
	public ResponseEntity<List<TipoHabitacion>> listar(){
		List<TipoHabitacion> lista = iTipoHabitacionService.listar();
		return new ResponseEntity<List<TipoHabitacion>>(lista, HttpStatus.OK);
	}
	
}
