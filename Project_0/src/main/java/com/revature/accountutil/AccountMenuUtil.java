package com.revature.accountutil;

import java.util.List;

import com.revature.accountdao.AccountDaoImp;
import com.revature.accountmodel.Account;
import com.revature.accountmodel.User;

public class AccountMenuUtil {
	private AccountDaoImp aDao = new AccountDaoImp();
	
	// Validate the user's pin
	public boolean isCorrectPin(User u, int pin) {
		Account a = aDao.getAccountByUId(u.getId());
		if (pin != a.getPin()) {
			return false;
		}
		return true;
	}
	
	// Ask the user to input their pin and then ask for the amount of funds they would like to deposit
		public boolean depositFunds(User u, int pin, double funds) {
			// Create a variable to hold the account
			Account a = aDao.getAccountByUId(u.getId());
			
			// Complete the action
			if(aDao.depositFunds(a, funds) != 0) {
				a = aDao.getAccountById(a.getId());
				System.out.println("$" + String.format("%.2f", funds) + " was deposited to your account, your new balance is $" + 
						String.format("%.2f", a.getBalance()));
				return true;
			}
			return false;
		}
		// Ask the user to input their pin and then ask for the amount of funds they would like to withdraw
		public boolean withdrawFunds(User u, int pin, double funds) {
			// Create a variable to hold the account
			Account a = aDao.getAccountByUId(u.getId());
			
			if(aDao.withdrawFunds(a, funds) != 0) {
				a = aDao.getAccountById(a.getId());
				System.out.println("$" + String.format("%.2f", funds) + " was withdrawn from your account, your new balance is $" + 
						String.format("%.2f", a.getBalance()));
				return true;
			}
			return false;
		}
		// Ask the user to fill in the proper information to create an account
		public boolean createAccount(User u, int pin, double balance) {
			
			List<Account> aList = aDao.getAccounts();
			Account a = new Account(aList.size() + 1, u.getId(), pin, balance);
			if(aDao.createAccount(a) != 0) {
				System.out.println("Your account has been created with a balance of $" + 
						String.format("%.2f", balance));
				return true;
			}
			return false;
		}
		
		// Simply check the balance of the specified account
		public void checkBalance(User u, int pin) {
			// Create a variable to hold the account's pin and the account
			Account a = aDao.getAccountByUId(u.getId());
			
			double bal = aDao.checkBalance(a);
			
			System.out.println("The current balance in your account is $" + 
					String.format("%.2f", bal));
		}
}
