package com.priya.questionService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.priya.questionService.model.Question;
import com.priya.questionService.model.QuestionPaper;
import com.priya.questionService.model.Response;
import com.priya.questionService.services.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionControllers {
	@Autowired()
	QuestionService questionService;
	@Autowired
	Environment environment;
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
		return questionService.getByCategory(category);
	}
	@PostMapping("/generate")
	public ResponseEntity<List<Integer>> generate(@RequestParam String category, @RequestParam int limit)
	{
		return questionService.generate(category,limit);
	}
	@PostMapping("/getQuestions")
	public ResponseEntity<List<QuestionPaper>> getQuestions(@RequestBody List<Integer> questionIds)
	{
		return questionService.getById(questionIds);
	}
	@PostMapping("/getScore")
	public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses)
	{
		System.out.println(environment.getProperty("server.port"));
		return questionService.getScore(responses);
	}
}
