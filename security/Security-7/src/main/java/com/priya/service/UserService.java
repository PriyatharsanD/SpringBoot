package com.priya.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.priya.model.Users;
import com.priya.repo.UserRepo;

@Service
public class UserService {
	
	@Autowired
	UserRepo repo;
	
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

	public void addUser(Users user) {
		user.setPassword(encoder.encode(user.getPassword()));
		repo.save(user);
	}

}
