package com.priya;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Fruit {
	@Id
	String name;
	double price;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String toString()
	{
		return "{"+name+", "+price+"}" ;
	}
	

}
