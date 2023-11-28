package com.api.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.hotel.model.Role;

public interface IRolRepository extends JpaRepository<Role, Integer>{

}
