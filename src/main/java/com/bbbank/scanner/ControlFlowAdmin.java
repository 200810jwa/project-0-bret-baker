package com.bbbank.scanner;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.bbbank.dao.ApplicationDAO;
import com.bbbank.dao.UserDAO;
import com.bbbank.models.Application;
import com.bbbank.models.User;

import com.bbbank.logger.L4J;

public class ControlFlowAdmin {
	
	public static L4J log = new L4J();
	
	public static double checking = 0;
	public static double savings = 0;
	public static double checking1 = 0;
	public static double savings1 = 0;

	public static Scanner sc = new Scanner(System.in);
	
	public static List<User> user1 = new ArrayList<>();
	public static List<User> user2 = new ArrayList<>();
	
	public static ApplicationDAO apps = new ApplicationDAO();
	public static UserDAO user = new UserDAO();
	
	public void adminHomePage() {
		
		int selectionInt;
		
		System.out.println("1 Applications");
		System.out.println("2 User Information");
		System.out.println("3 Account Transactions");
		System.out.println("4 Logout");
		selectionInt = sc.nextInt();
//		nested switch level 2 start (admin homepage)
		switch(selectionInt) {
//		applications
		case 1 :
//			check db for open apps, if true, list for admin, if false provide msg stating no open apps
//			apps.getAll();
			List<Application> app1 = new ArrayList<>();
			app1 = apps.getAll();
			System.out.println("");
			if(app1.size() == 0) {
				System.out.println("There are " + app1.size() + " applications pending review.");
				System.out.println("");
				System.out.println("Returning to home page...");
				System.out.println("");
				adminHomePage();
			} else {
				System.out.println("");
				System.out.println("------------------");
				System.out.println("");
				System.out.println("Enter email of user from list above to view application");
				String userapp = sc.next();
//				get application data from db and display for admin
				List<Application> app = new ArrayList<>();
				System.out.println("");
				app = apps.getByUsername(userapp);
				System.out.println("");
				String first_name = app.get(0).getFirst_name();
				String last_name = app.get(0).getLast_name();
				String email = userapp;
				String username = userapp;
				String password = app.get(0).getPassword();
				int role = 2;
				double checking_balance = 0;
				double savings_balance = 0;
				System.out.println("------------------");
				System.out.println("1 Approve");
				System.out.println("2 Reject");
				System.out.println("3 Logout");
				selectionInt = sc.nextInt();
//				nested switch level 3 start (open applications)
				switch(selectionInt) {
				case 1 :
//					send data to user table, starting balances $0
					user.insert(first_name, last_name, email, username, password, role, checking_balance, savings_balance);
					apps.delete(userapp);
					System.out.println("");
					System.out.println("Approved. User added to system.");
					System.out.println("");
					System.out.println("Returning to home page...");
					System.out.println("");
					log.appApproved();
					adminHomePage();
					break;
				case 2 :
//					delete from applications table
					apps.delete(userapp);
					System.out.println("");
					System.out.println("Denied. Application deleted.");
					System.out.println("");
					System.out.println("Returning to home page...");
					System.out.println("");
					log.appRejected();
					adminHomePage();
					break;
				case 3 :
//					logout
					sc.close();
					System.out.println("------------------");
					System.out.println("Thank you for banking with BB Bank");
					log.end();
					break;
				default : 
					System.out.println("Invalid command. Redirecting to homepage...");
					System.out.println("");
					adminHomePage();
					break;
				}
			}
//			nested switch level 3 end (open applications)
			break;
//		user accounts
		case 2 :
			List<User> users = new ArrayList<>();
			users = user.getAllUsers();
			System.out.println("");
			System.out.println("There are " + users.size() + " users in our system.");
			System.out.println("");
			System.out.println("Returning to home page...");
			System.out.println("");
			adminHomePage();
			break;
//		account transactions
		case 3 :
			System.out.println("1 Deposit");
			System.out.println("2 Withdrawal");
			System.out.println("3 Transfer");
			System.out.println("4 Cancellation");
			System.out.println("5 Logout");
			selectionInt = sc.nextInt();
//			nested switch level 3 start (account transactions)
			switch(selectionInt) {
//			admin deposit
			case 1 :
				System.out.println("Enter username for account to Deposit");
				String username2 = sc.next();
				user1 = user.getByUsername(username2);
				checking = user1.get(0).getChecking_balance();
				savings = user1.get(0).getSavings_balance();
				System.out.println("");
				System.out.println("Checking Balance: $" + checking);
				System.out.println("Savings Balance: $" + savings);
				System.out.println("");
				System.out.println("------------------");
				System.out.println("");
				System.out.println("1 Deposit Checking");
				System.out.println("2 Deposit Savings");
				selectionInt = sc.nextInt();
//				nested switch level 4 start (admin deposit)
				switch(selectionInt) {
				case 1 :
					System.out.println("Enter amount to Deposit in Checking");
					double deposit1 = sc.nextDouble();

//					validate deposit amount
					if(deposit1 <= 0) {
						System.out.println("Invalid deposit amount. Redirecting to homepage...");
						System.out.println("");
						adminHomePage();
					}
					
					user.updateCheckingBalance(username2, deposit1);
					System.out.println("");
					System.out.println("Success: $" + deposit1 + " deposited in Checking");
					System.out.println("");
					System.out.println("Returning to home page...");
					System.out.println("");
					log.deposit();
					adminHomePage();
					break;
				case 2 :
					System.out.println("Enter amount to Deposit in Savings");
					double deposit2 = sc.nextDouble();
					
//					validate deposit amount
					if(deposit2 <= 0) {
						System.out.println("Invalid deposit amount. Redirecting to homepage...");
						System.out.println("");
						adminHomePage();
					}					
					
					user.updateSavingsBalance(username2, deposit2);
					System.out.println("");
					System.out.println("Success: $" + deposit2 + " deposited in Savings");
					System.out.println("");
					System.out.println("Returning to home page...");
					System.out.println("");
					log.deposit();
					adminHomePage();
					break;
				default :
					System.out.println("Invalid command. Redirecting to homepage...");
					System.out.println("");
					adminHomePage();
					break;
				}
//				nested switch level 4 end (admin deposit)
				break;
//			admin withdrawal
			case 2 :
				System.out.println("Enter username for account to Withdraw");
				String username3 = sc.next();
				user1 = user.getByUsername(username3);
				checking = user1.get(0).getChecking_balance();
				savings = user1.get(0).getSavings_balance();
				System.out.println("");
				System.out.println("Checking Balance: $" + checking);
				System.out.println("Savings Balance: $" + savings);
				System.out.println("");
				System.out.println("------------------");
				System.out.println("");
				System.out.println("1 Withdraw Checking");
				System.out.println("2 Withdraw Savings");
				selectionInt = sc.nextInt();
//				nested switch level 4 start (admin withdrawal)
				switch(selectionInt) {
				case 1 :
					System.out.println("Enter amount to Withdraw from Checking");
					double withdraw1 = sc.nextDouble();
					
//					validate withdrawal amount
					if(withdraw1 > checking) {
						System.out.println("Invalid withdrawal amount. Redirecting to homepage...");
						System.out.println("");
						adminHomePage();
					}
					
					withdraw1 = -withdraw1;
					user.updateCheckingBalance(username3, withdraw1);
					System.out.println("");
					System.out.println("Success: $" + withdraw1 + " withdrawn from Checking");
					System.out.println("");
					System.out.println("Returning to home page...");
					System.out.println("");
					log.withdraw();
					adminHomePage();
					break;
				case 2 :
					System.out.println("Enter amount to Withdraw from Savings");
					double withdraw2 = sc.nextDouble();
					
//					validate withdrawal amount
					if(withdraw2 > savings) {
						System.out.println("Invalid withdrawal amount. Redirecting to homepage...");
						System.out.println("");
						adminHomePage();
					}					
					
					withdraw2 = -withdraw2;
					user.updateSavingsBalance(username3, withdraw2);
					System.out.println("");
					System.out.println("Success: $" + withdraw2 + " withdrawn from Savings");
					System.out.println("");
					System.out.println("Returning to home page...");
					System.out.println("");
					log.withdraw();
					adminHomePage();
					break;
				default :
					System.out.println("Invalid command. Redirecting to homepage...");
					System.out.println("");
					adminHomePage();
					break;
				}
//				nested switch level 4 end (admin withdrawal)
				break;
//			admin transfer
			case 3 :
				System.out.println("Enter username of account to Transfer from");
				String username4 = sc.next();
				user1 = user.getByUsername(username4);
				checking = user1.get(0).getChecking_balance();
				savings = user1.get(0).getSavings_balance();
				System.out.println("");
				System.out.println("Checking Balance: $" + checking);
				System.out.println("Savings Balance: $" + savings);
				System.out.println("");
				System.out.println("------------------");
				System.out.println("");				
				System.out.println("1 Transfer from Checking");
				System.out.println("2 Transfer from Savings");
				selectionInt = sc.nextInt();
//				nested switch level 4 start (admin transfer)
				switch(selectionInt) {
//					transfer from checking
					case 1: 
						System.out.println("Enter username of account to Transfer to");
						String username5 = sc.next();
						user2 = user.getByUsername(username5);
						checking1 = user2.get(0).getChecking_balance();
						savings1 = user2.get(0).getSavings_balance();
						System.out.println("");
						System.out.println("Checking Balance: $" + checking1);
						System.out.println("Savings Balance: $" + savings1);
						System.out.println("");
						System.out.println("------------------");
						System.out.println("");
						System.out.println("1 Transfer to Checking");
						System.out.println("2 Transfer to Savings");
						selectionInt = sc.nextInt();
//						nested switch level 5 start (admin transfer from checking)
						switch(selectionInt) {
//							transfer to checking
							case 1 :
								System.out.println("Enter amount to transfer");
								double transfer = sc.nextDouble();
								
//								validate transfer amount
								if(transfer > checking) {
									System.out.println("Invalid transfer amount. Redirecting to homepage...");
									System.out.println("");
									adminHomePage();
								}
								
								user.updateCheckingBalance(username5, transfer);
								transfer = -transfer;
								user.updateCheckingBalance(username4, transfer);
								System.out.println("");
								System.out.println("Transfer success.");
								System.out.println("");
								System.out.println("Returning to home page...");
								System.out.println("");
								log.transfer();
								adminHomePage();
								break;
//							transfer to savings
							case 2 :
								System.out.println("Enter amount to transfer");
								double transfer1 = sc.nextDouble();
								
//								validate transfer amount
								if(transfer1 > checking) {
									System.out.println("Invalid transfer amount. Redirecting to homepage...");
									System.out.println("");
									adminHomePage();
								}
								
								user.updateSavingsBalance(username5, transfer1);
								transfer1 = -transfer1;
								user.updateCheckingBalance(username4, transfer1);
								System.out.println("");
								System.out.println("Transfer success.");
								System.out.println("");
								System.out.println("Returning to home page...");
								System.out.println("");
								log.transfer();
								adminHomePage();
								break;
							default :
								System.out.println("Invalid command. Redirecting to homepage...");
								System.out.println("");
								adminHomePage();
								break;
						}
//						nested switch level 5 end (admin transfer from checking)
						break;
//					transfer from savings
					case 2 :
						System.out.println("Enter username of account to Transfer to");
						String username6 = sc.next();
						user2 = user.getByUsername(username6);
						checking1 = user2.get(0).getChecking_balance();
						savings1 = user2.get(0).getSavings_balance();
						System.out.println("");
						System.out.println("Checking Balance: $" + checking1);
						System.out.println("Savings Balance: $" + savings1);
						System.out.println("");
						System.out.println("------------------");
						System.out.println("");
						System.out.println("1 Transfer to Checking");
						System.out.println("2 Transfer to Savings");
						selectionInt = sc.nextInt();
//						nested switch level 5 start (admin transfer from savings)
						switch(selectionInt) {
//							transfer to checking
							case 1 :
								System.out.println("Enter amount to transfer");
								double transfer = sc.nextDouble();
								
//								validate transfer amount
								if(transfer > checking) {
									System.out.println("Invalid transfer amount. Redirecting to homepage...");
									System.out.println("");
									adminHomePage();
								}
								
								user.updateCheckingBalance(username6, transfer);
								transfer = -transfer;
								user.updateSavingsBalance(username4, transfer);
								System.out.println("");
								System.out.println("Transfer success.");
								System.out.println("");
								System.out.println("Returning to home page...");
								System.out.println("");
								log.transfer();
								adminHomePage();
								break;
//							transfer to savings
							case 2 :
								System.out.println("Enter amount to transfer");
								double transfer1 = sc.nextDouble();
								
//								validate transfer amount
								if(transfer1 > checking) {
									System.out.println("Invalid transfer amount. Redirecting to homepage...");
									System.out.println("");
									adminHomePage();
								}
								
								user.updateCheckingBalance(username6, transfer1);
								transfer1 = -transfer1;
								user.updateSavingsBalance(username4, transfer1);
								System.out.println("");
								System.out.println("Transfer success.");
								System.out.println("");
								System.out.println("Returning to home page...");
								System.out.println("");
								log.transfer();
								adminHomePage();
								break;
							default :
								System.out.println("Invalid command. Redirecting to homepage...");
								System.out.println("");
								adminHomePage();
								break;
						}
//						nested switch level 5 end (admin transfer from savings)
						break;
					default :
						System.out.println("Invalid command. Redirecting to homepage...");
						System.out.println("");
						adminHomePage();
						break;
				}
//				nested switch level 4 end (admin transfer)
				break;
//			cancel account
			case 4 :
				System.out.println("Enter username of account to Cancel");
				String username5 = sc.next();
				user.getByUsername(username5);
				System.out.println("1 Cancel");
				System.out.println("2 Return to Homepage");
				selectionInt = sc.nextInt();
//				nested switch level 4 start cancel account
				switch(selectionInt) {
				case 1 :
					user.delete(username5);
					System.out.println("");
					System.out.println("Account canceled.");
					System.out.println("");
					System.out.println("Returning to home page...");
					System.out.println("");
					log.cancel();
					adminHomePage();
					break;
				case 2 :
					System.out.println("");
					System.out.println("Returning to home page...");
					System.out.println("");
					adminHomePage();
					break;
				default : 
					System.out.println("Invalid command. Redirecting to homepage...");
					System.out.println("");
					adminHomePage();
					break;
				}
				break;
//			logout
			case 5 : 
				sc.close();
				System.out.println("------------------");
				System.out.println("Thank you for banking with BB Bank");
				log.end();
				break;
			default :
				System.out.println("Invalid command. Redirecting to homepage...");
				System.out.println("");
				adminHomePage();
				break;
			}
//			nested switch level 3 end (account transactions)
			break;
//		logout
		case 4 :
			sc.close();
			System.out.println("------------------");
			System.out.println("Thank you for banking with BB Bank");
			log.end();
			break;
		default : 
			System.out.println("Invalid command. Redirecting to homepage...");
			System.out.println("");
			adminHomePage();
			break;
		}
//		nested switch level 2 end (admin homepage)
		
	}
		
}
