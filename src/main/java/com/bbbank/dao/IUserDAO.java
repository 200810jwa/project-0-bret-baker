package com.bbbank.dao;

import java.util.List;

import com.bbbank.models.User;

public interface IUserDAO {

	public List<User> getAllUsers();
	public List<User> getByUsername(String username);
	public List<User> getById(int userInt);
	public boolean getByPassword(String password);
	public double getCheckingBalance(String username);
	public double getSavingsBalance(String username);
	public double updateCheckingBalance(String username, double money);
	public double updateSavingsBalance(String username, double money);
//	public List<String> getAccountInfo(String username);
	public int updateAccountInfo(int id, String username, String first_name, String last_name, String email, String password);
	public int insert(String first_name, String last_name, String email, String username, String password, int role, double checking_balance, double savings_balance);
	public boolean delete(String username);
	
}
