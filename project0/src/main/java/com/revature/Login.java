package com.revature;

import java.util.Scanner;

import com.revature.dao.*;
import com.revature.models.User;

public class Login {
	private UserDao usd;
	private Scanner sc;
	
	public Login(UserDao usd, Scanner sc) {
		this.usd = usd;
		this.sc = sc;
	}
	
	/*
	 * Checks the credentials the user has given
	 * */
	public void checkCreds() {
		int result;
		String username ="";
		String password = "";
		boolean usrExists = false;
		boolean correctPass = false;
		
		do {
			do {
				//USERNAME
				System.out.println("Username (-1: exit to home): " );
				username = sc.nextLine();				
				if(username.equals("-1")) break;
				
				//PASSWORD 
				System.out.println("Password: ");
				password = sc.nextLine();
				
				System.out.println("Attempting login...\n");
				result = loginService(username, password);
				
				if(result == -1) 
					System.out.println("Username does not exist");
				else if (result == -2) 
					System.out.println("Password is not correct");
				else if(result == 0) 
					System.out.println("Unknown error");
				else {
					loggedIn(username);
				}
			} while(!usrExists || !correctPass);
			if(username.equals("-1")) break; // not ideal...but hey it needs to be done
		} while(!username.equals("-1"));
	}
	
	/*
	 * Error checking of chkCreds
	 * */
	public int loginService(String username, String password) {
		boolean usrExists = usd.checkUsername(username);
		boolean correctPass = usd.checkPassword(username, password);
		
		if(usrExists && correctPass)
			return 1;
		
		if(!usrExists) //username does not exist in DB
			return -1;
		else if (!correctPass) // password is not correct 
			return -2;
		return 0; //unknown error, something is seriosuly messed up 
		
	}
	
	/*
	 * Initializes User and Bank objects so the user can work
	 * */
	private void loggedIn(String username) {
		System.out.println("Logging in...");
		
		User u = usd.getSingleUser(username);
		Bank b = new Bank(usd, u, sc);
		b.splash();
	}
}
