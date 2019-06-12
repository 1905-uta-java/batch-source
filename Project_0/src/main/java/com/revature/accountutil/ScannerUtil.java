package com.revature.accountutil;

import java.util.Scanner;

import com.revature.accountmodel.User;

// Class to handle input from the user
public class ScannerUtil {
	private static Scanner sc = new Scanner(System.in);
	private ValidateUtil validate = new ValidateUtil();
	private UserMenuUtil uMenu = new UserMenuUtil();
	private AccountMenuUtil aMenu = new AccountMenuUtil();
	
	/*
	 * The Menu will be the hub for user login and creation
	 *  - The user requests to login
	 *  - The user requests to create a user account
	 */
	public void menu() {
		String input = "";
		User u = null;
		System.out.println("Welcome to the Revature Banking App");
		// Menu loop
		while(!input.toUpperCase().equals("EXIT")) {
			System.out.println("\nTo login to an existing account enter LOGIN\nTo create a new account enter CREATE");
			System.out.println("If, at any time, you wish to exit, enter EXIT");
			input = sc.nextLine().toUpperCase();
			
			// Check which command was put in
			switch(input) {
			case "LOGIN":
				// Have the user log into a current account
				u = this.parseLogin();
				if(u != null) {
					this.userMenu(u);
				} else {
					System.out.println("Exiting, Goodbye");
					return;
				}
				break;
			case "CREATE":
				// Have the user create a new account and log in
				u = this.parseCreate();
				if(u != null) {
					this.userMenu(u);
				} else {
					System.out.println("Exiting, Goodbye");
					return;
				}
				break;
			case "EXIT":
				// Exit the program
				System.out.println("Exiting, Goodbye");
				break;
			default :
				// Tell the user they put in an invalid command
				System.out.println("Error: Invalid command entered");
				break;
			}
		}
	}
	
	// Validate user input for logging into a user
	public User parseLogin() {
		String uName = "";
		String pWord = "";
		String input = "";
		boolean pWordCorrect = false;
		while(uName == "") {
			System.out.print("\nPlease enter your Username: ");
			input = sc.nextLine();
			if(input.toUpperCase().equals("EXIT")) {
				return null;
			}
			
			if(validate.isUsername(input)) {
				uName = input;
			} else {
				System.out.println("Error: Username does not exist");
			}
		}
		while(pWord == "" && !pWordCorrect) {
			System.out.print("\nPlease enter your Password: ");
			input = sc.nextLine();
			if(input.toUpperCase().equals("EXIT")) {
				return null;
			}
			
			if(validate.correctPass(input, uName)) {
				pWord = input;
				pWordCorrect = true;
			} else {
				System.out.println("Error: Incorrect Password");
			}
		}
		
		return uMenu.login(uName, pWord);
	}
	
	// Validate user input for creating a user
	public User parseCreate() {
		String uName = "";
		String pWord = "";
		String eMail = "";
		String input = "";
		boolean newName = false;
		
		while (!newName) {
			System.out.print("\nPlease enter a Username: ");
			input = sc.nextLine();
			if(input.toUpperCase().equals("EXIT")) {
				return null;
			}
			
			if(!validate.isUsername(input) && input != "") {
				uName = input;
				newName = true;
			} else {
				System.out.println("Error: Username already exists, or is not a valid Username");
			}
		}
		
		while (pWord == "") {
			System.out.print("\nPlease enter a Password\nYour Password must be between 6 and 12 characters: ");
			input = sc.nextLine();
			if(input.toUpperCase().equals("EXIT")) {
				return null;
			}
			
			if(validate.isPassword(input)) {
				pWord = input;
			} else {
				System.out.println("Error: Password is invalid");
			}
		}
		
		while (eMail == "") {
			System.out.print("\nPlease enter a valid email address: ");
			input = sc.nextLine();
			if(input.toUpperCase().equals("EXIT")) {
				return null;
			}
	
			if(validate.isEmail(input)) {
				eMail = input;
			} else {
				System.out.println("Error: Email is invalid");
			}
		}
		
		return uMenu.createUser(uName, pWord, eMail);
	}
	
