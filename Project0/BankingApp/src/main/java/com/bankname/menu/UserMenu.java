package com.bankname.menu;

import java.util.List;
import java.util.Scanner;

import com.bankname.dao.AccountDao;
import com.bankname.dao.AccountDaoImpl;
import com.bankname.dao.BankUserDao;
import com.bankname.dao.BankUserDaoImpl;
import com.bankname.model.Account;
import com.bankname.model.BankUser;
import com.bankname.util.PasswordEncryptionUtil;

import com.bankname.util.ValidationUtil;

public class UserMenu {
	
	private static Scanner sc = new Scanner(System.in);
	private BankUserDao ud = new BankUserDaoImpl();
	private AccountDao ad = new AccountDaoImpl();
	
	
	public UserMenu() {
		super();
	}
	
	
	//LoginMenu
	public void loginCreateOptionMenu() {
		System.out.println("\nWelcome to BankName!");
		System.out.println("1)Login \n2)Create an Login \n3)Exit");
		System.out.println("Please select an option:");
		
		//Get user input
		String option = sc.nextLine();
		
		//Check if the input is valid option
		while(!validLoginCreateOption(option.trim())) {

			System.out.println("\nInvalid Selection. Pick either 1, 2, or 3");
			System.out.println("1)Login \n2)Create a Login \n3)Exit");
			System.out.println("Please select an option:");
			
			//Get user input
			option = sc.nextLine();
		}
		
		//Select correct option dependent on input
		switch(option){
		case "1":
			//Login to user
			userLoginMenu();
			break;
			
		case "2":
			//Create a Login
			createUser();
			break;
		case "3":
			//Exit
			return;
		}
		
		
	}
	
	//Login Menu for the user to enter in password and email
	public void userLoginMenu() {
		
		
		//Get an email
		System.out.println("\nPlease enter in your email address or press enter to return to main menu: ");
		String email = sc.nextLine();
		email = email.toLowerCase();
		
		//While statement to check that its a validEmail
		while(!ValidationUtil.verifyEmail(email) || email.equals("")) {
			//Invalid email was entered
			System.out.println("\nAn account for that email does not exist.");
			System.out.println("Please enter in your email address: ");
			email = sc.nextLine();
			email = email.toLowerCase();
		}
		
		//Checks if the user wanted to return to main menu
		if(email.equals("")) {
			loginCreateOptionMenu();
		}
		
		//Get a password
		System.out.println("\nPlease enter the password for " + email + " or press enter to return to main menu: ");
		String password = sc.nextLine();
		
		//While statement to get the validity of the password
		while(!ValidationUtil.verifyPassword(email, password) || password.equals("")) {
			System.out.println("\nInvalid password for "+ email);
			System.out.println("Please enter the password for " + email + " or press enter to return to main menu: ");
			password = sc.nextLine();
			
		}
		
		//Checks if the user wanted to return to main menu
		if(password.equals("")) {
			loginCreateOptionMenu();
		}
		
		userOptionsMenu(email, password);
		
	}
	
	//Create a new user account with email and password
	public void createUser() {
		
		//Get the users email address
		System.out.println("\nEnter your email address: ");
		String email = sc.nextLine();
		email = email.toLowerCase();
		
		//Check if the email given already exists or if its an invalid email
		while((ValidationUtil.verifyEmail(email) == true && ValidationUtil.validEmail(email) == false)) {
			if(ValidationUtil.verifyEmail(email)){
				System.out.println("\nThat email already exists");
			}else if(!ValidationUtil.validEmail(email)) {
				System.out.println("\nInvalid Email.");
			}
			
			//Get the users email address
			System.out.println("Enter your email address: ");
			email = sc.nextLine();
			email = email.toLowerCase();
		}
		
		//Check if the user wanted to exit
		if(email.equals("")) {
			//System.out.println("Exiting User Creation\n");
			loginCreateOptionMenu();
		}
		
		//Get password from user
		String password = getPasswordEntry();
		
		//Check to see if they want to exit
		if(password.equals("")) {
			//System.out.println("Exiting User Creation\n");
			loginCreateOptionMenu();
		}
		
		//Get the next unique userID
		int uID = ud.getNextBankUserID();
		
		//Hash password to store in the table
		String hashPassword = PasswordEncryptionUtil.encryptPassword(password);
		
		//Create the new banking user
		BankUser b = new BankUser(uID,email,hashPassword);
		
		//Create account in database
		ud.createBankUser(b);
		
		System.out.println("Account Created");
		
		loginCreateOptionMenu();
	}
	
