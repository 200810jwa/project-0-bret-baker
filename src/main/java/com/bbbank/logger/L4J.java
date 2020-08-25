package com.bbbank.logger;

import org.apache.log4j.Logger;

public class L4J {
	
private static Logger log = Logger.getLogger(L4J.class);
	
	public void start() {
		log.info("The application has started");
	}
	
	public void end() {
		log.info("The application has ended");
	}
	
	public void deposit() {
		log.info("Deposit successful");
	}
	
	public void withdraw() {
		log.info("Withdrawal");
	}
	
	public void transfer() {
		log.info("Transfer successful");
	}
	
	public void login() {
		log.info("Login successful");
	}
	
	public void appSubmitted() {
		log.info("Application submitted");
	}
	
	public void appApproved() {
		log.info("Application approved");
	}
	
	public void appRejected() {
		log.info("Application rejected");
	}
	
	public void signup() {
		log.info("Sign up successful");
	}
	
	public void acctUpdated() {
		log.info("Account info updated");
	}
	
	public void cancel() {
		log.info("User account canceled");
	}

}
