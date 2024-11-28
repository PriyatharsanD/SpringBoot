package com.priya.quizzService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.priya.quizzService.dao.QuizzDao;
import com.priya.quizzService.feign.QuizzFeign;
import com.priya.quizzService.model.QuestionPaper;
import com.priya.quizzService.model.Quizz;
import com.priya.quizzService.model.Response;

@Service
public class QuizzService {
	
	@Autowired
	QuizzDao quizzDao;
	
	@Autowired
	QuizzFeign qFeign;
	public ResponseEntity<Quizz> createQuizz(String name,String category, int limit)
	{
		List<Integer> l = qFeign.generate(category, limit).getBody();
		Quizz q = new Quizz();
		q.setName(name);
		q.setCategory(category);
		q.setQuestionIds(l);
		quizzDao.save(q);
		return new ResponseEntity<>(q,HttpStatus.CREATED);
	}

	public ResponseEntity<List<QuestionPaper>> getQuizz(int id) 
	{
		Quizz quizz = quizzDao.findById(id).get();
		List<Integer> quizzIds=quizz.getQuestionIds();
		List<QuestionPaper> questions=qFeign.getQuestions(quizzIds).getBody();
		return new ResponseEntity<>(questions,HttpStatus.CREATED);
	}

	public ResponseEntity<Integer> getResult(int id,List<Response> response) 
	{
		return qFeign.getScore(response);
	}
}
