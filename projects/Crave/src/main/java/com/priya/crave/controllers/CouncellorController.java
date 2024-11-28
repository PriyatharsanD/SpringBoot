package com.priya.crave.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.priya.crave.model.Student;
import com.priya.crave.service.CouncellorService;

@RequestMapping("/councellor")
@RestController
public class CouncellorController {
	@Autowired
	CouncellorService councellorService;
	@GetMapping("/{id}/home")
	public ResponseEntity<List<Student>> home(@PathVariable int id)
	{
		return councellorService.home(id);
	}
	
	@PostMapping("/Register/{id}")
	public ResponseEntity<Student> register(@PathVariable int id, @RequestBody Student s)
	{
		return councellorService.addStudent(id,s);
	}
	@GetMapping("/viewEnquiries/{id}")
	public ResponseEntity<List<Student>> viewEnquiry(@PathVariable int id)
	{
		return councellorService.viewEnquiry(id);
	}
	@GetMapping("/search/{id}")
	public ResponseEntity<Student> search(@PathVariable int id, @RequestParam("sid")int sid)
	{
		return councellorService.search(id,sid);
	}
	@DeleteMapping("/delete/{id}")
	public boolean delete(@PathVariable int id, @RequestParam("sid") int sid)
	{
		return councellorService.delete(id,sid);
	}
}
