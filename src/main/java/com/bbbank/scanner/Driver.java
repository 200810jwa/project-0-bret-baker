package com.bbbank.scanner;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int selectionInt;
		boolean auth;
		
		System.out.println("Welcome to BB Bank:");
		System.out.println("Enter 1 for Login / Enter 2 for Sign Up");
		selectionInt = sc.nextInt();
		
		switch(selectionInt) {
//		Login
			case 1 :
				System.out.println("Enter username");
				String username = sc.next();
//				System.out.println(username);
				System.out.println("Enter password");
				String password = sc.next();
//				System.out.println(password);
				
//				Login Success
				switch(auth) {
					case true :
					
						break;
					
				}
				
				break;
//		Sign Up
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
