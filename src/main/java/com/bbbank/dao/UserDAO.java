package com.bbbank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.bbbank.models.Application;
import com.bbbank.models.User;
import com.bbbank.utils.ConnectionUtil;

public class UserDAO implements IUserDAO {

	Connection conn = null;
	PreparedStatement stmt = null;
	
	@Override
	public double getCheckingBalance(String username) {
		
		try (Connection conn = ConnectionUtil.getConnection()) {

			Statement stmt = conn.createStatement();

			String sql = "SELECT checking_balance FROM project0.users WHERE username = " + username;

			ResultSet rs = stmt.executeQuery(sql);
			
			double cb = 0;

			while (rs.next()) {
				cb = rs.getDouble("checking_balance");
			}
			
			return cb;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("WE FAILED TO RETRIEVE USER CHECKING BALANCE");
			return 0;
		} finally {
			closeResources();
		}
		
	}
	
	@Override
	public double getSavingsBalance(String username) {

		try (Connection conn = ConnectionUtil.getConnection()) {

			Statement stmt = conn.createStatement();

			String sql = "SELECT savings_balance FROM project0.users WHERE username = " + username;

			ResultSet rs = stmt.executeQuery(sql);
			
			double sb = 0;

			while (rs.next()) {
				sb = rs.getDouble("savings_balance");
			}
			
			return sb;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("WE FAILED TO RETRIEVE USER SAVINGS BALANCE");
			return 0;
		} finally {
			closeResources();
		}
		
	}

	@Override
	public double updateCheckingBalance(String username, double money) {

		try (Connection conn = ConnectionUtil.getConnection()) {

			Statement stmt = conn.createStatement();

			String sql = "UPDATE project0.users SET checking_balance = (checking_balance + (" + money + ")) WHERE username = " + username;

			ResultSet rs = stmt.executeQuery(sql);
			
			double cb = 0;

			while (rs.next()) {
				cb = rs.getDouble("checking_balance");
			}
			
			return cb;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("WE FAILED TO UPDATE USER CHECKING BALANCE");
			return 0;
		} finally {
			closeResources();
		}
		
	}

	@Override
	public double updateSavingsBalance(String username, double money) {
		
		try (Connection conn = ConnectionUtil.getConnection()) {

			Statement stmt = conn.createStatement();

			String sql = "UPDATE project0.users SET savings_balance = (savings_balance + (" + money + ")) WHERE username = " + username;

			ResultSet rs = stmt.executeQuery(sql);
			
			double sb = 0;

			while (rs.next()) {
				sb = rs.getDouble("checking_balance");
			}
			
			return sb;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("WE FAILED TO UPDATE USER SAVINGS BALANCE");
			return 0;
		} finally {
			closeResources();
		}
		
	}

	@Override
	public List<String> getAccountInfo(String username) {

		List<String> ai = new ArrayList<String>();
		
		try (Connection conn = ConnectionUtil.getConnection()) {

			Statement stmt = conn.createStatement();

			String sql = "SELECT first_name, last_name, email, username, password FROM project0.users WHERE username = " + username;

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				String email = rs.getString("email");
				String password = rs.getString("password");
				ai.add(first_name);
				ai.add(last_name);
				ai.add(email);
				ai.add(username);
				ai.add(password);
			}
			
			return ai;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("WE FAILED TO UPDATE USER SAVINGS BALANCE");
			return ai;
		} finally {
			closeResources();
		}
		
	}

	@Override
	public List<User> updateAccountInfo(String first_name, String last_name, String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(String first_name, String last_name, String email, String password, int role,
			double checking_balance, double savings_balance) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean delete(String email) {
		// TODO Auto-generated method stub
		return false;
	}
	
	private void closeResources() {
		try {
			if (stmt != null)
				stmt.close();
		} catch (SQLException e) {
			System.out.println("Could not close statement!");
			e.printStackTrace();
		}

		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			System.out.println("Could not close connection!");
			e.printStackTrace();
		}
	}
	
}
