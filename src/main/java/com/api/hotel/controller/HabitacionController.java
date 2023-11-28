package com.api.hotel.controller;


import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.api.hotel.model.Habitacion;
import com.api.hotel.service.ICloudinaryService;
import com.api.hotel.service.IHabitacionService;



@RestController
@RequestMapping("/habitacion")
public class HabitacionController {

	@Autowired
	IHabitacionService iHabitacionService;
	
	@Autowired
	ICloudinaryService iCloudinaryService;
		
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
	public ResponseEntity<Habitacion> registrar(
			@RequestPart("imagen") MultipartFile imagen,
			@RequestPart("habitacion") Habitacion h) throws IOException {
		
		// Valida si el tipo de image es correcto
    	BufferedImage bi = ImageIO.read(imagen.getInputStream());
    	if(bi == null) {
    		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    	}
    	
    	// Carga la imagen en Cloudinary
    	Map<String, Object> result = iCloudinaryService.upload(imagen);
    	String imageUrl = result.get("url").toString();
    	String cloudinaryImageId = result.get("public_id").toString();
    	
    	h.setImagen(imageUrl);
    	h.setImagen_id(cloudinaryImageId);

		Habitacion hab = iHabitacionService.registrar(h);
		return new ResponseEntity<Habitacion>(hab,HttpStatus.CREATED);
	}
			

	@PutMapping("/{id}")
	public ResponseEntity<Habitacion> modificar(@RequestPart Habitacion h, MultipartFile imagen, @PathVariable("id") int id) throws IOException {
		Habitacion habitacionExistente = iHabitacionService.listarPorId(id);
		
		if (habitacionExistente == null) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
		
		String imageId = habitacionExistente.getImagen_id();
		iCloudinaryService.delete(imageId);
		
		// Valida si el tipo de image es correcto
    	BufferedImage bi = ImageIO.read(imagen.getInputStream());
    	if(bi == null) {
    		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    	}
    	
    	Map<String, Object> result = iCloudinaryService.upload(imagen);
		String imageUrl = result.get("url").toString();
		String cloudinaryImageId = result.get("public_id").toString();
		
		habitacionExistente.setNombre(h.getNombre());
		habitacionExistente.setNumero(h.getNumero());
		habitacionExistente.setTipoHabitacion(h.getTipoHabitacion());
		habitacionExistente.setCapacidad(h.getCapacidad());
		habitacionExistente.setPrecio(h.getPrecio());
		habitacionExistente.setHotel(h.getHotel());
		habitacionExistente.setImagen(imageUrl);
		habitacionExistente.setImagen_id(cloudinaryImageId);
		
		Habitacion habitacionActualizada = iHabitacionService.modificar(habitacionExistente);
		return new ResponseEntity<Habitacion>(habitacionActualizada,HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") int id) throws IOException {

		Habitacion hab = iHabitacionService.listarPorId(id);
		String imageId = hab.getImagen_id();
		if (hab != null)
			iCloudinaryService.delete(imageId);
			iHabitacionService.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
}
