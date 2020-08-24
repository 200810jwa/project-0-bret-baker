package com.bbbank.scanner;

import java.util.List;
import java.util.Scanner;

import com.bbbank.dao.UserDAO;
import com.bbbank.models.User;
import com.bbbank.dao.AdminDAO;
import com.bbbank.dao.ApplicationDAO;
import com.bbbank.dao.IAdminDAO;
import com.bbbank.dao.IApplicationDAO;
import com.bbbank.dao.IUserDAO;

public class ControlFlow {
	
	private IUserDAO userDAO;
	private IAdminDAO adminDAO;
	private IApplicationDAO applicationDAO;
	
	public ControlFlow(IUserDAO userDAO) {
		super();
		this.userDAO = new UserDAO();
	}
	
	public ControlFlow(IAdminDAO adminDAO) {
		super();
		this.adminDAO = new AdminDAO();
	}
	
	public ControlFlow(IApplicationDAO applicationDAO) {
		super();
		this.applicationDAO = new ApplicationDAO();
	}
	
	public ControlFlow() {
		super();
		this.userDAO = new UserDAO();
		this.adminDAO = new AdminDAO();
		this.applicationDAO = new ApplicationDAO();
	}
	
	public static ControlFlowUser cfu = new ControlFlowUser();
	public static ControlFlowAdmin cfa = new ControlFlowAdmin();
	
	public static Scanner sc = new Scanner(System.in);
	
	int selectionInt;
	static int userInt;
	
	public int getUserByUsername() {
		
		System.out.println("Enter Username");
		String username = sc.next();
		UserDAO user = new UserDAO();
		List<User> u = user.getByUsername(username);
		userInt = u.get(0).getId();
		if (userInt != 0) {
			return userInt;
		} else {
			System.out.println("Incorrect credentials");
			return getUserByUsername();
		}
		
	}
	
	public boolean getUserByPassword() {
		
		System.out.println("Enter Password");
		String password = sc.next();
		UserDAO user = new UserDAO();
		boolean u = user.getByPassword(password);
		if (u) {
			return true;
		} else {
			System.out.println("Incorrect credentials");
			return getUserByPassword();
		}
		
	}
	
	public boolean getAdminByUsername() {
		
		System.out.println("Enter Username");
		String username = sc.next();
		AdminDAO admin = new AdminDAO();
		boolean a = admin.getByUsername(username);
		if (a) {
			return true;
		} else {
			System.out.println("Incorrect credentials");
			return getAdminByUsername();
		}
		
	}
	
	public boolean getAdminByPassword() {
		
		System.out.println("Enter Password");
		String password = sc.next();
		AdminDAO admin = new AdminDAO();
		boolean a = admin.getByPassword(password);
		if (a) {
			return true;
		} else {
			System.out.println("Incorrect credentials");
			return getAdminByPassword();
		}
		
	}
	
	public void start() {
		
		System.out.println("Welcome to BB Bank");
		System.out.println("------------------");
		System.out.println("1 Login");
		System.out.println("2 Sign Up");
		selectionInt = sc.nextInt();
		
//		switch level 0 start (login)
		switch(selectionInt) {
//		login
			case 1 :
				System.out.println("");
				System.out.println("Login");
				System.out.println("------------------");
				System.out.println("1 Admin");
				System.out.println("2 User");
				int role = sc.nextInt();
				if(role == 1) {
					getAdminByUsername();
					getAdminByPassword();
				} else if(role == 2) {
					getUserByUsername();
					getUserByPassword();
				}
				System.out.println("");
				System.out.println("------------------");
				System.out.println("----- Welcome ----");
				System.out.println("------------------");
				System.out.println("");
//			nested switch level 1 start (role admin)
				switch(role) {
//				admin homepage
					case 1 :
						cfa.adminHomePage();
						break;
//				user homepage
					case 2 :
						cfu.userHomePage(userInt);
						break;
					default :
						System.out.println("Error");
						break;
//			nested switch level 1 end (role user)
				}
				break;
//		switch level 0 continue (sign up)				
//		sign up
			case 2 :
				System.out.println("");
				System.out.println("Sign Up");
				System.out.println("------------------");
				System.out.println("1 User");
				System.out.println("2 Admin");
				selectionInt = sc.nextInt();
//			nested switch level 1 start (role admin)
				switch(selectionInt) {
//				user sign up                           
				case 1 :
					System.out.println("");
					System.out.println("Enter information below to apply for an account");
					System.out.println("------------------");
					System.out.println("");
					System.out.println("Enter first name:");
					String firstname = sc.next();
					System.out.println("Enter last name:");
					String lastname = sc.next();
					System.out.println("Enter email:");
					String email = sc.next();
					System.out.println("Enter password:");
					String password1 = sc.next();
					System.out.println("Please provide credit score:");
					int creditscore = sc.nextInt();
					System.out.println("Please provide annual income:");
					int income = sc.nextInt();
					int role2 = 2;
					ApplicationDAO app = new ApplicationDAO();
					app.insert(firstname, lastname, email, password1, role2, creditscore, income);
					System.out.println("------------------");
					System.out.println("");
					System.out.println("Bank admin will contact you to advise whether you are approved or denied");
					sc.close();
					System.out.println("");
					System.out.println("------------------");
					System.out.println("");
					System.out.println("Thank you for banking with BB Bank");
					break;
//				admin sign up
				case 2 : 
					System.out.println("");
					System.out.println("Enter provided admin password to authenticate");
					String password2 = sc.next();
//					nested switch level 2 start (admin auth)
					switch(password2) {
						case "adminpassword" : 
							System.out.println("");
							AdminDAO admin = new AdminDAO();
							System.out.println("Enter first name:");
							String firstname1 = sc.next();
							System.out.println("Enter last name:");
							String lastname1 = sc.next();
							System.out.println("Enter email:");
							String email1 = sc.next();
							System.out.println("Enter password:");
							String password3 = sc.next();
							int role1 = 1;
							admin.insert(firstname1, lastname1, email1, email1, password3, role1);
							System.out.println("------------------");
							System.out.println("");
							System.out.println("Success. New admin account created.");
							System.out.println("");
							System.out.println("------------------");
							System.out.println("");
							System.out.println("Please login in to new account");
							System.out.println("");
							System.out.println("------------------");
							start();
							break;
						default :
//							need method here that re-runs admin password request
							System.out.println("Incorrect credentials. Try again.");
							start();
							break;
					}
//					nested switch level 2 end (admin auth)
					break;
				default :
					System.out.println("error");
					break;
				}
//			nested switch level 1 end (role admin)
				break;
			default :
				System.out.println("Error");
		}
//		switch level 0 end (sign up)
	}

}
