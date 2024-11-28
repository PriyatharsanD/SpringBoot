package com.priya.quizz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.priya.quizzmodels.Quizz;

@Repository
public interface QuizzDao extends JpaRepository<Quizz, Integer> {
	
}
