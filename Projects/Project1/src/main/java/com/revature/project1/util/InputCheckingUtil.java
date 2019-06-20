package com.revature.project1.util;

public class InputCheckingUtil {
	
	public static boolean isEmailValid(String email) {
		
		String emailCopy = email.toLowerCase();
		
		return emailCopy != null && emailCopy.matches("^[a-z0-9]+((\\-|\\.|_)?([a-z0-9]|\\d))*@[a-z0-9]+\\.[a-z0-9]+$");
	}
}
