package com.bbbank.scanner;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.bbbank.dao.UserDAO;
import com.bbbank.hash.PasswordAuthentication;
import com.bbbank.models.Admin;
import com.bbbank.models.User;
import com.bbbank.dao.AdminDAO;
import com.bbbank.dao.ApplicationDAO;
import com.bbbank.dao.IAdminDAO;
import com.bbbank.dao.IApplicationDAO;
import com.bbbank.dao.IUserDAO;

import com.bbbank.logger.L4J;

public class ControlFlow {
	
	public final PasswordAuthentication auth = new PasswordAuthentication();
	
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

	public static boolean validateEmail(String emailStr) {
	        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
	        return matcher.find();
	}
	
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
	
	public ControlFlowUser cfu = new ControlFlowUser();
	public ControlFlowAdmin cfa = new ControlFlowAdmin();
	
	public static Scanner sc = new Scanner(System.in);
	
	public L4J log = new L4J();
	
	int selectionInt;
	static int userInt;
	
	public List<User> getUserByUsername() {
		
		System.out.println("");
		System.out.println("Enter Username");
		String username = sc.next();
		UserDAO user = new UserDAO();
		List<User> u = user.getByUsername(username);
		userInt = u.get(0).getId();
		if (userInt != 0) {
			return u;
		} else {
			System.out.println("Incorrect credentials. Please try again.");
			log.validationError("username");
			return getUserByUsername();
		}
		
	}
	
	public void authUser(String p1) {
		
		System.out.println("");
		System.out.println("Enter Password");
		String password = sc.next();

		if (auth.authenticate(password.toCharArray(), p1)) {
			return;
		} else {
			System.out.println("Incorrect credentials. Redirecting to homepage...");
			System.out.println("");
			log.validationError("password");
			start();
		}
		
	}
	
	public List<Admin> getAdminByUsername() {
		
		System.out.println("");
		System.out.println("Enter Username");
		String username = sc.next();
		AdminDAO admin = new AdminDAO();
		List<Admin> a = admin.getByUsername(username);
		if (a.get(0).getUsername().equals(username)) {
			return a;
		} else {
			System.out.println("Incorrect credentials. Please try again.");
			log.validationError("username");
			return getAdminByUsername();
		}
		
	}
	
	public void authAdmin(String p) {
		
		System.out.println("");
		System.out.println("Enter Password");
		String password = sc.next();
		
		if (auth.authenticate(password.toCharArray(), p)) {
			return;
		} else {
			System.out.println("Incorrect credentials. Redirecting to homepage...");
			System.out.println("");
			log.validationError("password");
			start();
		}
		
	}
	
	public void start() {
		
		log.start();
		
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
					List<Admin> a = getAdminByUsername();
					String p = a.get(0).getPassword();
					authAdmin(p);
				} else if(role == 2) {
					List<User> u = getUserByUsername();
					String p1 = u.get(0).getPassword();
					authUser(p1);
				}
				log.login();
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
						System.out.println("Invalid command. Redirecting to homepage...");
						System.out.println("");
						log.validationError("command");
						start();
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
//				user apply                           
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
					
//					validate email
					if(!validateEmail(email)) {
						System.out.println("Invalid email. Redirecting to homepage...");
						System.out.println("");
						log.validationError("email");
						start();
					}
					
					System.out.println("Enter password:");
					String password1 = sc.next();
					
//					hash password
					String p1 = auth.hash(password1.toCharArray());
					
					System.out.println("Please provide credit score:");
					int creditscore = sc.nextInt();
					
//					validate creditscore
					if(creditscore < 300 || creditscore > 850) {
						System.out.println("Invalid credit score. Redirecting to homepage...");
						System.out.println("");
						log.validationError("credit score");
						start();
					}
					
					System.out.println("Please provide annual income:");
					int income = sc.nextInt();
					
//					validate income
					if(income < 0) {
						System.out.println("Invalid income. Redirecting to homepage...");
						System.out.println("");
						log.validationError("income");
						start();
					}					
					
					int role2 = 2;
					ApplicationDAO app = new ApplicationDAO();
					app.insert(firstname, lastname, email, p1, role2, creditscore, income);
					System.out.println("------------------");
					System.out.println("");
					System.out.println("Bank admin will contact you to advise whether you are approved or denied");
					sc.close();
					System.out.println("");
					System.out.println("------------------");
					System.out.println("");
					System.out.println("Thank you for banking with BB Bank");
					log.appSubmitted();
					log.end();
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
							
//							validate email
							if(!validateEmail(email1)) {
								System.out.println("Invalid email. Redirecting to homepage...");
								System.out.println("");
								log.validationError("email");
								start();
							}
							
							System.out.println("Enter password:");
							String password3 = sc.next();
							
//							hash password
							String p = auth.hash(password3.toCharArray());
							
							int role1 = 1;
							admin.insert(firstname1, lastname1, email1, email1, p, role1);
							System.out.println("------------------");
							System.out.println("");
							System.out.println("Success. New admin account created.");
							System.out.println("");
							System.out.println("------------------");
							System.out.println("");
							System.out.println("Please login in to new account");
							System.out.println("");
							System.out.println("------------------");
							log.signup();
							start();
							break;
						default :
//							need method here that re-runs admin password request
							System.out.println("Authentication denied. Redirecting to homepage...");
							log.validationError("password");
							start();
							break;
					}
//					nested switch level 2 end (admin auth)
					break;
				default :
					System.out.println("Invalid command. Redirecting to homepage...");
					System.out.println("");
					log.validationError("command");
					start();
					break;
				}
//			nested switch level 1 end (role admin)
				break;
			default :
				System.out.println("Invalid command. Redirecting to homepage...");
				System.out.println("");
				log.validationError("command");
				start();
				break;
		}
//		switch level 0 end (sign up)
	}

}
