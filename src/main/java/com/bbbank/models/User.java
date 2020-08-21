package com.bbbank.models;

import java.util.Objects;

public class User {

	private int id;
	private String first_name;
	private String last_name;
	private String email;
	private String username;
	private String password;
	private int role;
	private double checking_balance;
	private double savings_balance;
	
	public User() {
		super();
	}
	
	public User(int id, String first_name, String last_name, String email, String username, String password, int role, double checking_balance, double savings_balance) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.username = username;
		this.password = password;
		this.role = role;
		this.checking_balance = checking_balance;
		this.savings_balance = savings_balance;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public double getChecking_balance() {
		return checking_balance;
	}

	public void setChecking_balance(double checking_balance) {
		this.checking_balance = checking_balance;
	}

	public double getSavings_balance() {
		return savings_balance;
	}

	public void setSavings_balance(double savings_balance) {
		this.savings_balance = savings_balance;
	}	
	
	@Override
	public String toString() {
		return "User { id: " + id + ", first_name: " + first_name + ", last_name: " + last_name + ", email: " + email + ", username: " + username + ", password: " + password + ", role: " + role + ", checking_balance: " + checking_balance + ", savings_balance: " + savings_balance + " }";
	}

}
