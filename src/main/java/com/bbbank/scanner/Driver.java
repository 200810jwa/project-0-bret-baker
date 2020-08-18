package com.bbbank.scanner;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int selectionInt;
		int role;
		
		System.out.println("Welcome to BB Bank:");
		System.out.println("Enter 1 for Login / Enter 2 for Sign Up");
		selectionInt = sc.nextInt();
		
//		switch level 0
		switch(selectionInt) {
//		login
			case 1 :
				System.out.println("Enter Username");
				String username = sc.next();
//				System.out.println(username);
//				check db for username, proceed if true, request re-entry if false
				System.out.println("Enter Password");
				String password = sc.next();
//				System.out.println(password);
//				check db for password, proceed if true, request re-entry if false
				
//				if correct credentials entered, get role for db and serve appropriate "homepage"
//				forced role of user below for development
				role = 1;
				
//				nested switch level 1
				switch(role) {
//				user
					case 1 :
						System.out.println("Enter 1 to View Balances / Enter 2 to View Account Information / Enter 3 to Logout");
						selectionInt = sc.nextInt();
//						System.out.println(selectionInt);
						
//					nested switch level 2
						
						switch(selectionInt) {
//						view balances
							case 1 :
								break;
//						view acct info
							case 2 :
								break;
//						logout
							case 3 :
								break;
							default :
								System.out.println("Error");
						}
						
						break;
					case 2 :
						break;
					default :
						System.out.println("Error");
				}
				
				break;
				
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
