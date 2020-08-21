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
import com.bbbank.utils.ConnectionUtil;

public class ApplicationDAO implements IApplicationDAO {
	
	Connection conn = null;
	PreparedStatement stmt = null;

	@Override
	public List<Application> getAll() {

		List<Application> allApps = new ArrayList<>();

		try (Connection conn = ConnectionUtil.getConnection()) {

			Statement stmt = conn.createStatement();

			String sql = "SELECT * FROM project0.APPLICATIONS";

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("id");
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				String email = rs.getString("email");
				String password = rs.getString("password");
				int role = rs.getInt("role");
				int credit_score = rs.getInt("credit_score");
				int annual_income = rs.getInt("annual_income");

				Application a = new Application(id, first_name, last_name, email, password, role, credit_score, annual_income);
				allApps.add(a);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("WE FAILED TO RETRIEVE ALL APPLICATIONS");
			return null;
		} finally {
			closeResources();
		}

		for (int i = 0; i < allApps.size(); i++) {
			System.out.println(allApps.get(i));
		}
		return allApps;
	}

	@Override
	public Application getByUsername(String email) {

		List<Application> app = new ArrayList<>();

		try (Connection conn = ConnectionUtil.getConnection()) {

			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM project0.APPLICATIONS WHERE email = ?");

			stmt.setString(1, email);

			ResultSet rs;
			if ((rs = stmt.executeQuery()) != null) {
				while (rs.next()) {
					int id = rs.getInt("id");
					String first_name = rs.getString("first_name");
					String last_name = rs.getString("last_name");
					String email1 = rs.getString("email");
					String password = rs.getString("password");
					int role = rs.getInt("role");
					int credit_score = rs.getInt("credit_score");
					int annual_income = rs.getInt("annual_income");

					Application a = new Application(id, first_name, last_name, email1, password, role, credit_score, annual_income);
					app.add(a);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("WE FAILED TO FIND THIS APPLICATION");
		} finally {
			closeResources();
		}

		System.out.println(app.get(0));
		return null;
	}

	@Override
	public int insert(String first_name, String last_name, String email, String password, int role, int credit_score,
			int annual_income) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "INSERT INTO project0.applications (first_name, last_name, email, password, role, credit_score, annual_income) VALUES (?, ?, ?, ?, ?, ?, ?) RETURNING project0.applications.id";

			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, first_name);
			stmt.setString(2, last_name);
			stmt.setString(3, email);
			stmt.setString(4, password);
			stmt.setInt(5, role);
			stmt.setInt(6, credit_score);
			stmt.setInt(7, annual_income);

			ResultSet rs;
			if ((rs = stmt.executeQuery()) != null) {
				rs.next();

				int id = rs.getInt(1);

				return id;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("WE FAILED TO INSERT APPLICATION");
		} finally {
			closeResources();
		}

		return 0;
	}

	@Override
	public boolean delete(String email) {

		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "DELETE FROM project0.applications WHERE email = ?";

			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, email);
			
			if (stmt.executeUpdate() != 0)
				return true;
			else
				return false;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("WE FAILED TO DELETE APPLICATION");
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
