package com.api.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.hotel.model.Habitacion;

public interface IHabitacionRepository extends JpaRepository<Habitacion, Integer> {

}
