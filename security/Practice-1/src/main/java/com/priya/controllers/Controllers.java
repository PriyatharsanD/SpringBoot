package com.priya.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.priya.Model.Users;
import com.priya.service.UserService;

@RestController
public class Controllers {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/register")
	public Users register(@RequestBody Users user)
	{
		return userService.register(user);
	}
	@GetMapping("/home")
	public String home()
	{
		return "Welcome home";
	}

	@PostMapping("/login")
	public String login(@RequestBody Users user)
	{
		System.out.println(user.getUsername());
		return userService.verify(user);
	}
}
