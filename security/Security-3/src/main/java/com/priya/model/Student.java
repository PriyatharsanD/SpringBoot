package com.priya.model;

public class Student {
	String name;
	int id;
	long cnum;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getCnum() {
		return cnum;
	}
	public void setCnum(long cnum) {
		this.cnum = cnum;
	}
	public Student(String name, int id, long cnum) {
		super();
		this.name = name;
		this.id = id;
		this.cnum = cnum;
	}
}