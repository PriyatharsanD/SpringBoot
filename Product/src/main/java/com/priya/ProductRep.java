package com.priya;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRep extends JpaRepository<Product, Integer>{

	public List<Product> getByName(String name); 
}