	//Select an Account
	private Account getAccountSelection(BankUser bu) {
		
		//Get the accounts of the user
		List<Account> userAccounts = ad.getAccountsByUserID(bu.getUserID());
				
		//Selected Account
		Account selcAcct = null;
						
		//Check if the list is empty, meaning the user has no active accounts
		if(userAccounts.size() == 0) {
			System.out.println("\nYou currently do not have any open accounts.");
			return null;
		}
				
		//Counter for position in list
		int count = 1;
		//Display all account balances
		for(Account a : userAccounts){
			System.out.println(count+") "+ a.getAcctType()+" Account: "+a.getAcctNumber());
			count++;
		}
				
		System.out.println("\nSelect an Account from 1-"+(count-1)+". (Use 0 to exit)");
		String option = sc.nextLine();
				
		//While loop for if option doesn't equal a valid option
		while(!validAcctOption(count-1, option)) {
			System.out.println("\nInvalid Account Selected.");
			System.out.println("Select an Account from 1-"+(count-1)+". (Use 0 to exit)");
			option = sc.nextLine();
		}
				
		//Check if the user wants to exit
		if(option.equals("0")) {
			return null;
		}
				
		//Loop to determine which account was selected
		for(Account a : userAccounts) {
			//If the option selected is equal to the index + 1
			if(Integer.toString(userAccounts.indexOf(a) + 1).equals(option)) {
				selcAcct = a;
			}
		}
				
		//Returned the selected account
		return selcAcct;
				
		
	}
	
	//User options after they login.
	private void userOptionsMenu(String email, String password) {
		
		//Get the BankUserObject of correct user using email and password
		BankUser bUser = ud.getBankUserByEmail(email);
		
		String option = " ";
		
		//While loop to wait till the user logs out
		while(!option.equals("")) {
			System.out.println("\nSelect an option: ");
			System.out.println("1)View Balance(s) \n2)Withdraw Money \n3)Deposit Money \n4)Open a New Account \n5)Close an Account \n6)Logout");
			option = sc.nextLine();
			
			//Verify the selection
			if(!validUserOption(option)) {
				//Invalid option
				System.out.println("Invalid Option.");
			}else {
				//A valid option was entered
				
				switch(option) {
				case "1":
					//Display the balance
					displayUserBalance(bUser);
					break;
				case "2":
					//Withdraw Money
					withdrawFromAccount(bUser);
					break;
				case "3":
					//Deposit Money
					depositToAccount(bUser);
					break;
				case "4":
					//Open New Account
					openNewAccount(bUser);
					break;
				case "5":
					//Close an Account
					closeAccount(bUser);
					break;
				case "6":
					//Logout
					option = "";
					break;
				}
			}
		}
		
		System.out.println("Account Logged Out.\n");
		loginCreateOptionMenu();
		
	}
	
	//Close an Account with the bank
	private void closeAccount(BankUser bu) {
		//Selected Account
		Account selcAcct = getAccountSelection(bu);
						
		//Check if the user wants to exit
		if(selcAcct == null) {
			//System.out.println("Exiting Closing an Account");
			return;
		}
		
		//Verify the user wants to delete the account
		System.out.println("\nAre you sure you want to delete "+selcAcct.getAcctType() +" Account " + selcAcct.getAcctNumber()+ " (Y/N)");
		String option = sc.nextLine();
		option = option.toUpperCase();
		
		//Verify they selected one of the two options
		while(!option.equals("Y") && !option.equals("N")) {
			System.out.println("\nInvalid Option");
			System.out.println("Are you sure you want to delete "+selcAcct.getAcctType() +" Account " + selcAcct.getAcctNumber()+ " (Y/N)");
			option = sc.nextLine();
			option = option.toUpperCase();
		}
		
		//Determine which action based on selected option
		switch(option) {
		case "Y":
			ad.deleteAccount(selcAcct.getAcctNumber());
			System.out.println("\nAccount "+selcAcct.getAcctNumber()+" Deleted.");
			break;
			
		case "N":
			System.out.println("\nAccount Not Deleted");
			return;
		}
		
	}
	
	//Open a new account with the bank
	private void openNewAccount(BankUser bu) {
		String type = "";
		
		//Get account Type from user
		System.out.println("\nWhat kind of account would you like to open?");
		System.out.println("1)Checking \n2)Savings \n3)Exit");
		String option = sc.nextLine();
		
		//Validate the Option
		while(!option.equals("1") && !option.equals("2") && !option.equals("3")) {
			System.out.println("\nInvalid Option.");
			System.out.println("What kind of account would you like to open?");
			System.out.println("1)Checking \n2)Savings \n3)Exit");
			option = sc.nextLine();
		}
		
		//Determine which option was picked
		switch(option) {
		case "1":
			type = "Checking";
			break;
			
		case "2":
			type = "Savings";
			break;
			
		case "3":
			//System.out.println("Exiting Creating an Account");
			return;
		}
		
		//Get the next unique account number
		int acctNumber = ad.getNextAccountNumber();
		
		//Create a new account object
		Account newAcct = new Account(acctNumber, type, 0, bu.getUserID());
		
		//Create the new account to the table
		ad.createAccount(newAcct);
		
		System.out.println("\nNew Account Created.");
		System.out.println(newAcct.getAcctType() + " Account Number: "+newAcct.getAcctNumber());
	}
	
