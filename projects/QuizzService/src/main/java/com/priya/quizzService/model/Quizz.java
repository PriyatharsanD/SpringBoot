package com.priya.quizzService.model;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Quizz {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	private String name;
	String category;
	@ElementCollection
	List<Integer> questionIds = new ArrayList<>();
	public List<Integer> getQuestionIds() {
		return questionIds;
	}
	public void setQuestionIds(List<Integer> questionIds) {
		this.questionIds = questionIds;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setName(String name) {
		this.name=name;
		
	}
	public String getName()
	{
		return name;
	}
	
}
