package com.bbbank.dao;

import java.util.List;

import com.bbbank.models.Application;

public interface IApplicationDAO {
	
	public List<Application> findAll();
	public Application findByUsername(String username);
	public int insert(String first_name, String last_name, String email, String password, int role, int credit_score, int annual_income);
	public int delete(String email);

}
