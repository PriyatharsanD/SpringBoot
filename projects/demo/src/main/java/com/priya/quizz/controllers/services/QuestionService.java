package com.priya.quizz.controllers.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.priya.quizz.controllers.dao.QuestionDao;
import com.priya.quizz.controllers.model.Question;

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
	public ResponseEntity<List<Question>> getByCateory(String category)
	{
		try
		{
			return new ResponseEntity<>(dao.findByCategory(category),HttpStatus.OK);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList(),HttpStatus.NOT_FOUND);
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
}
