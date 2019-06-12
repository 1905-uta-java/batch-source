package com.revature;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

import com.revature.dao.*;
import com.revature.models.*;

public class Bank {
	//lotsa objects
	private UserDao usd;
	private User u;
	private Scanner sc;
	private BankDao bd = new BankDaoImpl();
	private List<BankAccount> bankAccList; 
	
	
	public Bank(UserDao usd, User u, Scanner sc) {
		this.setAcc(usd);
		this.u = u;
		this.sc = sc;
		bankAccList = bd.getAllBankAccounts(u);
	}
	
	/*
	 * First output
	 * */
	public void splash() {
		updateAccList();
		String in = "";
		
		System.out.println("Hello " + u.getFirstName() + " " + u.getLastName());
		System.out.println();
		
		do {
			System.out.println("\nWhat would you like to do?\n[C]heck Account Balances\nC[R]eate Bank Account\n" + 
					"D[E]lete Bank Account\n[D]eposit Funds\n[W]ithdrawl Funds\n[L]ogout ");
			
			if(u.getUsername().equals("admin")) {
				System.out.println("[P]rint All Accounts (ADMIN ONLY)");
			}
			
			in = sc.nextLine().toUpperCase();
			
			System.out.println();
			switch(in) {
			case "C":
				System.out.println("You chose to check your bank accounts");
				System.out.println(listBankAccounts());
				break;
			case "R":
				System.out.println("You chose to create a new bank account");
				createBankAccount();
				break;
			case "E":
				System.out.println("You chose to delete an existing new account");
				deleteBankAccount();
				break;
			case "D":
				System.out.println("You chose to deposit funds into an account");
				depositFunds();
				break;
			case "W":
				System.out.println("You chose to withdrawl funds from an account");
				withdrawlFunds();
				break;
			case "T":
				System.out.println("You chose to transfer funds from one account to another");
				break;
			case "L":
				logout();
				break;
			case "P":
				if (u.getUsername().equals("admin")){
					System.out.println("Printing all accounts");
					printAllAccounts();
				}
				break;
			default:
				System.out.println("Unknown command");
				break;	
			}
		} while (!in.equals("L"));
	}
	
	
	/*
	 * Creates a bank account for the user
	 * */
	public void createBankAccount() {
		int id = bd.getNewAccNum();
		String type = "";
		String in = "";
		double initialBalance = 0.00;
		
		//get type of Banking Account
   		type = "";
		do {
			System.out.println("What type of account do you want to create? ([C]hecking or [S]avings?): ");
			in = sc.nextLine().toUpperCase();
			
			type = typeService(in);
			
			if(type.equals(""))
				System.out.println("Invalid input, try again.");
		} while(type.equals(""));
		
		//Now get the starting balance
		do {
			System.out.println("Enter your intital balance for your new account: ");
			in = sc.nextLine();
			
			initialBalance = initialBalanceService(in);
			
			if(initialBalance == -1) {
				System.out.println("Could not convert input into a valid amount");
			}
			else if (initialBalance == -2) {
				System.out.println("Initial balance needs to be higher.");
			} 
			
		} while(initialBalance < 0.01);
		
		BankAccount b = new BankAccount(id, type, u.getUsername(), initialBalance, u.getId(), u);
		
		bd.createBankAccount(b);
		updateAccList();// refresh Bank Account List
		
		System.out.println("Account created successfully!");
	}
	
	/*
	 * Error checking for bank account type
	 * */
	public String typeService(String type) {
		if(type.equals("C"))  return "Checking";
		else if(type.equals("S")) return "Savings";
		else return "";	
	}
	/*
	 * Error checking for initial balance 
	 * */
	public double initialBalanceService(String inStr) {
		double initialBalance;
		try {
			initialBalance = Double.parseDouble(inStr);
		} catch (NumberFormatException e) {
			return -1;
		}
		
		if(initialBalance < 0.01)
			return -2;
		else
			return initialBalance;
	}

