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

import com.api.hotel.model.User_Roles;
import com.api.hotel.service.IUser_RolesService;

@RestController
@RequestMapping("/userRoles")
public class User_RolesController {

	@Autowired
	IUser_RolesService iUser_Roles;
	
	@GetMapping
	public ResponseEntity<List<User_Roles>> listar() {
		List<User_Roles> lista = iUser_Roles.listar();
		return new ResponseEntity<List<User_Roles>>(lista, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<User_Roles> listarPorId(@PathVariable("id") int id) {
		User_Roles usrol = iUser_Roles.listarPorId(id);
		if(usrol.getUserRoleId() > 0 ) {
			return new ResponseEntity<User_Roles>(usrol,HttpStatus.OK);
			} else
		return new ResponseEntity<User_Roles>(usrol,HttpStatus.NO_CONTENT);
	}

	@PostMapping
	public ResponseEntity<User_Roles> registrar(@RequestBody User_Roles userRoles) {

		User_Roles usrol = iUser_Roles.registrar(userRoles);
		return new ResponseEntity<User_Roles>(usrol,HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<User_Roles> modificar(@RequestBody User_Roles userRoles) {
		User_Roles usrol = iUser_Roles.modificar(userRoles);
		return new ResponseEntity<User_Roles>(usrol,HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") int id) {

		User_Roles usrol = iUser_Roles.listarPorId(id);
		if (usrol != null)
			iUser_Roles.eliminar(id);
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
}
