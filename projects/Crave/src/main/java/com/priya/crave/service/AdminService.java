package com.priya.crave.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.priya.crave.model.Admin;
import com.priya.crave.model.Councellor;
import com.priya.crave.repository.AdminRep;
import com.priya.crave.repository.CouncellorRep;

@Service
public class AdminService {
	
	@Autowired
	AdminRep adminRep;
	
	@Autowired
	CouncellorRep councellorRep;

	public ResponseEntity<Councellor> add(int id,Councellor c) {
		Admin a = adminRep.findById(id).get();
		c.setAdmin(a);
		a.getCouncellor().add(c);
		adminRep.save(a);
		councellorRep.save(c);
		return new ResponseEntity<>(c,HttpStatus.ACCEPTED);
	}

	public ResponseEntity<Councellor> remove(int id) {
		Councellor c = councellorRep.findById(id).get();
		Admin a =adminRep.findById(c.getAdmin()).get();
		List<Councellor> councellor = a.getCouncellor().stream().filter(i->i.getEmployeeId()==id).collect(Collectors.toList());
		a.getCouncellor().removeAll(councellor);
		adminRep.save(a);
		councellorRep.delete(c);
		return new ResponseEntity<>(c,HttpStatus.OK);
	}

	public ResponseEntity<Admin> addAdmin(Admin a) {
		adminRep.save(a);
		return new ResponseEntity<>(a,HttpStatus.CREATED);
	}

	public ResponseEntity<List<Councellor>> getCouncellors(int id) {
		Admin a=adminRep.findById(id).get();
		return new ResponseEntity<>(a.getCouncellor(),HttpStatus.OK);
	}

}
