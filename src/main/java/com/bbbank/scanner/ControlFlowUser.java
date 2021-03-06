package com.bbbank.scanner;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.bbbank.dao.UserDAO;
import com.bbbank.models.Application;
import com.bbbank.models.User;

import com.bbbank.logger.L4J;

public class ControlFlowUser {
	
	public static L4J log = new L4J();
	
	public static Scanner sc = new Scanner(System.in);
	
	public static double checking = 0;
	public static double savings = 0;
	
	public static List<User> user = new ArrayList<>();
	public static UserDAO user1 = new UserDAO();

	public void userHomePage(int userInt) {
//		user1.getById(userInt);
		System.out.println("1 View Balances");
		System.out.println("2 View Account Information");
		System.out.println("3 Logout");
		int selectionInt = sc.nextInt();
//	nested switch level 2 start (user homepage)
		switch (selectionInt) {
//	view balances
		case 1:
			user = user1.getById(userInt);
			checking = user.get(0).getChecking_balance();
			savings = user.get(0).getSavings_balance();
			System.out.println("");
			System.out.println("Checking Balance: $" + checking);
			System.out.println("Savings Balance: $" + savings);
			System.out.println("");
			System.out.println("------------------");
			System.out.println("");
			System.out.println("1 Deposit");
			System.out.println("2 Withdraw");
			System.out.println("3 Logout");
			selectionInt = sc.nextInt();
//			nested switch level 3 start (view balances)
			switch (selectionInt) {
//			deposit options
			case 1:
				System.out.println("");
				System.out.println("1 Deposit Checking");
				System.out.println("2 Deposit Savings");
				System.out.println("3 Logout");
				selectionInt = sc.nextInt();
//					nested switch level 4 start (deposit options)
				switch (selectionInt) {
//					deposit checking
					case 1:
						System.out.println("");
						System.out.println("Enter amount to Deposit in Checking");
						double deposit = sc.nextDouble();

//						validate deposit amount
						if(deposit <= 0) {
							System.out.println("Invalid deposit amount. Redirecting to homepage...");
							System.out.println("");
							log.validationError("deposit");
							userHomePage(userInt);
						}
						
						String username = user.get(0).getUsername();
						user1.updateCheckingBalance(username, deposit);
						System.out.println("");
						System.out.println("Success: $" + deposit + " deposited in Checking");
						System.out.println("");
						System.out.println("Returning to home page...");
						System.out.println("");
						log.deposit();
						userHomePage(userInt);
						break;
//					deposit savings			
					case 2:
						System.out.println("");
						System.out.println("Enter amount to Deposit in Savings");
						double deposit1 = sc.nextDouble();

//						validate deposit amount
						if(deposit1 <= 0) {
							System.out.println("Invalid deposit amount. Redirecting to homepage...");
							System.out.println("");
							log.validationError("deposit");
							userHomePage(userInt);
						}
							
						String username1 = user.get(0).getUsername();
						user1.updateSavingsBalance(username1, deposit1);
						System.out.println("");
						System.out.println("Success: $" + deposit1 + " deposited in Savings");
						System.out.println("");
						System.out.println("Returning to home page...");
						System.out.println("");
						log.deposit();
						userHomePage(userInt);
						break;
//					logout	
					case 3:		
						sc.close();
						System.out.println("------------------");
						System.out.println("Thank you for banking with BB Bank");
						log.end();
						break;
					default:
						System.out.println("Invalid command. Redirecting to homepage...");
						System.out.println("");
						log.validationError("command");
						userHomePage(userInt);
						break;
					}
//					nested switch level 4 end (deposit options)
				break;
//			withdraw options	
			case 2:
				System.out.println("");
				System.out.println("1 Withdraw Checking");
				System.out.println("2 Withdraw Savings");
				System.out.println("3 Logout");
				selectionInt = sc.nextInt();
//					nested switch level 4 start (withdraw options)
				switch (selectionInt) {
//					withdraw checking
					case 1:
						System.out.println("");
						System.out.println("Enter amount to Withdraw from Checking");
						double withdraw = sc.nextDouble();
						
//						validate withdrawal amount
						if(withdraw > checking) {
							System.out.println("Invalid withdrawal amount. Redirecting to homepage...");
							System.out.println("");
							log.validationError("withdraw");
							userHomePage(userInt);
						}
						
						withdraw = -withdraw;
						String username = user.get(0).getUsername();
						user1.updateCheckingBalance(username, withdraw);
						System.out.println("");
						System.out.println("Success: $" + withdraw + " withdrawn from Checking");
						System.out.println("");
						System.out.println("Returning to home page...");
						System.out.println("");
						log.withdraw();
						userHomePage(userInt);
						break;
	//					withdraw savings			
					case 2:
						System.out.println("");
						System.out.println("Enter amount to Withdraw from Savings");
						double withdraw1 = sc.nextDouble();
						
//						validate withdrawal amount
						if(withdraw1 > savings) {
							System.out.println("Invalid withdrawal amount. Redirecting to homepage...");
							System.out.println("");
							log.validationError("withdraw");
							userHomePage(userInt);
						}
						
						withdraw1 = -withdraw1;
						String username1 = user.get(0).getUsername();
						user1.updateCheckingBalance(username1, withdraw1);
						System.out.println("");
						System.out.println("Success: $" + withdraw1 + " withdrawn from Savings");
						System.out.println("");
						System.out.println("Returning to home page...");
						System.out.println("");
						log.withdraw();
						userHomePage(userInt);
						break;
	//					logout
					case 3:
						sc.close();
						System.out.println("------------------");
						System.out.println("Thank you for banking with BB Bank");
						log.end();
						break;
					default:
						System.out.println("Invalid command. Redirecting to homepage...");
						System.out.println("");
						log.validationError("command");
						userHomePage(userInt);
						break;
				}
//					nested switch level 4 end (withdraw options)								
				break;
//			logout
			case 3:
				sc.close();
				System.out.println("------------------");
				System.out.println("Thank you for banking with BB Bank");
				log.end();
				break;
			default:
				System.out.println("Invalid command. Redirecting to homepage...");
				System.out.println("");
				log.validationError("command");
				userHomePage(userInt);
				break;
			}
//		nested switch level 3 end (view balances)
			break;
//		view acct info
		case 2:
//		nested switch level 3 start (view acct info)
			user1.getById(userInt);
			System.out.println("");
			System.out.println("------------------");
			System.out.println("");
			System.out.println("1 Edit Account Info");
			System.out.println("2 Return to Homepage");
			System.out.println("3 Logout");
			selectionInt = sc.nextInt();
//				nested switch level 4 start (edit acct info)
			switch (selectionInt) {
//				edit acct info
				case 1:
					System.out.println("Enter first name:");
					String firstname = sc.next();
					System.out.println("Enter last name:");
					String lastname = sc.next();
					System.out.println("Enter email:");
					String email = sc.next();
					System.out.println("Enter password:");
					String password = sc.next();
					String username = email;
					user1.updateAccountInfo(userInt, username, firstname, lastname, email, password);
					System.out.println("");
					System.out.println("Account information updated.");
					System.out.println("");
					System.out.println("Returning to home page...");
					System.out.println("");
					log.acctUpdated();
					userHomePage(userInt);
					break;
//				return to homepage
				case 2:
					System.out.println("");
					System.out.println("Returning to home page...");
					System.out.println("");
					userHomePage(userInt);
					break;
//				logout
				case 3:
					sc.close();
					System.out.println("------------------");
					System.out.println("Thank you for banking with BB Bank");
					log.end();
					break;
				default:
					System.out.println("Invalid command. Redirecting to homepage...");
					System.out.println("");
					log.validationError("command");
					userHomePage(userInt);
					break;
	//				nested switch level 4 end (edit acct info)
			}
			break;
//		logout
		case 3:
			sc.close();
			System.out.println("------------------");
			System.out.println("Thank you for banking with BB Bank");
			log.end();
			break;
		default:
			System.out.println("Invalid command. Redirecting to homepage...");
			System.out.println("");
			log.validationError("command");
			userHomePage(userInt);
			break;
		}
//		nested switch level 3 start (view acct info)						
//	nested switch level 2 end (user homepage)
	}

}
