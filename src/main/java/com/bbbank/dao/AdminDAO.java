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

import com.bbbank.models.Admin;
import com.bbbank.models.User;
import com.bbbank.utils.ConnectionUtil;

public class AdminDAO implements IAdminDAO {
	
	Connection conn = null;
	PreparedStatement stmt = null;
	
	@Override
	public boolean getByUsername(String username) {

		List<Admin> admin = new ArrayList<>();

		try (Connection conn = ConnectionUtil.getConnection()) {

			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM project0.admins WHERE username = ?");

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

					Admin a = new Admin(id, first_name, last_name, email1, username1, password, role);
					admin.add(a);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("WE FAILED TO RETRIEVE ADMIN");
			return false;
		} finally {
			closeResources();
		}
		
//		System.out.println(admin.get(0));
		return true;
	}
	
	@Override
	public boolean getByPassword(String password) {

		List<Admin> admin = new ArrayList<>();

		try (Connection conn = ConnectionUtil.getConnection()) {

			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM project0.admins WHERE password = ?");

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

					Admin a = new Admin(id, first_name, last_name, email1, username1, password1, role);
					admin.add(a);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("WE FAILED TO RETRIEVE ADMIN");
			return false;
		} finally {
			closeResources();
		}
		
//		System.out.println(admin.get(0));
		return true;
	}

//	@Override
//	public boolean transferFunds(String username, String username1, String acct, String acct1, double amount) {
//
//		try (Connection conn = ConnectionUtil.getConnection()) {
//
//			Statement stmt = conn.createStatement();
//
//			String sql = "SELECT " + acct + " FROM project0.users WHERE username = " + username;
//
//			ResultSet rs = stmt.executeQuery(sql);
//
//			double b = 0;
//
//			while (rs.next()) {
//				b = rs.getDouble(acct) - amount;
//			}
//
//			Statement stmt1 = conn.createStatement();
//
//			String sql1 = "SELECT " + acct1 + " FROM project0.users WHERE username = " + username;
//
//			ResultSet rs1 = stmt1.executeQuery(sql1);
//
//			double b1 = 0;
//
//			while (rs1.next()) {
//				b1 = rs1.getDouble(acct1) + amount;
//			}
//			
//			Statement stmt2 = conn.createStatement();
//
//			String sql2 = "UPDATE project0.users SET " + acct + " = " + b + " WHERE username = " + username;
//
//			ResultSet rs2 = stmt2.executeQuery(sql2);
//
//			rs2.next();
//			
//			Statement stmt3 = conn.createStatement();
//
//			String sql3 = "UPDATE project0.users SET " + acct1 + " = " + b1 + " WHERE username = " + username1;
//
//			ResultSet rs3 = stmt3.executeQuery(sql3);
//
//			rs3.next();
//			
//			return true;
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//			System.out.println("WE FAILED TO RETRIEVE USER CHECKING BALANCE");
//			return false;
//		} finally {
//			closeResources();
//		}
//		
//	}

	@Override
	public int insert(String first_name, String last_name, String email, String username, String password, int role) {

		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "INSERT INTO project0.admins (first_name, last_name, email, username, password, role) VALUES (?, ?, ?, ?, ?, ?) RETURNING project0.admins.id";

			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, first_name);
			stmt.setString(2, last_name);
			stmt.setString(3, email);
			stmt.setString(4, username);
			stmt.setString(5, password);
			stmt.setInt(6, role);

			ResultSet rs;
			if ((rs = stmt.executeQuery()) != null) {
				rs.next();

				int id = rs.getInt(1);

				return id;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("WE FAILED TO INSERT NEW ADMIN");
		} finally {
			closeResources();
		}

		return 0;
		
	}

	@Override
	public boolean delete(String username) {

		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "DELETE FROM project0.admins WHERE username = ?";

			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, username);
			
			if (stmt.executeUpdate() != 0)
				return true;
			else
				return false;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("WE FAILED TO DELETE ADMIN");
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
