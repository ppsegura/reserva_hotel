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

import com.api.hotel.model.Rol;
import com.api.hotel.service.IRolService;

@RestController
@RequestMapping("/rol")
public class RolController {

	@Autowired
	IRolService iRolService;
	
	@GetMapping
	public ResponseEntity<List<Rol>> listar() {
		List<Rol> lista = iRolService.listar();
		return new ResponseEntity<List<Rol>>(lista, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Rol> listarPorId(@PathVariable("id") int id) {
		Rol rol = iRolService.listarPorId(id);
		if(rol.getRoleId() > 0 ) {
			return new ResponseEntity<Rol>(rol,HttpStatus.OK);
			} else
		return new ResponseEntity<Rol>(rol,HttpStatus.NO_CONTENT);
	}

	@PostMapping
	public ResponseEntity<Rol> registrar(@RequestBody Rol r) {

		Rol rol = iRolService.registrar(r);
		return new ResponseEntity<Rol>(rol,HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Rol> modificar(@RequestBody Rol r) {
		Rol rol = iRolService.modificar(r);
		return new ResponseEntity<Rol>(rol,HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") int id) {

		Rol res = iRolService.listarPorId(id);
		if (res != null)
			iRolService.eliminar(id);
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
}
