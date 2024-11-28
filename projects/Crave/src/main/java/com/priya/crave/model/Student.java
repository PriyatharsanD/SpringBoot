package com.priya.crave.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Student {
	@GeneratedValue
	@Id
	int id;
	String name;
	long contactNumber;
	double paidFee;
	double pendingFee;
	@ManyToOne
	Councellor councellor;
	public int getCouncellor() {
		return councellor.getEmployeeId();
	}
	public void setCouncellor(Councellor councellor) {
		this.councellor = councellor;
	}
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
	public long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}
	public double getPaidFee() {
		return paidFee;
	}
	public void setPaidFee(double paidFee) {
		this.paidFee = paidFee;
	}
	public double getPendingFee() {
		return pendingFee;
	}
	public void setPendingFee(double pendingFee) {
		this.pendingFee = pendingFee;
	}
	@Override
	public String toString()
	{
		return id+"";
	}
}