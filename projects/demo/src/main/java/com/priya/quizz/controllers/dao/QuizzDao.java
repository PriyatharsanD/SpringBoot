package com.priya.quizz.controllers.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.priya.quizz.controllers.model.Quizz;

@Repository
public interface QuizzDao extends JpaRepository<Quizz, Integer> {
	
}
