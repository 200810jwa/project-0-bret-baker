package com.bbbank.dao;

public interface IAdminDAO {

	public boolean transferFunds(String username, String username1, String acct, String acct1, double amount);
	public int insert(String first_name, String last_name, String email, String username, String password, int role);
	public boolean delete(String username);
	
}
