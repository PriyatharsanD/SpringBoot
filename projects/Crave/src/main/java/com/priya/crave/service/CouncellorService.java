package com.priya.crave.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.priya.crave.model.Councellor;
import com.priya.crave.model.Student;
import com.priya.crave.repository.CouncellorRep;
import com.priya.crave.repository.StudentRep;

@Service
public class CouncellorService {

	@Autowired
	CouncellorRep councellorRep;
	
	@Autowired
	StudentRep studentRep;
	
	public ResponseEntity<Student> addStudent(int id, Student s) {
		Councellor c = councellorRep.findById(id).get();
		s.setCouncellor(c);
		c.getStudent().add(s);
		councellorRep.save(c);
		studentRep.save(s);
		return new ResponseEntity<>(s,HttpStatus.CREATED);
	}

	public ResponseEntity<List<Student>> viewEnquiry(int id) {
		Councellor c = councellorRep.findById(id).get();
		return new ResponseEntity(c.getStudent(),HttpStatus.OK);
	}

	public ResponseEntity<Student> search(int id, int sid) {
		Councellor c = councellorRep.findById(id).get();
		List<Student> stu = c.getStudent().stream().filter(i->i.getId()==sid).collect(Collectors.toList());
		if(stu.size()!=0)
			return new ResponseEntity<>(stu.get(0),HttpStatus.OK);
		else
			return new ResponseEntity<>(new Student(),HttpStatus.OK);
	}

	public ResponseEntity<List<Student>> home(int id) {
		List<Student> stu= councellorRep.findById(id).get().getStudent();
		return new ResponseEntity<>(stu,HttpStatus.OK);
	}

	public boolean delete(int id, int sid) {
		List<Student> stu=councellorRep.findById(id).get().getStudent();
		for(Student s:stu)
		{
			if(s.getId()==sid)
			{
				stu.remove(s);
				studentRep.delete(s);
				return true;
			}
		}
		return false;
	}

}