	/*
	 * Lists the bank accounts associated with the user 
	 * */
	private String listBankAccounts(){
		System.out.println("Printing out some cool new stuff with an ArrayList!");
		System.out.println("#\tType\t\tBalance\tID");
		String outStr = "";
		
		for(int i = 0; i < bankAccList.size(); i++) {
			outStr = outStr + (i+1) + "\t" + bankAccList.get(i).getType() + " \t$" + 
					bankAccList.get(i).getCurrBalance() + "\t"+ 
					bankAccList.get(i).getId()+ " \n";
		}
		
		return outStr;
	}

	
	/*
	 * Bank account selection for user
	 * */
	public int selectBankAccount() {
		String accountList = listBankAccounts();
		String inStr = "";
		int arrNum = 0;
		System.out.println();
		
		do {
			System.out.println(accountList);
			System.out.println("Select a bank account: ");
			inStr = sc.nextLine();			
			
			arrNum = selectAccountService(inStr);
			
			
			if(arrNum >=0)
				showSingleBankAccount(arrNum-1);								
			else if (arrNum ==-1) 
				System.out.println("Not a valid number.");
			else if (arrNum == -2)
				System.out.println("Not a valid account.");
			
		} while(arrNum <= 0);
		
		return arrNum - 1;
	}
	
	/*
	 * Error checking for Bank Account selection 
	 * */
	public int selectAccountService(String inStr) {
		int arrNum = 0;
		
		try {
			arrNum = Integer.parseInt(inStr);
		} catch (NumberFormatException e) {
			return -1;
		} catch (NullPointerException e) {
			return -2;
		}
		
		if((arrNum - 1) > bankAccList.size()) {
			return -2;
		}
		
		return arrNum;
	}
	
	
	/*
	 * Shows information on a single bank account 
	 * */
	private void showSingleBankAccount(int index) {
		DecimalFormat df = new DecimalFormat("#.00");
		
		index = singleAccountService(index);
		if(index > 0) {
			System.out.println("\n\nType\t\tBalance\tID");
			System.out.println(bankAccList.get(index).getType() + "  \t$" + df.format(bankAccList.get(index).getCurrBalance()) + 
					"\t" + bankAccList.get(index).getId() + "\n");
		} else if (index == -1) {
			System.out.println("Hit a Null pointer");
		} else if (index == -2) {
			System.out.println("Index out of bounds");
		}
	}
	
	/*
	 * Error checking for single bank account 
	 * */
	public int singleAccountService(int index) {
		try {
			bankAccList.get(index);
		} catch (NullPointerException e) {
			return -1;
		} catch (IndexOutOfBoundsException e) {
			return -2;
		}
		return index;
	}
	
	
	/*
	 * Adds money to bank account
	 * */
	public void depositFunds() {
		System.out.println("DEPOSIT into account");
		String inStr = "";
		int bankId = selectBankAccount();
		double amount;
		double currBalance = bankAccList.get(bankId).getCurrBalance();
		double result;
		
		do {
			amount = 0.00;
			System.out.println("Enter the amount of cash you would like to deposit: ");
			inStr = sc.nextLine();
			
			result = depositService(currBalance, bankId, inStr);
			amount = result - currBalance; 
			if(result > 0) {
				System.out.println("Making deposit");
				bankAccList.get(bankId).setCurrBalance(result);
				System.out.println("$" + amount + " deposited into account.");
				bd.updateBankAccount(bankAccList.get(bankId));
				System.out.println("New balance is $" + result);
				showSingleBankAccount(bankId);							
			} else {
				System.out.println("There's an issue with your input.");
				if(result == -1)
					System.out.println("Input could not be converted into a number.");
				else if (result == -2)
					System.out.println("Empty deposit.");
				else if (result == -3)
					System.out.println("Negative deposit.");
			}
		} while(result < 0);
	}

	/*
	 * Error checking for deposit
	 * */
	public double depositService(double currBalance, int bankId, String inStr) {
		double deposit;
		
		//Try to convert String to double. 
		try {
			deposit = Double.parseDouble(inStr);
		} catch (NumberFormatException e) {
			return -1;
		}
		if(deposit == 0.00) // empty deposit
			return -2;
		else if(deposit < 0.00) // negative deposit
			return -3;
		else {
			currBalance += deposit;
			return currBalance;
		}
	}
	
	
	
