package com.revature;

import java.util.Scanner;

import com.revature.dao.UserDao;
import com.revature.models.User;

public class Create {
	UserDao usr;
	Scanner sc;
	
	public Create(UserDao usr, Scanner sc) {
		this.usr = usr;
		this.sc = sc;
	}
	
	public void createAccount() {
		boolean usrExists = false;
		String username = "";
		String password = "";
		String firstName = "";
		String lastName = "";
		String email = "";
		String in = "";
		int success;
		
		do {
			if(usrExists) {
				System.out.println("Username " + username + " already exists. Pick another username. ");
			}
			
			System.out.println("Pick a username: ");
			username = sc.nextLine();
			usrExists = checkUsername(username);
			
		} while(usrExists);
		
		System.out.println("Pick a password: ");
		password = sc.nextLine();

		System.out.println("Enter your first name: ");
		firstName = sc.nextLine();
		
		System.out.println("Enter your last name: ");
		lastName = sc.nextLine();
		
		System.out.println("Enter your email: ");
		email = sc.nextLine();
		
		System.out.println("Creating account...");
		
		System.out.println("New Account Number: " + usr.getNewAccNum());
		
		success = createService(username, password, firstName, lastName, email);
		
		if(success > 0) {
			System.out.println("Account created successfully! Would you like to log in? [Y]es or [N]o: ");
			in = sc.nextLine().toUpperCase();
			
			do {
				if(in.equals("Y")){
					Login login = new Login(usr, sc);
					login.checkCreds();
				} else if (in.equals("N") || in.equals("NO")){
					continue;
				}
				else {
					System.out.println("Invalid input. Try again");
				}				
			} while (!in.equals("Y"));
		} else 
			System.out.println("Error when creating account, maybe there's no access to DB?");
	}
	
	
	public int createService(String username, String password, String firstName, String lastName, String email) {
		User usr1 = new User(usr.getNewAccNum(), username, password, email, firstName, lastName);
		return usr.createUser(usr1);
	}
	
	public boolean checkUsername(String username) {
		return usr.checkUsername(username);				
	}
	
}
