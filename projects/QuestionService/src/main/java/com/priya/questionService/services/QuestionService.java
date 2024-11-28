package com.priya.questionService.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.priya.questionService.dao.QuestionDao;
import com.priya.questionService.model.Question;
import com.priya.questionService.model.QuestionPaper;
import com.priya.questionService.model.Response;

@Service
public class QuestionService {
	@Autowired
	QuestionDao dao;
	public ResponseEntity<List<Question>> getAllQuestions()
	{
		try
		{
			return new ResponseEntity<>(dao.findAll(),HttpStatus.OK);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList(),HttpStatus.BAD_REQUEST);
	}
	public ResponseEntity<Question> addQuestion(Question q) {
		try
		{
			return new ResponseEntity<>(dao.save(q),HttpStatus.OK);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return new ResponseEntity(new ArrayList(),HttpStatus.BAD_REQUEST);
	}
	public ResponseEntity<List<Integer>> generate(String category, int numQuesions) 
	{
		return new ResponseEntity<>(dao.findRandomQuestionsByCategory(category, numQuesions),HttpStatus.OK);
	}
	public ResponseEntity<List<Question>> getByCategory(String category) {
		return new ResponseEntity<>( dao.findByCategory(category),HttpStatus.OK);
	}
	public ResponseEntity<List<QuestionPaper>> getById(List<Integer> questionIds) {
		List<QuestionPaper> questionPaper = new ArrayList<>();
		for(Integer i : questionIds)
		{
			Question q = dao.findById(i).get();
			questionPaper.add(new QuestionPaper(q.getId(), q.getQuestion(), q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4(),q.getAnswer() ));
		}
		return new ResponseEntity<>(questionPaper,HttpStatus.CREATED);
	}
	public ResponseEntity<Integer> getScore(List<Response> responses) {
		int right=0;
		for(Response response : responses)
		{
			if(dao.findById(response.getId()).get().getAnswer().equals(response.getAnswer()))
				right++;
		}
		return new ResponseEntity<>(right,HttpStatus.OK);
	}
	
}
