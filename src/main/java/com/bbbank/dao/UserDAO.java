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

			String sql = "UPDATE project0.users SET checking_balance = (checking_balance + (" + money
					+ ")) WHERE username = " + username;

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

			String sql = "UPDATE project0.users SET savings_balance = (savings_balance + (" + money
					+ ")) WHERE username = " + username;

			ResultSet rs = stmt.executeQuery(sql);

			double sb = 0;

			while (rs.next()) {
				sb = rs.getDouble("savings_balance");
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

			String sql = "SELECT first_name, last_name, email, username, password FROM project0.users WHERE username = "
					+ username;

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
			System.out.println("WE FAILED TO GET USER ACCOUNT INFO");
			return ai;
		} finally {
			closeResources();
		}

	}

	@Override
	public List<String> updateAccountInfo(String username, String first_name, String last_name, String email, String password) {

		List<String> uai = new ArrayList<String>();

		try (Connection conn = ConnectionUtil.getConnection()) {

			Statement stmt = conn.createStatement();

			String sql = "UPDATE project0.users SET first_name = " + first_name  + ", last_name = " + last_name + ", email = " + email + ", password = " + password + " WHERE username = " + username;

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				uai.add(first_name);
				uai.add(last_name);
				uai.add(email);
				uai.add(password);
			}
			
			sql = "UPDATE project0.users SET username = " + email + " WHERE email = " + email;
			
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				uai.add(email);
			}

			return uai;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("WE FAILED TO UPDATE USER ACCOUNT INFO");
			return uai;
		} finally {
			closeResources();
		}

	}
	
//	@Override
//	public String updateUsername(String email) {
//		// TODO Auto-generated method stub
//		return 0;
//	}

	@Override
	public int insert(String first_name, String last_name, String email, String username, String password, int role,
			double checking_balance, double savings_balance) {
		
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "INSERT INTO project0.users (first_name, last_name, email, username, password, role, checking_balance, savings_balance) VALUES (?, ?, ?, ?, ?, ?, ?) RETURNING project0.users.id";

			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, first_name);
			stmt.setString(2, last_name);
			stmt.setString(3, email);
			stmt.setString(4, username);
			stmt.setString(5, password);
			stmt.setInt(6, role);
			stmt.setInt(7, 0);
			stmt.setInt(8, 0);

			ResultSet rs;
			if ((rs = stmt.executeQuery()) != null) {
				rs.next();

				int id = rs.getInt(1);

				return id;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("WE FAILED TO INSERT NEW USER");
		} finally {
			closeResources();
		}

		return 0;
		
	}

	@Override
	public boolean delete(String username) {
		
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "DELETE FROM project0.users WHERE username = ?";

			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, username);
			
			if (stmt.executeUpdate() != 0)
				return true;
			else
				return false;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("WE FAILED TO DELETE USER");
			return false;
		} finally {
			closeResources();
		}
		
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
