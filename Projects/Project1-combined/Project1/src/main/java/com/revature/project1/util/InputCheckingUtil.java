package com.revature.project1.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class InputCheckingUtil {
	
	public static boolean isEmailValid(String email) {
		
		String emailCopy = email.toLowerCase();
		
		return emailCopy != null && emailCopy.matches("^[a-z0-9]+((\\-|\\.|_)?([a-z0-9]|\\d))*@[a-z0-9]+\\.[a-z0-9]+$");
	}
	
	public static boolean isDateValid(String dateString) {
		
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		format.setLenient(false);
		
		try {
			
			format.parse(dateString);
			
		} catch(ParseException e) {
			
			return false;
		}
		
		return true;
	}
}
