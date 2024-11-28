package com.priya.quizz.controllers.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.priya.quizz.controllers.model.Question;


@Repository
public interface QuestionDao extends JpaRepository<Question,Integer>{
	List<Question> findByCategory(String category);
	
	@Query("SELECT q FROM Question q WHERE q.category = :category ORDER BY RAND() LIMIT :limit")
	List<Question> findRandomQuestionsByCategory(String category,int limit);
}
