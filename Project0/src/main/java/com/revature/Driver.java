package com.revature;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.revature.dao.AccountDao;
import com.revature.dao.CustomerDao;
import com.revature.dao.UserAccountDao;
import com.revature.dao.UserAccountDaoImpl;
import com.revature.util.ConnectionUtil;
import com.revature.dao.AccountDaoImpl;
import com.revature.dao.CustomerDaoImpl;

import com.revature.model.Account;
import com.revature.model.Customer;
import com.revature.model.UserAccount;

public class Driver {
	
	
	private static int userID;
	private static Account userAccount = new Account();
	private static int accNum, accBalance;
	private static String accType;
	
	private static List<UserAccount> users;
	private static List<Account> accounts;
	private static List<Customer> customers;

	
	private static CustomerDao cd = new CustomerDaoImpl();
	private static UserAccountDao ud = new UserAccountDaoImpl();
	private static AccountDao ad = new AccountDaoImpl();
	
	private static boolean login;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String userInput;
		
		userID = 0;
		login = false;
		

		try {
			Connection c = ConnectionUtil.getHardCodedConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		while (login == false) {
			users = ud.getUserAccounts();
			accounts = ad.getAccounts();
			
			LogIn();
		}
		Customer c1 = cd.getCustomerById(userID);
		System.out.println("Welcome " + c1.getFirstName() + " " + c1.getLastName() + "!");
		
		while (login == true) {
				
			System.out.println("Please enter the number of the operation you would like to do: ");
			
			System.out.println("1. Check balance  \n2. Deposit \n3. Withdraw");
			System.out.println("4. Log Out");
			switch (userInput = sc.nextLine()) {
			case "1":
				System.out.println("Your account balance is: " + ad.getBalance(userID));
				break;
			case "2":
				System.out.println("Enter how much you wish to deposit: ");
				userInput = sc.nextLine();
				double depoAmount = Double.valueOf(userInput);
				ad.deposit2(userAccount, depoAmount);
				userAccount = ad.getAccountByNum(userID);
				break;
			case "3":
				System.out.println("Enter how much you wish to withdraw: ");
				userInput = sc.nextLine();
				double withdrawAmount = Double.valueOf(userInput);
				ad.withdraw(userAccount, withdrawAmount);
				userAccount = ad.getAccountByNum(userID);

				break;
				
			case "4":
					userID = 0;
					login = false;
					System.out.println("Successfully logged out.");
					break;
			}
		}
		
		
	}
	
	public static void LogIn() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please choose an option. (Enter the number)");
		System.out.println("1. Log In \n2. Create a User Account");
		String userInput;
		
