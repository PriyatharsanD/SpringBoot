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
import org.springframework.web.bind.annotation.RestController;

import com.priya.crave.model.Admin;
import com.priya.crave.model.Councellor;
import com.priya.crave.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@PostMapping("/addAdmin")
	public ResponseEntity<Admin> addAdmin(@RequestBody Admin a)
	{
		return adminService.addAdmin(a);
	}
	
	@PostMapping("/addCouncellor/{id}")
	public ResponseEntity<Councellor> addCouncellor(@PathVariable("id") int id, @RequestBody Councellor c)
	{
		return adminService.add(id,c);
	}
	@DeleteMapping("/removeCouncellor/{id}")
	public ResponseEntity<Councellor> removeCouncellor(@PathVariable("id") int id)
	{
		return adminService.remove(id);
	}
	@GetMapping("/getCouncellor/{id}")
	public ResponseEntity<List<Councellor>> getCouncellors(@PathVariable("id") int id)
	{
		return adminService.getCouncellors(id);
	}

}
