package com.priya.crave.model;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Councellor {
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Id
	int employeeId;
	String name;
	long contactNumber;
	@OneToMany(mappedBy = "councellor")
	List<Student> student=new ArrayList<>();
	
	@ManyToOne
	Admin admin;
	
	public Integer getAdmin() {
		return admin.id;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}
	public List<Student> getStudent() {
		return student;
	}
	public void setStudent(List<Student> student) {
		this.student = student;
	}
	@Override
	public String toString()
	{
		return employeeId+" ";
	}
}