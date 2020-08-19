package com.bbbank.scanner;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int selectionInt;
		int role;
		
		System.out.println("Welcome to BB Bank");
		System.out.println("------------------");
		System.out.println("Enter 1 for Login / Enter 2 for Sign Up");
		selectionInt = sc.nextInt();
		
//		switch level 0 start (login)
		switch(selectionInt) {
//		login
			case 1 :
				System.out.println("Enter Username");
				String username = sc.next();
//				check db for username, proceed if true, request re-entry if false
				System.out.println("Enter Password");
				String password = sc.next();
//				check db for password, proceed if true, request re-entry if false
				
//				if correct credentials entered, get role for db and serve appropriate homepage
//				forced role of user for development
				role = 2;
				
//			nested switch level 1 start (role)
				switch(role) {
//				user homepage
					case 1 :
						System.out.println("Enter 1 to View Balances / Enter 2 to View Account Information / Enter 3 to Logout");
						selectionInt = sc.nextInt();						
//					nested switch level 2 start (user homepage)
						switch(selectionInt) {
//					view balances
							case 1 :
								double checking = 150.62;
								double savings = 302.76;
								System.out.println("Checking Balance: $" + checking + " / Savings Balance: $" + savings);
								System.out.println("------------------");
								System.out.println("Enter 1 to Make a Deposit / Enter 2 to Withdraw Funds / Enter 3 to Logout");
								selectionInt = sc.nextInt();								
//							nested switch level 3 start (view balances)
								switch(selectionInt) {
//							deposit options
									case 1 :
										System.out.println("Enter 1 to Deposit in Checking / Enter 2 to Deposit in Savings / Enter 3 to Logout");
										selectionInt = sc.nextInt();									
//									nested switch level 4 start (deposit options)
										switch(selectionInt) {
//									deposit checking
											case 1 :
												System.out.println("Enter amount you wish to Deposit");
												System.out.println("(Amount will round to 2 decimal places / Max Deposit = $1,000.00)");
												double deposit = sc.nextDouble();
												System.out.println("Success: $" + deposit + " was added to your Checking account.");
												double newBalance = checking + deposit;
												System.out.println("------------------");
												System.out.println("You have a new Checking balance of $" + newBalance);
												sc.close();
												System.out.println("------------------");
												System.out.println("Thank you for banking with BB Bank");
												break;
//									deposit savings			
											case 2 :
												System.out.println("Enter amount you wish to Deposit");
												System.out.println("(Amount will round to 2 decimal places / Max Deposit = $1,000.00)");
												double deposit2 = sc.nextDouble();
												System.out.println("Success: $" + deposit2 + " was added to your Savings account.");
												double newBalance2 = savings + deposit2;
												System.out.println("------------------");
												System.out.println("You have a new Savings balance of $" + newBalance2);
												sc.close();
												System.out.println("------------------");
												System.out.println("Thank you for banking with BB Bank");
												break;
											case 3 :
//									logout			
												sc.close();
												System.out.println("------------------");
												System.out.println("Thank you for banking with BB Bank");
												break;
											default :
												System.out.println("Error");
												break;
										}		
//									nested switch level 4 end (deposit options)
										break;
//							withdraw options	
									case 2 : 
										System.out.println("Enter 1 to Withdraw from Checking / Enter 2 to Withdraw from Savings / Enter 3 to Logout");
										selectionInt = sc.nextInt();
//									nested switch level 4 start (withdraw options)
										switch(selectionInt) {
//									withdraw checking
											case 1 :
												System.out.println("Enter amount you wish to Withdraw");
												System.out.println("(Amount will round to 2 decimal places / Max Amount = Account Balance)");
												double withdraw = sc.nextDouble();
												System.out.println("Success: $" + withdraw + " was withdrawn from your Checking account.");
												double newBalance = checking - withdraw;
												System.out.println("------------------");
												System.out.println("You have a new Checking balance of $" + newBalance);
												sc.close();
												System.out.println("------------------");
												System.out.println("Thank you for banking with BB Bank");
												break;
//									withdraw savings			
											case 2 :
												System.out.println("Enter amount you wish to Withdraw");
												System.out.println("(Amount will round to 2 decimal places / Max Amount = Account Balance)");
												double withdraw2 = sc.nextDouble();
												System.out.println("Success: $" + withdraw2 + " was withdrawn from your Savings account.");
												double newBalance2 = savings - withdraw2;
												System.out.println("------------------");
												System.out.println("You have a new Savings balance of $" + newBalance2);
												sc.close();
												System.out.println("------------------");
												System.out.println("Thank you for banking with BB Bank");
												break;
//									logout
											case 3 :			
												sc.close();
												System.out.println("------------------");
												System.out.println("Thank you for banking with BB Bank");
												break;
											default :
												System.out.println("Error");
												break;
										}		
//									nested switch level 4 end (withdraw options)								
										break;
//							logout
									case 3 :
										sc.close();
										System.out.println("------------------");
										System.out.println("Thank you for banking with BB Bank");
										break;
									default : 
										System.out.println("Error");
										break;
								}
//						nested switch level 3 end (view balances)
								break;
//						view acct info
							case 2 :
//						nested switch level 3 start (view acct info)
								String firstname = "tom";
								String lastname = "jones";
								String email = "tj@email.com";
								System.out.println("First name: " + firstname);
								System.out.println("Last name: " + lastname);
								System.out.println("Email: " + email);
								System.out.println("------------------");
								System.out.println("Enter 1 to Edit Account Info / Enter 2 to Logout");
								selectionInt = sc.nextInt();
//								nested switch level 4 start (edit acct info)
								switch(selectionInt) {
//								edit acct info
									case 1 :
										System.out.println("Enter first name:");
										String firstname1 = sc.next();
										System.out.println("Enter last name:");
										String lastname1 = sc.next();
										System.out.println("Enter email:");
										String email1 = sc.next();
										System.out.println("Success: New Account Info:");
										System.out.println("First name: " + firstname1);
										System.out.println("Last name: " + lastname1);
										System.out.println("Email: " + email1);
										sc.close();
										System.out.println("------------------");
										System.out.println("Thank you for banking with BB Bank");
										break;
//								logout
									case 2 :
										sc.close();
										System.out.println("------------------");
										System.out.println("Thank you for banking with BB Bank");
										break;
									default : 
										System.out.println("Error");
										break;
//								nested switch level 4 end (edit acct info)
								}
								break;
//						logout
							case 3 :
								sc.close();
								System.out.println("------------------");
								System.out.println("Thank you for banking with BB Bank");
								break;
							default :
								System.out.println("Error");
						}
//						nested switch level 3 start (view acct info)						
						break;
//					nested switch level 2 end (user homepage)
//				nested switch level 1 continue (role)
//					admin homepage
					case 2 :
						System.out.println("Enter 1 for Applications / Enter 2 for User Info / Enter 3 for Account Transactions / Enter 4 to Logout");
						selectionInt = sc.nextInt();
//						nested switch level 2 start (admin homepage)
						switch(selectionInt) {
//						applications
						case 1 :
//							check db for open apps, if true, list for admin, if false provide msg stating no open apps
							System.out.println("------------------");
							System.out.println("Enter username from list above to view application");
							String userapp = sc.next();
							System.out.println(userapp);
//							get application data from db and display for admin
							System.out.println("User firstname");
							System.out.println("User lastname");
							System.out.println("User email");
							System.out.println("User credit score");
							System.out.println("User annual income");
							System.out.println("------------------");
							System.out.println("Enter 1 to Approve / Enter 2 to Reject / Enter 3 to Logout");
							selectionInt = sc.nextInt();
//							nested switch level 3 start (open applications)
							switch(selectionInt) {
							case 1 :
//								send data to user table, starting balances $0
								System.out.println("Approved. User added to system.");
								break;
							case 2 :
//								delete from applications table
								System.out.println("Success. Application denied. Data deleted.");
								break;
							case 3 :
								sc.close();
								System.out.println("------------------");
								System.out.println("Thank you for banking with BB Bank");
								break;
							default : 
								System.out.println("Error");
								break;
							}
//							nested switch level 3 end (open applications)
							break;
//						user accounts
						case 2 :
							System.out.println("Enter username for account information");
							String username1 = sc.next();
							System.out.println(username1);
							System.out.println("User account info...");
							break;
//						account transactions
						case 3 :
							System.out.println("Enter 1 for Deposit / Enter 2 for Withdrawal / Enter 3 for Transfer / Enter 4 for Cancellation / Enter 5 to Logout");
							selectionInt = sc.nextInt();
//							nested switch level 3 start (account transactions)
							switch(selectionInt) {
//							admin deposit
							case 1 :
								System.out.println("Enter username for account to Deposit");
								String username2 = sc.next();
								System.out.println(username2);
								System.out.println("Checking Balance: $100.00 / Savings Balance: $200.00");
								System.out.println("Enter 1 to Deposit in Checking / Enter 2 to Deposit in Savings");
								selectionInt = sc.nextInt();
//								nested switch level 4 start (admin deposit)
								switch(selectionInt) {
								case 1 :
									System.out.println("Enter amount to Deposit in Checking");
									double deposit1 = sc.nextDouble();
									System.out.println("Success: $" + deposit1 + " deposited in Checking");
									break;
								case 2 :
									System.out.println("Enter amount to Deposit in Savings");
									double deposit2 = sc.nextDouble();
									System.out.println("Success: $" + deposit2 + " deposited in Savings");
									break;
								default :
									System.out.println("error");
									break;
								}
//								nested switch level 4 end (admin deposit)
								break;
//							admin withdrawal
							case 2 :
								System.out.println("Enter username for account to Withdraw");
								String username3 = sc.next();
								System.out.println(username3);
								System.out.println("Checking Balance: $100.00 / Savings Balance: $200.00");
								System.out.println("Enter 1 to Withdraw from Checking / Enter 2 to Withdraw from Savings");
								selectionInt = sc.nextInt();
//								nested switch level 4 start (admin withdrawal)
								switch(selectionInt) {
								case 1 :
									System.out.println("Enter amount to Withdraw from Checking");
									double withdraw1 = sc.nextDouble();
									System.out.println("Success: $" + withdraw1 + " withdrawn from Checking");
									break;
								case 2 :
									System.out.println("Enter amount to Withdraw from Savings");
									double withdraw2 = sc.nextDouble();
									System.out.println("Success: $" + withdraw2 + " withdrawn from Savings");
									break;
								default :
									System.out.println("error");
									break;
								}
//								nested switch level 4 end (admin withdrawal)
								break;
//							admin transfer
							case 3 :
								System.out.println("Enter username of account to Transfer from");
								String username4 = sc.next();
//								check db for user and get balances
								System.out.println("Account Balances for: " + username4);
								System.out.println("Checking Balance: $100.00 / Savings Balance: $200.00");
								System.out.println("Enter 1 to Transfer from Checking / Enter 2 to Transfer from Savings");
								selectionInt = sc.nextInt();
//								nested switch level 4 start (admin transfer)
								switch(selectionInt) {
//									transfer from checking
									case 1: 
										System.out.println("Enter username of account to Transfer to");
										String username5 = sc.next();
//										check db for user and get balances
										System.out.println("Account Balances for: " + username5);
										System.out.println("Checking Balance: $100.00 / Savings Balance: $200.00");
										System.out.println("Enter 1 to Transfer to Checking / Enter 2 to Transfer to Savings");
										selectionInt = sc.nextInt();
//										nested switch level 5 start (admin transfer from checking)
										switch(selectionInt) {
//											transfer to checking
											case 1 :
												System.out.println("Enter amount to transfer");
												double transfer = sc.nextDouble();
												System.out.println("Success. Amount transferred: $" + transfer);
												System.out.println("New balances for user1");
												System.out.println("Checking Balance: $100.00 / Savings Balance: $200.00");
												System.out.println("New balances for user2");
												System.out.println("Checking Balance: $100.00 / Savings Balance: $200.00");
												break;
//											transfer to savings
											case 2 :
												System.out.println("Enter amount to transfer");
												double transfer1 = sc.nextDouble();
												System.out.println("Success. Amount transferred: $" + transfer1);
												System.out.println("New balances for user1");
												System.out.println("Checking Balance: $100.00 / Savings Balance: $200.00");
												System.out.println("New balances for user2");
												System.out.println("Checking Balance: $100.00 / Savings Balance: $200.00");
												break;
											default :
												System.out.println("error");
												break;
										}
//										nested switch level 5 end (admin transfer from checking)
										break;
//									transfer from savings
									case 2 :
										System.out.println("Enter username of account to Transfer to");
										String username6 = sc.next();
//										check db for user and get balances
										System.out.println("Account Balances for: " + username6);
										System.out.println("Checking Balance: $100.00 / Savings Balance: $200.00");
										System.out.println("Enter 1 to Transfer to Checking / Enter 2 to Transfer to Savings");
										selectionInt = sc.nextInt();
//										nested switch level 5 start (admin transfer from savings)
										switch(selectionInt) {
//											transfer to checking
											case 1 :
												System.out.println("Enter amount to transfer");
												double transfer = sc.nextDouble();
												System.out.println("Success. Amount transferred: $" + transfer);
												System.out.println("New balances for user1");
												System.out.println("Checking Balance: $100.00 / Savings Balance: $200.00");
												System.out.println("New balances for user2");
												System.out.println("Checking Balance: $100.00 / Savings Balance: $200.00");
												break;
//											transfer to savings
											case 2 :
												System.out.println("Enter amount to transfer");
												double transfer1 = sc.nextDouble();
												System.out.println("Success. Amount transferred: $" + transfer1);
												System.out.println("New balances for user1");
												System.out.println("Checking Balance: $100.00 / Savings Balance: $200.00");
												System.out.println("New balances for user2");
												System.out.println("Checking Balance: $100.00 / Savings Balance: $200.00");
												break;
											default :
												System.out.println("error");
												break;
										}
//										nested switch level 5 end (admin transfer from savings)
										break;
									default :
										System.out.println("error");
										break;
								}
//								nested switch level 4 end (admin transfer)
								break;
//							cancel account
							case 4 :
								break;
//							logout
							case 5 : 
								sc.close();
								System.out.println("------------------");
								System.out.println("Thank you for banking with BB Bank");
								break;
							default :
								System.out.println("Error");
								break;
							}
//							nested switch level 3 end (account transactions)
							break;
//						logout
						case 4 :
							sc.close();
							System.out.println("------------------");
							System.out.println("Thank you for banking with BB Bank");
							break;
						default : 
							System.out.println("Error");
							break;
						}
//						nested switch level 2 end (admin homepage)
						break;
					default :
						System.out.println("Error");
						break;
				}
				break;
//			nested switch level 1 end (role)
//		switch level 0 continue (sign up)				
//		sign up
			case 2 :
				System.out.println("Enter First name");
				String firstname = sc.next();
				System.out.println(firstname);
				System.out.println("Enter Last name");
				String lastname = sc.next();
				System.out.println(lastname);
				System.out.println("Enter email");
				String email = sc.next();
				System.out.println(email);
				System.out.println("Enter 1 for User / Enter 2 for Admin");
				selectionInt = sc.nextInt();
				System.out.println(selectionInt);
				break;
			default :
				System.out.println("Error");
		}
		
		
	}

}
