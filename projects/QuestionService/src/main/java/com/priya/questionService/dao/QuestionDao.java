package com.priya.questionService.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.priya.questionService.model.Question;


@Repository
public interface QuestionDao extends JpaRepository<Question,Integer>{
	List<Question> findByCategory(String category);
	
	@Query("SELECT q.id FROM Question q WHERE q.category = :category ORDER BY RAND() LIMIT :limit")
	List<Integer> findRandomQuestionsByCategory(String category,int limit);
}
