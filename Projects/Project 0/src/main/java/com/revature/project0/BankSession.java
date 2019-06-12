package com.revature.project0;

import java.util.List;
import java.util.Scanner;

import com.revature.project0.util.MathUtil;

public class BankSession {
	
	private BankSessionDao dao;
	private static Scanner sc = new Scanner(System.in);
	
	private boolean quit = false;
	
	public BankSession(BankSessionDao dao) {
		super();
		this.dao = dao;
	}
	
	public void start() {
		
		while(!quit) {
			
			if(dao.getCurrentUser() == null)
				PromptLogin();
			else if(dao.getCurrentAccount() == 0)
				PromptSelectAccount();
			else
				AccountActions();
			
			System.out.println();
			System.out.println("------------------------------------------------");
		}
	}
	
	public void PromptLogin() {
		
		System.out.println("Not Logged In");
		System.out.println("Commands:");
		System.out.println("- login: \'l\'");
		System.out.println("- create user: \'c\'");
		System.out.println("- exit session: \'x\'");
		System.out.println();
		System.out.print("Selection: ");
		String command = sc.nextLine();
		System.out.println();
		
		if("l".equals(command)) {
			
			System.out.println("Login:");
			System.out.print("Username: ");
			String username = sc.nextLine();
			System.out.print("Password: ");
			String password = sc.nextLine();
			
			dao.login(username, password);
			
			System.out.println();
			
			if(dao.getCurrentUser() == null)
				System.out.println("Invalid Credentials");
			else
				System.out.println("Logged in successfully");
			
		} else if("c".equals(command)) {
			
			System.out.print("Are you sure? (y to confirm): ");
			String confirm = sc.nextLine();
			
			if("y".equals(confirm)) {
				
				System.out.println();
				System.out.println("Create Account");
				System.out.print("Username (or c for cancel): ");
				String username = sc.nextLine();
				System.out.println();
				
				if("c".equals(username)) {
					System.out.println("Account Creation Cancelled");
					return;
				}
				
				while(username.isEmpty() || dao.userExists(username)) {
					
					if(username.isEmpty())
						System.out.println("Username can't be empty");
					else
						System.out.println("Username taken");
					
					System.out.println();
					System.out.println("Create Account");
					System.out.print("Username (or c for cancel): ");
					username = sc.nextLine();
					System.out.println();
					
					if("c".equals(username)) {
						System.out.println("Account Creation Cancelled");
						return;
					}
				}
				
				System.out.println();
				System.out.println("Create Account (" + username + ")");
				System.out.print("Email (or c for cancel): ");
				String email = sc.nextLine();
				System.out.println();
				
				if("c".equals(email)) {
					System.out.println("Account Creation Cancelled");
					return;
				}
				
				while(email.isEmpty() || dao.emailInUse(email)) {
					
					if(email.isEmpty())
						System.out.println("Email can't be empty");
					else
						System.out.println("Email taken");
					
					System.out.println();
					System.out.println("Create Account (" + username + ")");
					System.out.print("Email (or c for cancel): ");
					email = sc.nextLine();
					System.out.println();
					
					if("c".equals(email)) {
						System.out.println("Account Creation Cancelled");
						return;
					}
				}
				
				System.out.println();
				System.out.println("Create Account (" + username + ", " + email + ")");
				System.out.print("Password (or c for cancel): ");
				String password = sc.nextLine();
				System.out.println();
				
				if("c".equals(password)) {
					System.out.println("Account Creation Cancelled");
					return;
				}
				
				while(password.isEmpty()) {
					
					System.out.println("Password can't be empty");
					
					System.out.println();
					System.out.println("Create Account (" + username + ", " + email + ")");
					System.out.print("Password (or c for cancel): ");
					password = sc.nextLine();
					System.out.println();
				}
				
				dao.createNewUser(username, email, password);
				
			} else {
				
				System.out.println("Command Cancelled");
			}
			
		} else if("x".equals(command)) {
			
			System.out.print("Are you sure? (y to confirm): ");
			
			String confirm = sc.nextLine();
			
			if("y".equals(confirm)) {
				
				quit = true;
				
			} else {
				
				System.out.println("Command Cancelled");
			}
			
		} else {
			
			System.out.println("Unkown Command");
		}
	}
	
