package com.priya.quizzService.model;

public class Response {
	int id;
	String answer;
	public Response(int id, String answer) {
		super();
		this.id = id;
		this.answer = answer;
	}
	public Response() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
}
