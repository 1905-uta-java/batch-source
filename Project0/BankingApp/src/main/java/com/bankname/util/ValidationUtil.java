package com.bankname.util;

import java.util.List;

import com.bankname.dao.BankUserDao;
import com.bankname.dao.BankUserDaoImpl;
import com.bankname.model.BankUser;

public class ValidationUtil {
	
	private static BankUserDao ud = new BankUserDaoImpl();
	
	//Makes sure the email is of proper format
	public static boolean validEmail(String email) {
		//Check if a user with that email exists
		String validRegex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		
		//If email matches regex then its valid
		if(email == null) {
			return false;
		}else if(email.matches(validRegex)) {
			return true;
		}else {
			return false;
		}
	}
	
	//Make sure a password given is valid
	public static boolean validPassword(String password) {
		//Make sure the password is valid
		//As of right now check that its not empty
		if(password == null){
			return false;
		}
		else if(password.equals("")) {
			return false;
		}else {
			return true;
		}

	}
	
	//Validate the amount to deposit
	public static boolean validDepositAmount(String amount) {
		//Check that the amount given is an actual double
		
		//Is the string is a number
		try {
			@SuppressWarnings("unused")
			double dblAmount = Double.parseDouble(amount);
		}catch(NumberFormatException | NullPointerException nfe) {
			return false;
		}
		
		return true;
	}
	
	
	//Validate the Amount to Withdraw
	public static boolean validWithdrawAmount(String amount, double balance) {
		//Check that the amount given is a double and is less than balance.
		
		double dblAmount;
		//Is the string is a number
		try {
			dblAmount = Double.parseDouble(amount);
			dblAmount = (double) Math.round(dblAmount * 100)/100;
		}catch(NumberFormatException | NullPointerException nfe) {
			return false;
		}
		
		//Check that the balance is bigger than the amount wanting to be withdrawn
		if(dblAmount <= balance) {
			return true;
		}else {
			return false;
		}
		
	}
	
	//Verify email. Returns true if the email exists in database 
	public static boolean verifyEmail(String email) {
		//email must exist in database
		List<BankUser> listOfUsers = ud.getBankUsers();
		
		//Loop to check if a match exists
		for(BankUser b : listOfUsers) {
			if(b.getEmail().equals(email)) {
				return true;
			}
		}
		
		return false;
	}
	
	//Verify password
	public static boolean verifyPassword(String email, String password) {
		//password must be correct for email
		List<BankUser> listOfUsers = ud.getBankUsers();
		
		String hashPassword = PasswordEncryptionUtil.encryptPassword(password);
		
		//Loop to check if a match exists
		for(BankUser b : listOfUsers) {
			if(b.getEmail().equals(email)) {
				//Now if the password matches return true else false
				if(b.getPassword().equals(hashPassword)) {
					return true;
				}else {
					return false;
				}
			}
		}
		
		return false;
	}
	

}
