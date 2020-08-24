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
	public List<User> getAllUsers() {

		List<User> users = new ArrayList<>();

		try (Connection conn = ConnectionUtil.getConnection()) {

			Statement stmt = conn.createStatement();
			
			String sql = "SELECT * FROM project0.users";

			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				int id = rs.getInt("id");
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				String email1 = rs.getString("email");
				String username1 = rs.getString("username");
				String password = rs.getString("password");
				int role = rs.getInt("role");
				double checking_balance = rs.getInt("checking_balance");
				double savings_balance = rs.getInt("savings_balance");

				User u = new User(id, first_name, last_name, email1, username1, password, role, checking_balance, savings_balance);
				users.add(u);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("WE FAILED TO RETRIEVE USERs");
			return users;
		} finally {
			closeResources();
		}
		
		for(int i = 0; i < users.size(); i++) {
			System.out.println("");
			System.out.println(users.get(i));
		}
		return users;
	}
	
	@Override
	public List<User> getByUsername(String username) {

		List<User> user = new ArrayList<>();

		try (Connection conn = ConnectionUtil.getConnection()) {

			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM project0.users WHERE username = ?");

			stmt.setString(1, username);

			ResultSet rs;
			if ((rs = stmt.executeQuery()) != null) {
				while (rs.next()) {
					int id = rs.getInt("id");
					String first_name = rs.getString("first_name");
					String last_name = rs.getString("last_name");
					String email1 = rs.getString("email");
					String username1 = rs.getString("username");
					String password = rs.getString("password");
					int role = rs.getInt("role");
					double checking_balance = rs.getInt("checking_balance");
					double savings_balance = rs.getInt("savings_balance");

					User u = new User(id, first_name, last_name, email1, username1, password, role, checking_balance, savings_balance);
					user.add(u);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("WE FAILED TO RETRIEVE USER");
			return user;
		} finally {
			closeResources();
		}
		
//		System.out.println(user.get(0));
		return user;
	}
	
	@Override
	public List<User> getById(int userInt) {

		List<User> user = new ArrayList<>();

		try (Connection conn = ConnectionUtil.getConnection()) {

			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM project0.users WHERE id = ?");

			stmt.setInt(1, userInt);

			ResultSet rs;
			if ((rs = stmt.executeQuery()) != null) {
				while (rs.next()) {
					int id = rs.getInt("id");
					String first_name = rs.getString("first_name");
					String last_name = rs.getString("last_name");
					String email1 = rs.getString("email");
					String username1 = rs.getString("username");
					String password = rs.getString("password");
					int role = rs.getInt("role");
					double checking_balance = rs.getInt("checking_balance");
					double savings_balance = rs.getInt("savings_balance");

					User u = new User(id, first_name, last_name, email1, username1, password, role, checking_balance, savings_balance);
					user.add(u);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("WE FAILED TO RETRIEVE USER");
			return user;
		} finally {
			closeResources();
		}
		
//		System.out.println(user.get(0));
		return user;
	}
	
	@Override
	public boolean getByPassword(String password) {

		List<User> user = new ArrayList<>();

		try (Connection conn = ConnectionUtil.getConnection()) {

			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM project0.users WHERE password = ?");

			stmt.setString(1, password);

			ResultSet rs;
			if ((rs = stmt.executeQuery()) != null) {
				while (rs.next()) {
					int id = rs.getInt("id");
					String first_name = rs.getString("first_name");
					String last_name = rs.getString("last_name");
					String email1 = rs.getString("email");
					String username1 = rs.getString("username");
					String password1 = rs.getString("password");
					int role = rs.getInt("role");
					double checking_balance = rs.getInt("checking_balance");
					double savings_balance = rs.getInt("savings_balance");

					User u = new User(id, first_name, last_name, email1, username1, password1, role, checking_balance, savings_balance);
					user.add(u);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("WE FAILED TO RETRIEVE USER");
			return false;
		} finally {
			closeResources();
		}
		
//		System.out.println(user.get(0));
		return true;
	}

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
			
			String sql = "UPDATE project0.users SET checking_balance = (checking_balance + ?) WHERE username = ?";

			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setDouble(1, money);
			stmt.setString(2, username);
			
			double cb = money;

			if ((stmt.executeUpdate()) != 0) {
				return cb;
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
			
			String sql = "UPDATE project0.users SET savings_balance = (savings_balance + ?) WHERE username = ?";

			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setDouble(1, money);
			stmt.setString(2, username);
			
			double sb = money;

			if ((stmt.executeUpdate()) != 0) {
				return sb;
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

//	@Override
//	public List<String> getAccountInfo(String username) {
//
//		List<String> ai = new ArrayList<String>();
//
//		try (Connection conn = ConnectionUtil.getConnection()) {
//
//			Statement stmt = conn.createStatement();
//
//			String sql = "SELECT first_name, last_name, email, username, password FROM project0.users WHERE username = "
//					+ username;
//
//			ResultSet rs = stmt.executeQuery(sql);
//
//			while (rs.next()) {
//				String first_name = rs.getString("first_name");
//				String last_name = rs.getString("last_name");
//				String email = rs.getString("email");
//				String password = rs.getString("password");
//				ai.add(first_name);
//				ai.add(last_name);
//				ai.add(email);
//				ai.add(username);
//				ai.add(password);
//			}
//
//			return ai;
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//			System.out.println("WE FAILED TO GET USER ACCOUNT INFO");
//			return ai;
//		} finally {
//			closeResources();
//		}
//
//	}

	@Override
	public int updateAccountInfo(int id, String username, String first_name, String last_name, String email, String password) {

		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "UPDATE project0.users SET first_name = ?, last_name = ?, email = ?, username = ?, password = ? WHERE id = ? RETURNING project0.users.id";
			
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, first_name);
			stmt.setString(2, last_name);
			stmt.setString(3, email);
			stmt.setString(4, username);
			stmt.setString(5, password);
			stmt.setInt(6, id);

			ResultSet rs;
			if ((rs = stmt.executeQuery()) != null) {
				rs.next();

				int id1 = rs.getInt(1);

				return id1;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("WE FAILED TO UPDATE USER ACCOUNT INFO");
		} finally {
			closeResources();
		}
		return 0;
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

			String sql = "INSERT INTO project0.users (first_name, last_name, email, username, password, role, checking_balance, savings_balance) VALUES (?, ?, ?, ?, ?, ?, ?, ?) RETURNING project0.users.id";

			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, first_name);
			stmt.setString(2, last_name);
			stmt.setString(3, email);
			stmt.setString(4, username);
			stmt.setString(5, password);
			stmt.setInt(6, role);
			stmt.setDouble(7, checking_balance);
			stmt.setDouble(8, savings_balance);

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
