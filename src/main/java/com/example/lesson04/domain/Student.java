package com.example.lesson04.domain;

import java.util.Date;

public class Student {

	private int id;
	private String name;
	private String phoneNumber;
	private String email;
	private String dreamJod;
	private Date createdAt;
	private Date upDatedAt;
	
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
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDreamJod() {
		return dreamJod;
	}
	public void setDreamJod(String dreamJod) {
		this.dreamJod = dreamJod;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpDatedAt() {
		return upDatedAt;
	}
	public void setUpDatedAt(Date upDatedAt) {
		this.upDatedAt = upDatedAt;
	}
	
	
}
