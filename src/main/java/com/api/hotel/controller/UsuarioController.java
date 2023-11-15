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

import com.api.hotel.model.Usuario;
import com.api.hotel.service.IUsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	IUsuarioService iUsuarioService;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> listar() {
		List<Usuario> lista = iUsuarioService.listar();
		return new ResponseEntity<List<Usuario>>(lista, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Usuario> listarPorId(@PathVariable("id") int id) {
		Usuario usu = iUsuarioService.listarPorId(id);
		if(usu.getUserId() > 0 ) {
			return new ResponseEntity<Usuario>(usu,HttpStatus.OK);
			} else
		return new ResponseEntity<Usuario>(usu,HttpStatus.NO_CONTENT);
	}

	@PostMapping
	public ResponseEntity<Usuario> registrar(@RequestBody Usuario u) {

		Usuario usu = iUsuarioService.registrar(u);
		return new ResponseEntity<Usuario>(usu,HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Usuario> modificar(@RequestBody Usuario u) {
		Usuario usu = iUsuarioService.modificar(u);
		return new ResponseEntity<Usuario>(usu,HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") int id) {

		Usuario usu = iUsuarioService.listarPorId(id);
		if (usu != null)
			iUsuarioService.eliminar(id);
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	
}