	public void PromptSelectAccount() {
		
		System.out.println("User: " + dao.getCurrentUser());
		System.out.println("Commands:");
		if(dao.getCurrentUsersAccounts() != null && dao.getCurrentUsersAccounts().size() > 0)
			System.out.println("- select bank account: \'s\'");
		System.out.println("- create bank account: \'c\'");
		System.out.println("- close user: \'close\'");
		System.out.println("- logout: \'l\'");
		System.out.println("- exit session: \'x\'");
		System.out.println();
		System.out.print("Selection: ");
		
		String command = sc.nextLine();
		System.out.println();
		
		if("s".equals(command) && dao.getCurrentUsersAccounts() != null && dao.getCurrentUsersAccounts().size() > 0) {
			
			System.out.println("Select Account Number: ");
			
			for(int id : dao.getCurrentUsersAccounts()) {
				System.out.println("- Account #" + id);
			}
			
			System.out.println();
			System.out.print("Selection: ");
			String accountIDString = sc.nextLine();
			
			try {
				
				int accountID = Integer.parseInt(accountIDString);
				
				if(dao.canUserAccessAccount(accountID)) {
					
					dao.setCurrentAccount(accountID);
					
				} else {
					
					System.out.println("Can't access that account or account doesn't exist");
					System.out.println("Command Cancelled");
				}
				
			} catch(NumberFormatException e) {
				
				System.out.println("Invalid accountID: \'" + accountIDString + "\'");
				System.out.println("Command Cancelled");
			}
			
		} else if("c".equals(command)) {
			
			System.out.print("Are you sure? (y to confirm): ");
			
			String confirm = sc.nextLine();
			
			if("y".equals(confirm)) {
				
				dao.createNewBankAccount();
				
			} else {
				
				System.out.println("Command Cancelled");
			}
			
		} else if("l".equals(command)) {
			
			System.out.print("Are you sure? (y to confirm): ");
			
			String confirm = sc.nextLine();
			
			if("y".equals(confirm)) {
				
				dao.logout();
				
			} else {
				
				System.out.println("Command Cancelled");
			}
			
		} else if("x".equals(command)) {
			
			System.out.print("Are you sure? (y to confirm): ");
			
			String confirm = sc.nextLine();
			
			if("y".equals(confirm)) {
				
				quit = true;
				
			} else {
				
				System.out.println("Command Cancelled");
			}
			
		} else if("close".equals(command)) {
			
			System.out.print("Close user? (y to confirm): ");
			
			String confirm = sc.nextLine();
			
			if("y".equals(confirm)) {
				
				System.out.println("Closing User: " + dao.getCurrentUser());
				
				String username = dao.getCurrentUser();
				List<Integer> accounts = dao.getCurrentUsersAccounts();
				for(int account : accounts) {
					
					if(dao.numUsersForAccount(account) == 1) {
						
						System.out.println("Closing account #" + account + " since only user: " + username + " can access it");
						
						dao.setCurrentAccount(account);
						
						double remainingBalance = dao.getBalance();
						System.out.print("Account #" + account + " was closed.");
						if(!MathUtil.approxEqual(remainingBalance, 0)) {

							dao.withdrawAmount(remainingBalance);
							System.out.println( "the remainging $" + remainingBalance + " balance was withdrawn before closing.");
							
						} else {
							
							System.out.println();
						}
						
						dao.deleteAccount();
						System.out.println();
					}
				}
				
				System.out.println("Closing user: " + username);
				dao.deleteCurrentUser();
				
			} else {
				
				System.out.println("Command Cancelled");
			}
			
		} else {
			
			System.out.println("Invalid Command: \'" + command + "\'");
		}
	}
	
