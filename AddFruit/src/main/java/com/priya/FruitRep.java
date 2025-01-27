package com.priya;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface FruitRep extends CrudRepository<Fruit, String> {
	List<Fruit> findByPrice(double price);
	List<Fruit> findByPriceGreaterThan(double price);
	List<Fruit> findByPriceLessThan(double price);
	

}
