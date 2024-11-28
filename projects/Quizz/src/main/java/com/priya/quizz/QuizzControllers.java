package com.priya.quizz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.priya.quizz.service.QuizzService;
import com.priya.quizzmodels.DataTransferObject;
import com.priya.quizzmodels.Quizz;

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
//	@GetMapping("/get/{id}")
//	public ResponseEntity<List<QuestionPaper>> getQuizz(@PathVariable("id") int id)
//	{
//		return quizzService.getQuizz(id);
//	}
//	@PostMapping("submit/{id}")
//	public ResponseEntity<Integer> submit(@PathVariable int id,@RequestBody List<Response> response)
//	{
//		return quizzService.getResult(id,response);
//	}
}
