package com.revature.frontend;

import java.util.List;
import java.util.Scanner;

import com.revature.dao.AccountInfoDAO;
import com.revature.dao.AccountInfoDAOImpl;
import com.revature.dao.UniqueUserDAO;
import com.revature.dao.UniqueUserDAOImpl;

public class FrontEnd {


		public void init() {

			Scanner sc = new Scanner(System.in);

			String input = "", username = "", password = "";
			System.out.println("Welcome to a bank!");
			System.out.println("Type 'help' to get a list of commands or 'exit' to leave");
			input = sc.nextLine();
			while(!input.equals("exit")) {
			if(input.equals("help")){
				System.out.println("The list of commands are: 'login', 'exit', 'new user'");
				input = sc.nextLine();
			} else if(input.contentEquals("login")) {
				//prompt for username + password and update commands
				System.out.println("Enter your username");
				 username = sc.nextLine();
				System.out.println("Enter your password");
				 password = sc.nextLine();
				 login(username, password);
				 break;
			} else if(input.equals("new user")){
				//ask for username + password combo. also check if email is being used
				System.out.println("Enter a username");
				 username = sc.nextLine();
				 do {
				System.out.println("Enter a password that is longer than 8 characters");
				 password = sc.nextLine();}
				 while(password.length() < 8);
				 newUser(username, password);
				 break;
			} else if(input.equals("exit")){
				break;
			} else {
				System.out.println("Invalid command");
				input = sc.nextLine();
			}
			}
			//System.out.println("Good bye o/");
			
			
		}
		public void login(String username, String password) {
			Scanner sc = new Scanner(System.in);

			System.out.println("Logging you in...");
			UniqueUserDAO user = new UniqueUserDAOImpl();
			int userExists = user.checkCreds(username, password);
			if(userExists > 0) {
				System.out.println("Success!");
				//move on into login state commands
				System.out.println("List of commands: 'new profile', 'myprofile', 'open account', 'my balance', 'withdraw', 'deposit', 'logout'");
				String input = sc.nextLine();
				postLogin(userExists, input);
			} else { 
				System.out.println("Username and password not found");
				init(); }
		}
		public void postLogin(int id, String input) {
			Scanner sc = new Scanner(System.in);

			AccountInfoDAO acc = new AccountInfoDAOImpl();
			if(input.equals("my balance")) {
				int balance = acc.currentBalance(id);
				System.out.println("Your balance is: "+balance);
				System.out.println("Try our current supported commands: 'my balance', 'withdraw', 'deposit', 'logout'");
				input = sc.nextLine();
				postLogin(id, input);
			} else if(input.equals("withdraw")) {
				int balance = acc.currentBalance(id);
				System.out.println("Enter how much you want to withdraw in the format XX (only whole numbers)");
				String withdraw = sc.nextLine();
				//validate integer input here
				try {
				int delta = Integer.parseInt(withdraw);
				if(balance - delta >= 0) {
					balance = acc.withdraw(delta, id);
					if(balance < 0) {System.out.println("An error has occurred"); 
					} else { 	
						System.out.println("Withdraw success, your new balance is: "+balance); 
						System.out.println("Try our current supported commands: 'my balance', 'withdraw', 'deposit', 'logout'");
						input = sc.nextLine();
						postLogin(id, input);}

					} else {
						System.out.println("Insufficient funds");
						System.out.println("Try our current supported commands: 'my balance', 'withdraw', 'deposit', 'logout'");
						input = sc.nextLine();
						postLogin(id, input);
					}
				}
				catch (NumberFormatException e) {
					System.out.println("Invalid input!");
					postLogin(id, input);
				}
				
			} else if(input.equals("deposit")) {
				System.out.println("Enter how much you want to deposit in the format XX (only whole numbers)");
				String depo = sc.nextLine();
				//validate integer input here
				try {
				int deposit = Integer.parseInt(depo);
				int balance = acc.deposit(deposit, id);
				if(balance >= 0) {
					System.out.println("Deposit success, your new balance is: "+balance);
					System.out.println("Try our current supported commands: 'my balance', 'withdraw', 'deposit', 'logout'");
					input = sc.nextLine();
					postLogin(id, input);
				} else { System.out.println("An error has occured"); }
				} catch (NumberFormatException e) {
					System.out.println("Invalid input!");
					postLogin(id, input);
				}
				
			} else if(input.equals("logout")) {
				System.out.println("Logging you out...");
				init();
			} else {
				System.out.println("Unsupported command, extra features coming soon.");
				System.out.println("Try our current supported commands: 'my balance', 'withdraw', 'deposit', 'logout'");
				input = sc.nextLine();
				postLogin(id, input);
			}
		}
		
		public  void newUser(String username, String password) {
			UniqueUserDAO user = new UniqueUserDAOImpl();
			List<String> userExists = user.getAllUserNames();
			if(!userExists.contains((String)username)) {
				System.out.println("Creating a new user...");
				boolean success = user.createUser(username, password);
				if(success) {
					System.out.println("Congratulations! You are now a registered user of a bank. Login to access your new account.");
				}
			} else {
				System.out.println("User already exists");
			}
			init();
		}

}

