package com.priya.quizzService.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.priya.quizzService.model.QuestionPaper;
import com.priya.quizzService.model.Response;

@FeignClient("QUESTIONSERVICE")
public interface QuizzFeign {
	@PostMapping("/question/generate")
	public ResponseEntity<List<Integer>> generate(@RequestParam String category, @RequestParam int limit);
	@PostMapping("/question/getQuestions")
	public ResponseEntity<List<QuestionPaper>> getQuestions(@RequestBody List<Integer> questionIds);
	@PostMapping("/question/getScore")
	public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses);
}