	/*
	 * From the User Menu the user will be able to perform actions with their bank account
	 *  - The user requests to create a bank account
	 *  - The user requests to deposit funds (Requires PIN)
	 *  - The user requests to withdraw funds (Requires PIN)
	 *  - The user requests to see their current balance (Requires PIN)
	 */
	public void userMenu(User u) {
		String input = "";
		// User Menu loop
		while(!input.toUpperCase().equals("EXIT")) {
			System.out.println("\nTo create a bank account please enter NEWACCOUNT" + 
					"\nTo deposit funds into an existing bank account please enter DEPOSIT" + 
					"\nTo withdraw funds from an existing bank account please enter WITHDRAW" + 
					"\nTo check the current balance of an existing bank account please enter BALANCE" + 
					"\nTo log out of your user account enter EXIT");
			input = sc.nextLine().toUpperCase();
			
			// Czech which command was put in
			switch(input) {
			case "NEWACCOUNT":
				// Have the user create a new bank account
				this.parseCreateAcc(u);
				break;
			case "DEPOSIT":
				// Have the user deposit funds into their bank account
				this.parseDeposit(u);
				break;
			case "WITHDRAW":
				// Have the user withdraw funds from their bank account
				this.parseWithdrawal(u);
				break;
			case "BALANCE":
				// Get the current balance of the user's bank account
				this.parseBalance(u);
				break;
			case "EXIT":
				// Exit the program
				System.out.println("Returning to Login Menu");
				return;
			default:
				// Tell the user the command they put in was invalid
				System.out.println("Error: Invalid command entered");
				break;
			}
		}
	}
	
	// Validate input for Account creation
	public void parseCreateAcc(User u) {
		int pin = -1;
		int isPin = -1;
		double balance = -1;
		String input = "";
		
		// Loop while asking the user to input a valid pin
		while (pin == -1) {
			System.out.print("\nPlease enter a valid 4 digit PIN: ");
			input = sc.nextLine();
			if(input.toUpperCase().equals("EXIT")) {
				return;
			}
			pin = validate.parsePin(input);
		}
		
		while (isPin == -1 && isPin != pin) {
			System.out.print("Please re-enter your PIN: ");
			input = sc.nextLine();
			if(input.toUpperCase().equals("EXIT")) {
				return;
			}
			isPin = validate.parsePin(input);
			
			if(isPin != pin) {
				System.out.println("Error: PIN is not the same as previously entered PIN");
			}
		}
		
		while (balance == -1) {
			System.out.print("\nPlease enter the amount of funds you would like to create the account with: $");
			input = sc.nextLine();
			if(input.toUpperCase().equals("EXIT")) {
				return;
			}
			balance = validate.parseAmount(input);
		}
		
		aMenu.createAccount(u, pin, balance);
	}
	
	// Validate input for a deposit
	public void parseDeposit(User u) {
		int pin = -1;
		String input = "";
		
		// Loop while asking the user to input a valid and correct pin
		while(pin == -1) {
			System.out.print("\nPlease enter your 4 digit PIN: ");
			input = sc.nextLine();
			if(input.toUpperCase() == "EXIT") {
				return;
			}
			pin = validate.parsePin(input);
			if(!aMenu.isCorrectPin(u, pin)) {
				System.out.println("Error: Incorrect PIN");
				pin = -1;
			}
		}
				
		// Loop while asking the user to input a valid number of funds
		double funds = -1;
		while (funds == -1) {
			System.out.print("\nPlease enter the amount of funds you would like to deposit: $");
			input = sc.nextLine();
			if(input.toUpperCase() == "EXIT") {
				return;
			}
			funds = validate.parseAmount(input);
		}
		
		aMenu.depositFunds(u, pin, funds);
	}
	
	// Validate input for a withdrawal
	public void parseWithdrawal(User u) {
		int pin = -1;
		String input = "";
		
		// Loop while asking the user to input a valid and correct pin
		while (pin == -1) {
			System.out.print("\nPlease enter your 4 digit PIN: ");
			input = sc.nextLine();
			if(input.toUpperCase().equals("EXIT")) {
				return;
			}
			pin = validate.parsePin(input);
			if(!aMenu.isCorrectPin(u, pin)) {
				System.out.println("Error: Incorrect PIN");
				pin = -1;
			}
		}
					
		// Loop while asking the user to input a valid number of funds
		double funds = -1;
		while (funds == -1) {
			System.out.print("\nPlease enter the amount of funds you would like to withdraw: $");
			input = sc.nextLine();
			if(input.toUpperCase().equals("EXIT")) {
				return;
			}
			funds = validate.parseAmount(input);
		}
		
		aMenu.withdrawFunds(u, pin, funds);
	}
	
	// Validate input for checking balance
	public void parseBalance(User u) {
		int pin = -1;
		String input = "";
		
		// Loop while asking the user to input a valid and correct pin
		while(pin == -1) {
			System.out.print("\nPlease enter your 4 digit PIN: ");
			input = sc.nextLine();
			if(input.toUpperCase().equals("EXIT")) {
				return;
			}
			
			pin = validate.parsePin(input);
			if(!aMenu.isCorrectPin(u, pin)) {
				System.out.println("Error: Incorrect PIN");
				pin = -1;
			}
		}
		
		aMenu.checkBalance(u, pin);
	}
}
