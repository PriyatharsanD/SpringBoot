package com.priya.crave.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.priya.crave.model.Admin;

public interface AdminRep extends JpaRepository<Admin,Integer>{
	
}
