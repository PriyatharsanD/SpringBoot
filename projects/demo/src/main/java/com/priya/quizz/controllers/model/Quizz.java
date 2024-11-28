package com.priya.quizz.controllers.model;

import java.util.ArrayList;
import java.util.List;

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
	@ManyToMany
	List<Question> question = new ArrayList<>();
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
	public List<Question> getQuestion() {
		return question;
	}
	public void setQuestion(List<Question> question) {
		this.question = question;
	}
	public void setName(String name) {
		this.name=name;
		
	}
	public String getName()
	{
		return name;
	}
	
}
