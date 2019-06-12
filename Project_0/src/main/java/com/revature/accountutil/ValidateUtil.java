package com.revature.accountutil;

import java.util.List;

import com.revature.accountdao.AccountDaoImp;
import com.revature.accountdao.UserDaoImp;
import com.revature.accountmodel.User;

// Used for validating input from the user
public class ValidateUtil {
	private UserDaoImp uDao = new UserDaoImp();
	private AccountDaoImp aDao = new AccountDaoImp();
	/*
	 * These are methods to handle validating input
	 *  - Make sure that the user has put in a valid password/username
	 *  - Make sure that the user has put in a valid email address
	 *  - Make sure that the user has put in a valid pin
	 *  - Make sure that the user has put in a monetary value
	 */
	
	// Check if the password is valid in length
	public boolean isPassword (String pWord) {
		if(pWord.length() >= 6 && pWord.length() <= 12) {
			return true;
		}
		return false;
	}
	
	public boolean correctPass (String pWord, String uName) {
		List<User> uList = uDao.getUsers();
		for(User u : uList) {
			if(u.getuName().equals(uName) && u.getpWord().equals(pWord)) {
				return true;
			}
		}
		return false;
	}
	
	// Check if the username exists
	public boolean isUsername (String uName) {
		List<User> uList = uDao.getUsers();
		for(User u : uList) {
			if(u.getuName().equals(uName)) {
				return true;
			}
		}
		return false;
	}
	
	// Check if the email input is a valid email address
	public boolean isEmail (String eMail) {
		char[] arr = eMail.toCharArray();
		boolean hasAt = false;
		boolean hasDot = false;
		for(char c : arr) {
			if(c == '@') {
				hasAt = true;
			}
			if(c == '.' && hasAt) {
				hasDot = true;
			}
		}
		if(hasAt && hasDot) {
			return true;
		}
		return false;
	}
	
	// Try to parse the input into a pin value
	public int parsePin (String pin) {
		int hold = -1;
		if(pin.length() == 4) {
			try {
				hold = Integer.parseInt(pin);
			} catch(NumberFormatException e) {
				System.out.println("Error: The input was not a number");
			}
		}
		return hold;
	}
	
	// Try to parse the input into a monetary amount
	public double parseAmount (String bal) {
		double hold = -1;
		try {
			hold = Double.parseDouble(bal);
			String format = String.format("%.2f", hold);
			hold = Double.parseDouble(format);
		} catch(NumberFormatException e) {
			System.out.println("Error: The input was not a number");
		}
		return hold;
	}
}
