package com.priya.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.priya.model.Student;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class Controller {
	List<Student> li = Arrays.asList(new Student("Priya",37,7397318502L),new Student("Monisha",22,8925607552L));
	@GetMapping("/getStudent")
	public List<Student> getStudent()
	{
		return li;
	}
	@PostMapping("/addStudent")
	public Student addStudent()
	{
		
		return li.get(0);
	}
	@GetMapping("/getcsrf-token")
	public CsrfToken getCsrf(HttpServletRequest request)
	{
		return (CsrfToken) request.getAttribute("_csrf");
	}

}
