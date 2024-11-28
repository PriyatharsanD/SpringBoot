package com.priya.quizzmodels;

import lombok.Data;

@Data
public class DataTransferObject {
	String name;
	String category;
	int limit;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}

}
