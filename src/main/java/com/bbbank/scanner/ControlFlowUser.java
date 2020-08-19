package com.bbbank.scanner;

import java.util.Scanner;

public class ControlFlowUser {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void userViewBalances() {
		
	}

	public static void userHomePage() {
		System.out.println("------------------");
		System.out.println("-- User Homepage -");
		System.out.println("------------------");
		System.out.println("Enter 1 to View Balances / Enter 2 to View Account Information / Enter 3 to Logout");
		int selectionInt = sc.nextInt();
//	nested switch level 2 start (user homepage)
		switch (selectionInt) {
//	view balances
		case 1:
			double checking = 150.62;
			double savings = 302.76;
			System.out.println("Checking Balance: $" + checking + " / Savings Balance: $" + savings);
			System.out.println("------------------");
			System.out.println("Enter 1 to Make a Deposit / Enter 2 to Withdraw Funds / Enter 3 to Logout");
			selectionInt = sc.nextInt();
//			nested switch level 3 start (view balances)
			switch (selectionInt) {
//			deposit options
			case 1:
				System.out
						.println("Enter 1 to Deposit in Checking / Enter 2 to Deposit in Savings / Enter 3 to Logout");
				selectionInt = sc.nextInt();
//					nested switch level 4 start (deposit options)
				switch (selectionInt) {
//					deposit checking
				case 1:
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
//					deposit savings			
				case 2:
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
				case 3:
//					logout			
					sc.close();
					System.out.println("------------------");
					System.out.println("Thank you for banking with BB Bank");
					break;
				default:
					System.out.println("Error");
					break;
				}
//					nested switch level 4 end (deposit options)
				break;
//			withdraw options	
			case 2:
				System.out.println(
						"Enter 1 to Withdraw from Checking / Enter 2 to Withdraw from Savings / Enter 3 to Logout");
				selectionInt = sc.nextInt();
//					nested switch level 4 start (withdraw options)
				switch (selectionInt) {
//					withdraw checking
				case 1:
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
//					withdraw savings			
				case 2:
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
//					logout
				case 3:
					sc.close();
					System.out.println("------------------");
					System.out.println("Thank you for banking with BB Bank");
					break;
				default:
					System.out.println("Error");
					break;
				}
//					nested switch level 4 end (withdraw options)								
				break;
//			logout
			case 3:
				sc.close();
				System.out.println("------------------");
				System.out.println("Thank you for banking with BB Bank");
				break;
			default:
				System.out.println("Error");
				break;
			}
//		nested switch level 3 end (view balances)
			break;
//		view acct info
		case 2:
//		nested switch level 3 start (view acct info)
			String firstname = "tom";
			String lastname = "jones";
			String email = "tj@email.com";
			System.out.println("First name: " + firstname);
			System.out.println("Last name: " + lastname);
			System.out.println("Email: " + email);
			System.out.println("------------------");
			System.out.println("Enter 1 to Edit Account Info / Enter 2 to Logout");
			selectionInt = sc.nextInt();
//				nested switch level 4 start (edit acct info)
			switch (selectionInt) {
//				edit acct info
			case 1:
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
//				logout
			case 2:
				sc.close();
				System.out.println("------------------");
				System.out.println("Thank you for banking with BB Bank");
				break;
			default:
				System.out.println("Error");
				break;
//				nested switch level 4 end (edit acct info)
			}
			break;
//		logout
		case 3:
			sc.close();
			System.out.println("------------------");
			System.out.println("Thank you for banking with BB Bank");
			break;
		default:
			System.out.println("Error");
			break;
		}
//		nested switch level 3 start (view acct info)						
//	nested switch level 2 end (user homepage)
	}

}