	void AccountActions() {
		
		System.out.println("User: " + dao.getCurrentUser());
		System.out.println("Account: #" + dao.getCurrentAccount());
		System.out.println("Current Balance: $" + dao.getBalance());
		System.out.println("Commands:");
		System.out.println("- deposit: \'d\'");
		System.out.println("- withdraw: \'w\'");
		System.out.println("- transfer money to another account: \'t\'");
		System.out.println("- view transaction history: \'h\'");
		System.out.println("- delete account: \'del\'");
		System.out.println("- grant access to other user: \'g\'");
		System.out.println("- switch accounts: \'s\'");
		System.out.println("- logout: \'l\'");
		System.out.println("- exit: \'x\'");
		System.out.println();
		System.out.print("Selection: ");
		String input = sc.nextLine();
		System.out.println();
		
		if("l".equals(input)) {
			
			System.out.print("Are you sure? (y to confirm): ");
			
			String confirm = sc.nextLine();
			
			if("y".equals(confirm)) {
				
				dao.logout();
				
			} else {
				
				System.out.println("Command Cancelled");
			}
			
		} else if("s".equals(input)) {
			
			System.out.print("Are you sure? (y to confirm): ");
			
			String confirm = sc.nextLine();
			
			if("y".equals(confirm)) {
				
				dao.setCurrentAccount(0);
				
			} else {
				
				System.out.println("Command Cancelled");
			}
			
		} else if("x".equals(input)) {
			
			System.out.print("Are you sure? (y to confirm): ");
			
			String confirm = sc.nextLine();
			
			if("y".equals(confirm)) {
				
				quit = true;
				
			} else {
				
				System.out.println("Command Cancelled");
			}
			
		} else if("d".equals(input)) {
			
			System.out.print("Amount to deposit: ");
			
			String amountText = sc.nextLine();
			
			try {
				
				double amount = Double.parseDouble(amountText);
				
				if(amount <= 0) {
					
					System.out.println("The ammount must be a non-zero positive value");
					System.out.println("Command Cancelled");
					
				} else {
					
					System.out.print("Desposit $" + amount + " into account #" + dao.getCurrentAccount() + "? (y to confirm): ");
					
					String confirm = sc.nextLine();
					
					if("y".equals(confirm)) {
						
						dao.depositAmount(amount);
						
					} else {
						
						System.out.println("Command Cancelled");
					}
				}
				
			} catch(NumberFormatException e) {
				
				System.out.println("Invalid amount: \'" + amountText + "\'");
				System.out.println("Command Cancelled");
			}
			
		} else if("w".equals(input)) {
			
			System.out.print("Amount to withdraw: ");
			
			String amountText = sc.nextLine();
			
			try {
				
				double amount = Double.parseDouble(amountText);
				
				if(amount <= 0) {
					
					System.out.println("The ammount must be a non-zero positive value");
					System.out.println("Command Cancelled");
					
				} else {
					
					if(dao.getBalance() < amount) {
						
						System.out.println("Can't withdraw more than the balance");
						System.out.println("Command Cancelled");
						
					} else {
					
						System.out.print("Withdraw $" + amount + " from account #" + dao.getCurrentAccount() + "? (y to confirm): ");
						
						String confirm = sc.nextLine();
						
						if("y".equals(confirm)) {
							
							dao.withdrawAmount(amount);
							
						} else {
							
							System.out.println("Command Cancelled");
						}
					}
				}
			} catch(NumberFormatException e) {
				
				System.out.println("Invalid amount: \'" + amountText + "\'");
				System.out.println("Command Cancelled");
			}
			
		} else if("t".equals(input)) {
			
			System.out.print("Amount to transfer: ");
			
			String amountText = sc.nextLine();
			
			try {
				
				double amount = Double.parseDouble(amountText);
				
				if(amount <= 0) {
					
					System.out.println("The ammount must be a non-zero positive value");
					System.out.println("Command Cancelled");
					
				} else {
				
					if(dao.getBalance() < amount) {
						
						System.out.println("Can't transfer more than the balance out of the current account");
						
					} else {
					
						System.out.print("Account to transfer to: ");
						
						String accountIDText = sc.nextLine();
						
						try {
							
							int accountID = Integer.parseInt(accountIDText);
							
							if(dao.canUserAccessAccount(accountID)) {
								
								System.out.print("Transfer $" + amount + " from account #" + dao.getCurrentAccount() + " to account #" + accountID + "? (y to confirm): ");
								
								String confirm = sc.nextLine();
								
								if("y".equals(confirm)) {
									
									dao.transferAmount(accountID, amount);
									
								} else {
									
									System.out.println("Command Cancelled");
								}
								
							} else {
								
								System.out.println("You don't have access to account #" + accountID + " if it exists");
								System.out.println("Command Cancelled");
							}
							
						} catch(NumberFormatException e) {
							
							System.out.println("Invalid account#: \'" + accountIDText + "\'");
							System.out.println("Command Cancelled");
						}
					}
				}
			} catch(NumberFormatException e) {
				
				System.out.println("Invalid amount: \'" + amountText + "\'");
				System.out.println("Command Cancelled");
			}
			
		} else if("h".equals(input)) {
			
			List<String> transactionHistory = dao.getTransactionHistory();
			
			if(transactionHistory == null || transactionHistory.size() == 0) {
				System.out.println("No Transaction History to Display");
			} else {
				
				System.out.println();
				System.out.println("Transaction History:");
				System.out.println("--------------------");
				
				for(String transaction : transactionHistory) {
					System.out.println("- " + transaction);
				}
			}
			
		} else if("g".equals(input)) {
			
			System.out.print("Specify other user to grant access to this account (or c for cancel): ");
			
			String altUsername = sc.nextLine();
			
			if("c".equals(altUsername)) {
				
				System.out.println("Command Cancelled");
				
			} else if(dao.userExists(altUsername)) {
				
				dao.grantUserAccessToCurrentAccount(altUsername);
				
				System.out.println(altUsername + " was granted access to account #" + dao.getCurrentAccount());
				
			} else {
				
				System.out.println("Invalid username: \'" + altUsername + "\'");
				System.out.println("Command Cancelled");
			}
			
		} else if("del".equals(input)) {
			
			System.out.print("Delete account #" + dao.getCurrentAccount() + "? (y to confirm): ");
			
			String confirm = sc.nextLine();
			
			if("y".equals(confirm)) {
				
				int accountID = dao.getCurrentAccount();
				
				double remainingBalance = dao.getBalance();
				
				System.out.print("Account #" + accountID + " was closed.");
				if(!MathUtil.approxEqual(remainingBalance, 0)) {
					dao.withdrawAmount(remainingBalance);
					System.out.println(" the remainging $" + remainingBalance + " balance was withdrawn before closing.");
				} else {
					System.out.println();
				}
				
				dao.deleteAccount();
				
			} else {
				
				System.out.println("Command Cancelled");
			}
			
		} else {
			
			System.out.println("Unkown Command");
		}
	}
}
