package com.bbbank.dao;

import java.util.List;

import com.bbbank.models.Admin;

public interface IAdminDAO {

	public List<Admin> getByUsername(String username);
	public boolean getByPassword(String password);
//	public boolean transferFunds(String username, String username1, String acct, String acct1, double amount);
	public int insert(String first_name, String last_name, String email, String username, String password, int role);
	public boolean delete(String username);
	
}
