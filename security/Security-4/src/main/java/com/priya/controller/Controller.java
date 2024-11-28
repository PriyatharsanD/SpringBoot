package com.priya.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class Controller {
	
	@GetMapping("/")
	public String home(HttpServletRequest request)
	{
		return "Welcome "+request.getSession().getId();
	}
}
