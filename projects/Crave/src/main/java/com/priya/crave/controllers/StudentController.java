package com.priya.crave.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.priya.crave.model.Student;
import com.priya.crave.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	StudentService studentService;
	
	@GetMapping("/home/{id}")
	public ResponseEntity<Student> home(@PathVariable int id)
	{
		return studentService.home(id);
	}
	
	@PostMapping("/pay/{id}")
	public String pay(@RequestParam double price, @PathVariable int id)
	{
		
	}

}
