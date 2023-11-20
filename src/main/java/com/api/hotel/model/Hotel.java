package com.api.hotel.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "hoteles")
public class Hotel {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

	@Column(name = "nombre")
    private String nombre;

	@Column(name = "ciudad")
    private String ciudad;
	
	@Column(name = "direccion")
    private String direccion;

	@Column(name = "telefono")
    private String telefono;

	@Column(name = "imagen")
    private String imagen;
	
	@Column(name = "imagen_id")
    private String imagen_id;
	
	public Hotel() {}

    public String getImagen_id() {
		return imagen_id;
	}

	public void setImagen_id(String imagen_id) {
		this.imagen_id = imagen_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	public Hotel(String nombre) {
	    this.nombre = nombre;
	}

}
