package com.api.hotel.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.api.hotel.model.Hotel;
import com.api.hotel.service.ICloudinaryService;
import com.api.hotel.service.IHotelService;

//EL CrossOrigin sirve para enlazar con el ANGULAR
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/hotel")
public class HotelController {

	@Autowired
	IHotelService iHotelService;
	
	@Autowired
	ICloudinaryService iCloudinaryService;
	
	@GetMapping
	public ResponseEntity<List<Hotel>> listar() {
		List<Hotel> lista = iHotelService.listar();
		return new ResponseEntity<List<Hotel>>(lista, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Hotel> listarPorId(@PathVariable("id") int id) {
		Hotel hot = iHotelService.listarPorId(id);
		if(hot.getId() > 0 ) {
			return new ResponseEntity<Hotel>(hot,HttpStatus.OK);
			} else
		return new ResponseEntity<Hotel>(hot,HttpStatus.NO_CONTENT);
	}

	/*@PostMapping
	public ResponseEntity<Hotel> registrar(@RequestBody Hotel h) {

		Hotel hot = iHotelService.registrar(h);
		return new ResponseEntity<Hotel>(hot,HttpStatus.CREATED);
	}*/
	
	@PostMapping
	public ResponseEntity<Hotel> registrar(
	    @RequestPart("imagen") MultipartFile imagen,
	    @RequestPart("hoteles") Hotel hotel) throws IOException {

		// Valida si el tipo de image es correcto
    	BufferedImage bi = ImageIO.read(imagen.getInputStream());
    	if(bi == null) {
    		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    	}
    	
    	// Carga la imagen en Cloudinary
    	Map<String, Object> result = iCloudinaryService.upload(imagen);
    	String imageUrl = result.get("url").toString();
    	String cloudinaryImageId = result.get("public_id").toString();

    	// Asigna los valores de imagen e imagen_id al hotel
        hotel.setImagen(imageUrl);
        hotel.setImagen_id(cloudinaryImageId);
    	
	    // Procesa la habitación
	    Hotel hot= iHotelService.registrar(hotel);

	    return new ResponseEntity<>(hot, HttpStatus.CREATED);
	}

	/*@PutMapping("/{id}")
	public ResponseEntity<Hotel> modificar(@RequestBody Hotel h, @PathVariable("id") int id) {
		Hotel hotelExistente = iHotelService.listarPorId(id);
	    if (hotelExistente == null) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	    
	    hotelExistente.setNombre(h.getNombre());
	    hotelExistente.setCiudad(h.getCiudad());
	    hotelExistente.setDireccion(h.getDireccion());
	    hotelExistente.setTelefono(h.getTelefono());
	    hotelExistente.setImagen(h.getImagen());
	    
		Hotel hotelActualizado = iHotelService.modificar(hotelExistente);
		return new ResponseEntity<Hotel>(hotelActualizado,HttpStatus.OK);
	}*/
	@PutMapping("/{id}")
	public ResponseEntity<Hotel> modificar(@RequestPart Hotel hoteles, MultipartFile imagen, @PathVariable("id") int id) throws IOException{
		Hotel hotelExistente = iHotelService.listarPorId(id);
		if (hotelExistente == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		String imageId = hotelExistente.getImagen_id();
		iCloudinaryService.delete(imageId);
		
		// Valida si el tipo de image es correcto
    	BufferedImage bi = ImageIO.read(imagen.getInputStream());
    	if(bi == null) {
    		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    	}
		
		Map<String, Object> result = iCloudinaryService.upload(imagen);
		String imageUrl = result.get("url").toString();
		String cloudinaryImageId = result.get("public_id").toString();
		
		hotelExistente.setNombre(hoteles.getNombre());
		hotelExistente.setCiudad(hoteles.getCiudad());
		hotelExistente.setDireccion(hoteles.getDireccion());
		hotelExistente.setTelefono(hoteles.getTelefono());
		hotelExistente.setImagen(imageUrl);
		hotelExistente.setImagen_id(cloudinaryImageId);
		
		Hotel hotelActualizado = iHotelService.modificar(hotelExistente);
		return new ResponseEntity<Hotel>(hotelActualizado, HttpStatus.OK);
	}	

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") int id) throws IOException {
		
		Hotel hot = iHotelService.listarPorId(id);
		String imageId = hot.getImagen_id();
		if (hot != null)
			iCloudinaryService.delete(imageId);
			iHotelService.eliminar(id);
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	
}
