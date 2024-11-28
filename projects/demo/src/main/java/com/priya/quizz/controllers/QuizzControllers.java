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

import com.priya.quizz.controllers.dao.QuestionDao;
import com.priya.quizz.controllers.dao.QuizzDao;
import com.priya.quizz.controllers.model.QuestionPaper;
import com.priya.quizz.controllers.model.Quizz;
import com.priya.quizz.controllers.model.Response;
import com.priya.quizz.controllers.services.QuizzService;

@RestController
@RequestMapping("/quizz")
public class QuizzControllers {
	@Autowired
	QuizzService quizzService;
	
	@PostMapping("/createQuizz")
	public ResponseEntity<Quizz> createQuizz(String name,String category,int limit)
	{
		return quizzService.createQuizz(name,category, limit); 
	}
	@GetMapping("/get/{id}")
	public ResponseEntity<List<QuestionPaper>> getQuizz(@PathVariable("id") int id)
	{
		return quizzService.getQuizz(id);
	}
	@PostMapping("submit/{id}")
	public ResponseEntity<Integer> submit(@PathVariable int id,@RequestBody List<Response> response)
	{
		return quizzService.getResult(id,response);
	}
}
