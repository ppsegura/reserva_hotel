package com.api.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.hotel.model.Hotel;

public interface IHotelRepository extends JpaRepository<Hotel, Integer> {

}
