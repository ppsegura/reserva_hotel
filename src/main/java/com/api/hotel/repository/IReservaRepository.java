package com.api.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.hotel.model.Reserva;

public interface IReservaRepository extends JpaRepository<Reserva, Integer> {

}
