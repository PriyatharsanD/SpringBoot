package com.priya;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class CustomeUser {

	@GetMapping("/")
	public String home(HttpServletRequest request)
	{
		return "Welcome " +request.getSession().getId();
	}
}
