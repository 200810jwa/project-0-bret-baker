package com.bbbank.dao;

import java.util.List;

import com.bbbank.models.User;

public interface IUserDAO {

	public double getCheckingBalance(String username);
	public double getSavingsBalance(String username);
	public double updateCheckingBalance(String username, double money);
	public double updateSavingsBalance(String username, double money);
	public List<String> getAccountInfo(String username);
	public List<User> updateAccountInfo(String first_name, String last_name, String email, String password);
	public int insert(String first_name, String last_name, String email, String password, int role, double checking_balance, double savings_balance);
	public boolean delete(String email);
	
}
