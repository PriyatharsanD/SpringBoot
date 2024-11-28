package com.priya.crave.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@EnableJpaRepositories
@Entity
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String name;
	long contactNumber;
	@OneToMany(mappedBy = "admin")
	List<Councellor> councellor = new ArrayList();
	
	public List<Councellor> getCouncellor() {
		return councellor;
	}
	public void setCouncellor(List<Councellor> councellor) {
		this.councellor = councellor;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}
}
