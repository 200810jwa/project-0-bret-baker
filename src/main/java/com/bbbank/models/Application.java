package com.bbbank.models;

import java.util.Objects;

public class Application {

	private int id;
	private String first_name;
	private String last_name;
	private String email;
	private String password;
	private int role;
	private int credit_score;
	private int annual_income;
	
	public Application() {
		super();
	}
	
	public Application(int id, String first_name, String last_name, String email, String password, int role, int credit_score, int annual_income) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.password = password;
		this.role = role;
		this.credit_score = credit_score;
		this.annual_income = annual_income;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public int getCredit_score() {
		return credit_score;
	}

	public void setCredit_score(int credit_score) {
		this.credit_score = credit_score;
	}

	public int getAnnual_income() {
		return annual_income;
	}

	public void setAnnual_income(int annual_income) {
		this.annual_income = annual_income;
	}
	
	@Override
	public String toString() {
		return "Application { id: " + id + ", first_name: " + first_name + ", last_name: " + last_name + ", email: " + email + ", password: " + password + ", role: " + role + ", credit_score: " + credit_score + ", annual_income: " + annual_income + " }";
	}

}
