package com.priya.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.priya.model.Users;

@Service
public class UserService {
	@Autowired
	JwtService jwtService;
	@Autowired
	AuthenticationManager manager;

	public String verify(Users user) {
		Authentication authentication = manager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
		if(authentication!=null)
			return jwtService.generateTokens(user);
		else
			return null;
	}
}
