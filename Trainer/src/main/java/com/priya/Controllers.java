package com.priya;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controllers {
	@Autowired
	TrainerRep rep;
	@PostMapping(path="/trainer")
	public Trainer postTrainer(@RequestBody Trainer t)
	{
		rep.save(t);
		return t;
	}
	@GetMapping("/trainer")
	public List<Trainer> getTrainers()
	{
		return rep.findAll();
	}
	@GetMapping("/trainer/{id}")
	public Optional<Trainer> getTrainer(@PathVariable("id") int id)
	{
		return rep.findById(id);
	}
	@DeleteMapping("/trainer/{id}")
	public String deleteTrainer(@PathVariable("id") int id)
	{
		Trainer t = rep.findById(id).get();
		rep.delete(t);
		return "deleted";
	}
	@PutMapping(path="/trainer")
	public Trainer updateTrainer(@RequestBody Trainer t)
	{
		rep.save(t);
		return t;
	}
}