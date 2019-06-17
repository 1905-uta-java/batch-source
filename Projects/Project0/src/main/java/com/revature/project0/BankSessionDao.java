package com.revature.project0;

import java.util.List;

public interface BankSessionDao {
	
	public String getCurrentUser();
	
	public int getCurrentAccount();
	
	public void setCurrentAccount(int accountID);
	
	public List<Integer> getCurrentUsersAccounts();
	
	public boolean createNewUser(String username, String email, String password);
	
	public void deleteCurrentUser();
	
	public boolean userExists(String username);
	
	public boolean emailInUse(String email);
	
	public boolean login(String username, String password);
	
	public void logout();
	
	public void createNewBankAccount();
	
	public boolean canUserAccessAccount(int accountID);
	
	public boolean deleteAccount();
	
	public double getBalance();

	public boolean withdrawAmount(double amount);
	
	public boolean depositAmount(double amount);
	
	public boolean transferAmount(int toAccountID, double amount);
	
	public List<String> getTransactionHistory();
	
	public boolean grantUserAccessToCurrentAccount(String username);
	
	public int numUsersForAccount(int accountID);
}
