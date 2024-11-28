package com.priya.quizz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.priya.quizz.dao.QuizzDao;
import com.priya.quizzfeign.QuizzFeign;
import com.priya.quizzmodels.Quizz;

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

//	public ResponseEntity<List<QuestionPaper>> getQuizz(int id) {
//		List<QuestionPaper>  questionPaperForUser = new ArrayList<>();
//		Quizz quizz = quizzDao.findById(id).orElse(new Quizz());
//		
//		List<Question> questions = quizz.getQuestion();
//		for(Question q : questions)
//		{
//			questionPaperForUser.add(new QuestionPaper(q.getId(),q.getQuestion(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4(),q.getAnswer()));
//		}
//		return new ResponseEntity<>(questionPaperForUser,HttpStatus.CREATED);
//	}
//
//	public ResponseEntity<Integer> getResult(int id, List<Response> response) {
//		Quizz quizz = quizzDao.findById(id).orElse(new Quizz());
//		List<Question> questions = quizz.getQuestion();
//		int right=0;
//		int i=0;
//		for(Response res : response)
//		{
//			if(questions.get(i).getAnswer().equals(res.getAnswer()))
//				right++;
//			i++;
//		}
//		return new ResponseEntity<>(right,HttpStatus.OK);
//	}
}
