package com.revature.project0.database;

import java.util.ArrayList;
import java.util.List;

import com.revature.project0.BankSessionDao;
import com.revature.project0.data.*;
import com.revature.project0.util.PasswordResult;
import com.revature.project0.util.PasswordUtil;

public class BankSessionDaoImpl implements BankSessionDao {
	
	private BankUser currentUser;
	private List<BankAccount> currentUsersAccounts;
	private BankAccount currentAccount;
	private List<Transaction> currentAccountsTransactions;
	
	private DatabaseManager databaseManager = new DatabaseManager();
	
	private BankAccount getAccount(int accountID) {
		
		if(currentUsersAccounts == null)
			return null;
		
		for(BankAccount account : currentUsersAccounts) {
			
			if(account.getAccountID() == accountID)
				return account;
		}
		
		return null;
	}
	
	public boolean createNewUser(String username, String email, String password) {
		
		PasswordResult result = PasswordUtil.HashPassword(password);
		
		BankUser newUser = new BankUser(username, email, result.getHash(), result.getSalt());
		
		if(databaseManager.canAddUserToDatabase(newUser)) {
			
			databaseManager.addUserToDatabase(newUser);
			currentUser = newUser;
			
			currentUsersAccounts = databaseManager.pullUsersAccountData(currentUser);
		}
		
		return false;
	}
	
	public void deleteCurrentUser() {
		
		if(currentUser == null)
			return;
		
		databaseManager.removeUserFromDatabase(currentUser);
		
		currentUser = null;
		currentUsersAccounts = null;
		currentAccount = null;
		currentAccountsTransactions = null;
	}
	
	public boolean userExists(String username) {
		
		return databaseManager.userExists(username);
	}

	public boolean emailInUse(String email) {
		
		return databaseManager.emailInUse(email);
	}
	
	public boolean login(String username, String password) {
		
		BankUser newUser = databaseManager.login(username, password);
		
		if(newUser == null)
			return false;
		
		currentUser = newUser;
		
		currentUsersAccounts = databaseManager.pullUsersAccountData(currentUser);
		
		currentAccount = null;
		currentAccountsTransactions = null;
		
		return true;
	}
	
	public void logout() {
		
		currentUser = null;
		currentUsersAccounts = null;
		currentAccount = null;
		currentAccountsTransactions = null;
	}
	
	public void createNewBankAccount() {
		
		BankAccount newAccount = new BankAccount(0, 0);
		
		currentUsersAccounts.add(newAccount);
		
		databaseManager.addAccountToDatabase(newAccount, currentUser);
		
		currentAccount = newAccount;
		
		currentAccountsTransactions = new ArrayList<Transaction>();
	}
	
	public boolean canUserAccessAccount(int accountID) {
		
		return getAccount(accountID) != null;
	}

	public boolean deleteAccount() {
		
		if(currentAccount == null)
			return false;
		
		databaseManager.removeAccountFromDatabase(currentAccount);
		
		currentAccount = null;
		currentAccountsTransactions = null;
		
		return true;
	}

	public double getBalance() {
		
		if(currentAccount == null)
			return 0;
		
		return currentAccount.getCurrentBalance();
	}
	
	public boolean withdrawAmount(double amount) {

		if(currentAccount == null)
			return false;
		
		if(currentAccount.getCurrentBalance() < amount)
			return false;
		
		currentAccount.setCurrentBalance(currentAccount.getCurrentBalance() - amount);
		
		
		databaseManager.updateAccountBalanceOnDatabase(currentAccount);
		
		Transaction withdrawal = new Transaction(0, "WITHDRAWAL", amount, currentAccount.getAccountID(), 0);
		
		currentAccountsTransactions.add(withdrawal);
		databaseManager.addTransactionToDatabase(withdrawal);
		
		return true;
	}

	public boolean depositAmount(double amount) {

		if(currentAccount == null)
			return false;
		
		currentAccount.setCurrentBalance(currentAccount.getCurrentBalance() + amount);
		
		databaseManager.updateAccountBalanceOnDatabase(currentAccount);
		
		Transaction deposit = new Transaction(0, "DEPOSIT", amount, 0, currentAccount.getAccountID());
		
		currentAccountsTransactions.add(deposit);
		databaseManager.addTransactionToDatabase(deposit);
		
		return true;
	}

	public boolean transferAmount(int toAccountID, double amount) {
		
		if(currentAccount == null)
			return false;
		
		if(currentAccount.getCurrentBalance() < amount)
			return false;
		
		BankAccount toAccount = getAccount(toAccountID);
		
		if(toAccount == null)
			return false;
		
		currentAccount.setCurrentBalance(currentAccount.getCurrentBalance() - amount);
		toAccount.setCurrentBalance(toAccount.getCurrentBalance() + amount);
		
		databaseManager.updateAccountBalanceOnDatabase(currentAccount);
		databaseManager.updateAccountBalanceOnDatabase(toAccount);

		Transaction transfer = new Transaction(0, "TRANSFER", amount, currentAccount.getAccountID(), toAccount.getAccountID());
		
		currentAccountsTransactions.add(transfer);
		databaseManager.addTransactionToDatabase(transfer);
		
		return true;
	}
	
	public boolean grantUserAccessToCurrentAccount(String username) {
		
		if(currentAccount == null)
			return false;
		
		if(!databaseManager.userExists(username))
			return false;
		
		databaseManager.grantUserAccesToAccount(username, currentAccount);
		
		return true;
	}

	public String getCurrentUser() {
		return (currentUser == null) ? null : currentUser.getUsername();
	}
	
	public int getCurrentAccount() {
		return (currentAccount == null) ? 0 : currentAccount.getAccountID();
	}
	
	public List<String> getTransactionHistory() {
		
		if(currentAccountsTransactions == null)
			return null;
		
		List<String> transactionHistory = new ArrayList<String>();
		
		for(Transaction t : currentAccountsTransactions) {
			transactionHistory.add(t.getStringRep(currentAccount.getAccountID()));
		}
		
		return transactionHistory;
	}
	
	public List<Integer> getCurrentUsersAccounts() {
		
		if(currentUsersAccounts == null)
			return null;
		
		List<Integer> accountIDs = new ArrayList<Integer>();
		
		for(BankAccount a : currentUsersAccounts) {
			accountIDs.add(a.getAccountID());
		}
		
		return accountIDs;
	}

	public void setCurrentAccount(int accountID) {
		
		if(accountID == 0) {
			currentAccount = null;
			currentAccountsTransactions = null;
			return;
		}
		
		currentAccount = getAccount(accountID);
		
		currentAccountsTransactions = databaseManager.pullAccountsTransactions(currentAccount);
	}
	
	public int numUsersForAccount(int accountID) {
		
		return databaseManager.numUsersForAccount(accountID);
	}
}
