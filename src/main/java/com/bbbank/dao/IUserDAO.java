package com.bbbank.dao;

import java.util.List;

public interface IUserDAO {

	public double getCheckingBalance(String username);
	public double getSavingsBalance(String username);
	public double updateCheckingBalance(String username, double money);
	public double updateSavingsBalance(String username, double money);
	public List<String> getAccountInfo(String username);
	public List<String> updateAccountInfo(String username, String first_name, String last_name, String email, String password);
//	public String updateUsername(String email);
	public int insert(String first_name, String last_name, String email, String username, String password, int role, double checking_balance, double savings_balance);
	public boolean delete(String username);
	
}