	//Display User Balance
	private void displayUserBalance(BankUser bu) {
		//Get the accounts of the user
		List<Account> userAccounts = ad.getAccountsByUserID(bu.getUserID());
		
		//Check if the list is empty, meaning the user has no active accounts
		if(userAccounts.size() == 0) {
			System.out.println("\nYou currently do not have any open accounts.\n");
			return;
		}
		
		System.out.println("");
		//Display all the balances of each account
		for(Account a : userAccounts){
			System.out.println(a.getAcctType()+" Account: "+a.getAcctNumber()+"     Balance: "+a.getBalance());
		}
		
	}
	
	//Withdraw money from an account
	private void withdrawFromAccount(BankUser bu) {
		//Selected Account
		Account selcAcct = getAccountSelection(bu);
				
		//Check if the user wants to exit
		if(selcAcct == null) {
			//System.out.println("Exiting account withdrawing");
			return;
		}
		
		//Display the selected accounts balance 
		System.out.println("\nSelected "+ selcAcct.getAcctType() +" Account: "+selcAcct.getAcctNumber() + "     Balance: "+selcAcct.getBalance());
		
		//Get user withdraw amount
		System.out.println("How much would you like to withdraw: ");
		String amount = sc.nextLine();
		
		//Validate the user entered amount
		while(!ValidationUtil.validWithdrawAmount(amount, selcAcct.getBalance())) {
			System.out.println("\nInvalid Amount.");
			System.out.println("How much would you like to withdraw: ");
			amount = sc.nextLine();
		}
		
		double amt = Double.parseDouble(amount);
		
		selcAcct.withdraw(amt);
		
		//Update the database
		ad.updateAccount(selcAcct);
		
		//Display new balance
		System.out.println("\n"+amount+" Successfully Withdrawn.");
		System.out.println("Selected "+ selcAcct.getAcctType() +" Account: "+selcAcct.getAcctNumber() + "     Balance: "+selcAcct.getBalance());
	}
	
	//Deposit money into an account
	private void depositToAccount(BankUser bu) {
		//Selected Account
		Account selcAcct = getAccountSelection(bu);
						
		//Check if the user wants to exit
		if(selcAcct == null) {
			//System.out.println("Exiting account depositing");
			return;
		}
		
		//Display the selected accounts balance 
		System.out.println("\nSelected "+ selcAcct.getAcctType() +" Account: "+selcAcct.getAcctNumber() + "     Balance: "+selcAcct.getBalance());
		
		//Get user deposit amount
		System.out.println("How much would you like to deposit: ");
		String amount = sc.nextLine();
		
		//Validate the user entered amount
		while(!ValidationUtil.validDepositAmount(amount)) {
			System.out.println("\nInvalid Amount.");
			System.out.println("How much would you like to deposit: ");
			amount = sc.nextLine();
		}
		
		double amt = Double.parseDouble(amount);
		
		selcAcct.deposit(amt);
		
		//Update the database
		ad.updateAccount(selcAcct);
		
		//Display new balance
		System.out.println("\n"+amount+" Successfully Deposited.");
		System.out.println("Selected "+ selcAcct.getAcctType() +" Account: "+selcAcct.getAcctNumber() + "     Balance: "+selcAcct.getBalance());
	}
	
	//Requests a password from user then asks them to re-enter it.
	private String getPasswordEntry() {
		
		//Get a password from the user
		System.out.println("\nPlease Enter Password: ");
		String password = sc.nextLine();
				
		//Verify the password is valid
		while(!ValidationUtil.validPassword(password) && !password.equals("")) {
			System.out.println("\nInvalid Password");
			System.out.println("Please Enter Password or enter nothing to exit: ");
			password = sc.nextLine();
		}
		
		//Check if password is blank to exit
		if(password.equals("")) {
			return "";
		}
				
		//Have user reenter password
		System.out.println("\nRe-Enter password: ");
		String rePassword = sc.nextLine();
			
		//If rePassword doesn't match then have them reselect password.
		if(!rePassword.equals(password)) {
			System.out.println("\nYour inputs did not match.");
			return getPasswordEntry();
		}
		
		return password;
	}
	
	//Validate Account Option Selection
	private boolean validAcctOption(int count, String option) {
		//Check if a valid number was typed from 0 to count
		
		//First convert option to a number
		int numOption;
		try {
			numOption = Integer.parseInt(option);
		}catch(NumberFormatException | NullPointerException nfe) {
			return false;
		}
		
		//Check if the option is between 0 and count
		if(numOption >= 0 && numOption <=count) {
			return true;
		}else {
			return false;
		}
	}
	
	//Verify Options for Login
	private boolean validLoginCreateOption(String option) {
		//Options must be 1,2,3
		if(!option.equals("1") && !option.equals("2") && !option.equals("3")) {
			return false;
		}
		return true;
	}
	
	//Verify option for User
	private boolean validUserOption(String option) {
		//Options must be 1,2,3,4
		if(!option.equals("1") && !option.equals("2") && !option.equals("3")&& !option.equals("4") && !option.equals("5") && !option.equals("6")&&!option.equals("")) {
			return false;
		}
		return true;
	}

	
}
