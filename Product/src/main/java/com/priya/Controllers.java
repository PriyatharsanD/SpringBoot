package com.priya;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	ProductRep rep;
	
	@GetMapping("/product")
	public List<Product> getProducts()
	{
		return rep.findAll();
	}
	@PostMapping("/product")
	public Product addProduct(@RequestBody Product p)
	{
		rep.save(p);
		return p;
	}
	@DeleteMapping("/product/{id}")
	public String deleteProduct(@PathVariable("id") int id)
	{
		Product p = rep.findById(id).get();
		rep.delete(p);
		return "deleted";
	}
	@PutMapping("/product")
	public Product UpdateProduct(@RequestBody Product p)
	{
		rep.save(p);
		return p;
	}
	@PatchMapping("/product/{id}")
	public Product updateField(@PathVariable("id") int id, @RequestBody Product p)
	{
		Product p2=rep.findById(id).get();
		p2.setName(p.getName());
		rep.save(p2);
		return p2;
	}

}