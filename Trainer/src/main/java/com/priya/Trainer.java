package com.priya;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Trainer {
	@Id
	int id;
	String name;
	String subject;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
}