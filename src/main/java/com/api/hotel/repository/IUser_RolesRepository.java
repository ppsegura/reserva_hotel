package com.api.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.hotel.model.User_Roles;

public interface IUser_RolesRepository extends JpaRepository<User_Roles, Integer> {

}
