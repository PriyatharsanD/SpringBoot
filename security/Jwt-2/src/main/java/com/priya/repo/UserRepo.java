package com.priya.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.priya.model.Users;

@Component
public interface UserRepo extends JpaRepository<Users, Integer>{
	
	Users findByUsername(String username);

}
