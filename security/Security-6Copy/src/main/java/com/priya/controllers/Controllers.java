package com.priya.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.priya.model.Users;
import com.priya.rep.UserRep;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class Controllers {
	@Autowired
	UserRep rep;
	@GetMapping("/")
	public String welcome(HttpServletRequest req)
	{
		return "welcome "+req.getSession().getId();
	}
	@PostMapping("/addUser")
	public Users add(@RequestBody Users user)
	{
		System.out.println(user.getId());
		rep.save(user);
		return user;
	}
}
