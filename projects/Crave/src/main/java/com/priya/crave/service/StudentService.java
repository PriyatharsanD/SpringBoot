package com.priya.crave.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.priya.crave.model.Student;
import com.priya.crave.repository.CouncellorRep;
import com.priya.crave.repository.StudentRep;

@Service
public class StudentService {
	@Autowired
	StudentRep rep;
	@Autowired
	CouncellorRep councellorRep;
	public ResponseEntity<Student> home(int id) {
		Student s=rep.findById(id).orElse(new Student());
		return new ResponseEntity<Student>(s,HttpStatus.OK);
	}

}