		switch (userInput = sc.nextLine()) {
		case "1":
			System.out.println("Please enter your Username:");
			userInput = sc.nextLine();
			
			for (UserAccount u : users) {
				if (u.getUsername().compareTo(userInput) == 0) {
					System.out.println("Please enter your password: ");
					userInput = sc.nextLine();
					if (u.getPassword().compareTo(userInput) == 0) {
						System.out.println("Successfully logged in. \n");
						login = true;
						userID = u.getId();
						userAccount = ad.getAccountByNum(userID);
						break;
					} 
				} 
			} 
			if (login == false) {
				System.out.println("Username or Password Incorrect, Please Try Again"); 
			}
			break;
		case "2":
			createCustomer();
		}
	}
	
	public static Customer createCustomer() {
		Customer c = new Customer();
		Scanner sc = new Scanner(System.in);
		String userInput;
		customers = cd.getCustomers();
		int custID = customers.size() + 1;
		if (custID == 4) {
			custID = 5;
		}
		userID = custID;
		String firstName = "";
		String lastName = "";
		String email = "";
		String birthdate = "";
		String address = "";
		String street = "";
		String city = "";
		String state = "";
		int zip = 0;
		int ss = 0;
		
		System.out.println("Please enter the following information: \nFirst Name");
		userInput = sc.nextLine();
		if (CheckStringForLettersOnly(userInput) == 1) {
			return null;
		}
		firstName = userInput;
		
		System.out.println("Last Name:");
		userInput = sc.nextLine();
		if (CheckStringForLettersOnly(userInput) == 1) {
			return null;
		}
		lastName = userInput;
		
		System.out.println("Email:");
		userInput = sc.nextLine();
		if (CheckForValidEmail(userInput) == 1) {
			return null;
		}
		email = userInput;
		
		System.out.println("Birthdate (##-MON-##):");
		userInput = sc.nextLine();
		if (CheckForBirthFormat(userInput) == 1) {
			return null;
		}
		birthdate = userInput;
		
		System.out.println("Firenumber:");
		userInput = sc.nextLine();
		address = userInput;
		
		System.out.println("Street:");
		userInput = sc.nextLine();
		street = userInput;
		
		System.out.println("City:");
		userInput = sc.nextLine();
		city = userInput;
		
		System.out.println("State (Initials, Ex: WI):");
		userInput = sc.nextLine();
		if (CheckForStateFormat(userInput) == 1) {
			return null;
		}
		state = userInput;
		
		System.out.println("Zipcode:");
		userInput = sc.nextLine();
		if (CheckForZipFormat(userInput) == 1) {
			return null;
		}
		zip = Integer.valueOf(userInput);
		
		System.out.println("Social Security # (##########):");
		userInput = sc.nextLine();
		//if (CheckForSSFormat(userInput) == 1) {
		//	return null;
		//}
		ss = Integer.valueOf(userInput);
		
		
		c = new Customer (userID, firstName, lastName, email, birthdate, address, 
				street, city, state, zip, ss);
		
		cd.insertCustomer(c);
		
		createAccount();
		createUserAccount();
		
		System.out.println("Your account has been successfully created!");
		
		return c;
		
	}
	
	public static Account createAccount() {
		Account a = new Account();
		Scanner sc = new Scanner(System.in);
		List<Account> accounts = ad.getAccounts();
		int accountNum = accounts.size() + 1;
		double accountBal = 0;
		String accountType = "";
		String userInput;
		
		System.out.println("Please choose account type.");
		System.out.println("1. Checking \n2. Savings");
		switch (userInput = sc.nextLine()) {
		case "1":
			accountType = "Checking";
			break;
		case "2":
			accountType = "Savings";
			break;
		} 
		System.out.println("Please enter initial deposit amount");
		userInput = sc.nextLine();
		accountBal = Double.valueOf(userInput);
		
		a = new Account(userID, accountNum, accountType, accountBal);
		
		ad.insertAccount(a);
		
		userAccount = a;
		
		return a;
		
	}
	
	public static UserAccount createUserAccount() {
		UserAccount u = new UserAccount();
		Scanner sc = new Scanner(System.in);
		String userInput;
		String username = "";
		String password = "";
		
		System.out.println("Please enter a Username for your account:");
		userInput = sc.nextLine();
		username = userInput;
		System.out.println("Please enter a Password for your account:");
		userInput = sc.nextLine();
		password = userInput;
		
		u = new UserAccount(userID, username, password);
		
		ud.createUserAccount(u);
		
		return u;
	}
	
	public static int CheckStringForLettersOnly(String s) {
		int hasNumbers = 0;
		if (s.matches("^[0-9]*$")) {
			System.out.println("Input can only contain letters");
			return hasNumbers = 1;
		}
		return hasNumbers = 0;
	}
	
	public static int CheckStringForNumbersOnly(String s) {
		int hasNumbers = 0;
		if (s.matches("^[0-9]*$")) {
			System.out.println("Input can only contain letters");
			return hasNumbers = 1;
		}
		return hasNumbers = 0;
	}
	
	public static int CheckForStateFormat(String s) {
		int isValid = 1;
		if (s.matches("^(?:(A[KLRZ]|C[AOT]|D[CE]|FL|GA|HI|I[ADLN]|K[SY]|LA|M[ADEINOST]|N[CDEHJMVY]|O[HKR]|P[AR]|RI|S[CD]|T[NX]|UT|V[AIT]|W[AIVY]))$")) {
			return isValid = 0;
		}
		System.out.println("Please use correct format");
		return isValid = 1;
	}
	
	public static int CheckForZipFormat(String s) {
		int isValid = 1;
		if (s.matches("^[0-9]{5}(?:-[0-9]{4})?$")) {
			return isValid = 0;
		}
		System.out.println("Please enter a valid Zip Code");
		return isValid = 1;
	}
	public static int CheckForValidEmail(String s) {
		int isValid = 1;
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                "[a-zA-Z0-9_+&*-]+)*@" + 
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                "A-Z]{2,7}$"; 
                  
		Pattern pat = Pattern.compile(emailRegex);
		if (pat.matcher(s).matches()) {
			return isValid = 0;
		}
		System.out.println("Please enter a valid email");
		return isValid = 1;
	}
	
	public static int CheckForBirthFormat(String s) {
		int isFormat = 1;
		
		if (s.matches("^(([0-9])|([0-2][0-9])|([3][0-1]))\\-(JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC)\\-\\d{2}$")) {
			
			return isFormat = 0;
		}
		System.out.println("Please follow the correct format");
		
		return isFormat = 1;
	}
	
	public static int CheckForSSFormat(String s) {
		int isValid = 1;
		if (s.matches("^\\d{9}$")) {
			return isValid = 0;
		}
		System.out.println("Please use correct format");
		return isValid = 1;
	}

}
