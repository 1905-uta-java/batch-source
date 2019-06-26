package com.company.util;


public class ValidationUtil {
	
	
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


}
