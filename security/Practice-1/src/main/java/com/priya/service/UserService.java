package com.priya.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.priya.Model.Users;
import com.priya.Repositories.UserRepo;

@Service
public class UserService {
	
	@Autowired
	JwtService jwtService;

	@Autowired
	AuthenticationManager manager;
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
	@Autowired
	UserRepo rep;
	public Users register(Users user) {
		user.setPassword(encoder.encode(user.getPassword()));
		return rep.save(user);
	}
	public String verify(Users user) 
	{
		Authentication authentication = manager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
		if(authentication!=null)
			return jwtService.generateTokens(user.getUsername());
		return "fail";
	}

}
