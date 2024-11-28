package com.priya.quizzService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.priya.quizzService.model.DataTransferObject;
import com.priya.quizzService.model.QuestionPaper;
import com.priya.quizzService.model.Quizz;
import com.priya.quizzService.model.Response;
import com.priya.quizzService.service.QuizzService;

@RestController
@RequestMapping("/quizz")
public class QuizzControllers {
	@Autowired
	QuizzService quizzService;
	
	@PostMapping("/createQuizz")
	public ResponseEntity<Quizz> createQuizz(@RequestBody DataTransferObject dto)
	{
		return quizzService.createQuizz(dto.getName(),dto.getCategory(),dto.getLimit()); 
	}
	@GetMapping("/get/{id}")
	public ResponseEntity<List<QuestionPaper>> getQuizz(@PathVariable("id") int id)
	{
		return quizzService.getQuizz(id);
	}
	@PostMapping("/submit/{id}")
	public ResponseEntity<Integer> submit(@PathVariable("id")int id,@RequestBody List<Response> response)
	{
		return quizzService.getResult(id,response);
	}
}
