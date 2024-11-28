package com.priya.quizz.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.priya.quizz.controllers.model.Question;
import com.priya.quizz.controllers.services.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionControllers {
	@Autowired()
	QuestionService questionService;
	
	@GetMapping("/allQuestions")
	public ResponseEntity<List<Question>> getAllQuestion()
	{
		return  questionService.getAllQuestions();
	}
	@PostMapping("/addQuestion")
	public ResponseEntity<Question> addQuestion(@RequestBody Question q)
	{
		return questionService.addQuestion(q);
	}
	@GetMapping("/category/{category}")
	public ResponseEntity<List<Question>> getByCategory(@PathVariable String category)
	{
		return questionService.getByCateory(category);
	}
}