	/*
	 * Takes money out of account 
	 * */
	public void withdrawlFunds() {
		System.out.println("WITHDRAWL from Account");
		
		String inStr = "";
		double currBalance = 0.00;
		double result;
		int bankId = selectBankAccount();
		
		if(bankId >= 0) {
			currBalance = bankAccList.get(bankId).getCurrBalance();
			
			do {
				System.out.println("How much do you want to withdrawl?:");
				inStr = sc.nextLine();
				
				result = withdrawlService(currBalance, bankId, inStr);
				
				if(!(result < 0)) {
					bankAccList.get(bankId).setCurrBalance(result);
					System.out.println("New balance is: $" + result);
					bd.updateBankAccount(bankAccList.get(bankId));
					showSingleBankAccount(bankId);
				} 
				else if (result == -1)
					System.out.println("Your input could not be converted into a valid withdrawl amount");
				else if (result == -2)
					System.out.println("Trying to withdrawl negative amount");
				else if (result == -3)
					System.out.println("Withdrawing amount exceeds amount in account");
				
				
			} while ((result < 0));
		}
	}
	
	/*
	 * Error checking for withdrawl 
	 * */
	public double withdrawlService(double currBalance, int bankId, String inStr) {
		double withdrawl;
		
		//Try to convert String to double. 
		try {
			withdrawl = Double.parseDouble(inStr);
		} catch (NumberFormatException e) {
			return -1;
		}

		System.out.println("Taking out $" + withdrawl + " from account");

		if(withdrawl < 0) {
			return -2;
		}
		
		if(currBalance - withdrawl < 0) {
			return -3; // account is under, cannot complete withdraw
		}
		
		
		currBalance -= withdrawl;
		return currBalance;
		
	}

	
	/*
	 * Clears the global bankAccList and a objects
	 * */
	private void logout() {
		System.out.flush();
		System.out.println("Logging out...");
		
		//empty the objects
		u = null;
		bankAccList.clear();
	}
	

	/*
	 * Deletes a bank account associated with the currently logged in account
	 * */
	public void deleteBankAccount() {
		String inStr = "";
		int bankId;
		int checkId;
		
		do {
			System.out.println("DELETE Bank Account");
			bankId = selectBankAccount();
			checkId = deleteService(bankId);
			
			if(checkId == -1) 
				System.out.println("Not a valid account");
		} while (checkId == -1);
		
		
		
		if(checkId == -2) {
			System.out.println("There is still money in this account.");			
		}
		//inStr = sc.nextLine().toUpperCase();
		if(bankId >=0) {
			System.out.println("Are you sure you want to delete this account? ([Y]es, [N]o): ");
			inStr = sc.nextLine().toUpperCase();
			
			if(inStr.equals("Y")) {
				System.out.println("Deleting...");
				bd.deleteBankAccount(bankAccList.get(bankId).getId(), u);
			} else {
				System.out.println("Canceled...");
			}
			
			updateAccList(); // we always update this list when messing with the accounts			
		} else 
			System.out.println("Delete canceled...");
	}
	
	
	/*
	 * Checks the account to see if there is still money in it.
	 * */
	public int deleteService(int bankId) {
		//there is still money in account. Ask if they want to transfer it or withdraw it
		
		double currentBalance;
		
		try {
			currentBalance = bankAccList.get(bankId).getCurrBalance();
		} catch (IndexOutOfBoundsException e) {
			return -1;
		}
		
		if(currentBalance > 0) {
			return -2;
		} 
		//otherwise it's good
		return 0;
	}
	
	
	/*
	 * Talks to DB, and sets the bankAccList to whatever is currently on the DB for bankAccounts
	 * */
	public void updateAccList() {
		String inStr = "";

		bankAccList = bd.getAllBankAccounts(u);
		
		if(bankAccList.size() == 0) {
			System.out.println("It seems you don't have any bank accounts open on this account. Would you like to open one? [Y]es or [N]o?: ");
			inStr = sc.nextLine().toUpperCase();
			
			if(inStr.equals("Y")) {
				createBankAccount();
			}
		}
	}
	
	/*
	 * ADMIN ONLY method.
	 * Prints everything in DB
	 * */
	private void printAllAccounts() {
		System.out.println("ADMIN ONLY METHOD");
		
		List<User> accounts = usd.getUsers();
		System.out.println("\n\nALL USERS: \n\n" + accounts);
		
		List<BankAccount> bankAccounts = bd.getBankAccounts();
		System.out.println("\n\nALL BANK ACCOUNTS: \n\n" + bankAccounts);
	}
	
	/*
	 * Did this to satisfy Spring Tools
	 * */
	public UserDao getUsd() {
		return usd;
	}

	public void setAcc(UserDao acc) {
		this.usd = acc;
	}
}
