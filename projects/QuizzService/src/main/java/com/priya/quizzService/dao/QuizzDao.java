package com.priya.quizzService.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.priya.quizzService.model.Quizz;

@Repository
public interface QuizzDao extends JpaRepository<Quizz, Integer> {
	
}
