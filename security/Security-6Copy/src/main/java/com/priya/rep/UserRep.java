package com.priya.rep;

import org.springframework.data.jpa.repository.JpaRepository;

import com.priya.model.Users;

public interface UserRep extends JpaRepository<Users, Integer>{
	Users findByUsername(String username);
}
