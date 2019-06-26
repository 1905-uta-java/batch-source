package com.revature.util;

import java.util.List;

import com.revature.dao.EmployeeDaoImp;
import com.revature.dao.ManagerDaoImp;
import com.revature.model.Employee;
import com.revature.model.Manager;

public class ValidationUtil {
	// DAOS
	EmployeeDaoImp eDao = new EmployeeDaoImp();
	ManagerDaoImp mDao = new ManagerDaoImp();
	
	// Validate if the email is in the right format and if it's unique
	public boolean validateEmail(String eMail) {
		// Variables
		char[] eMailChars = eMail.toCharArray();
		boolean hasAt = false;
		boolean hasDot = false;
		
		// Make sure there are no illegal characters
		if(!this.validateIllegalChars(eMail)) {
			return false;
		}
		
		// Loop through the email to see if is in the proper format
		for(char c : eMailChars) {
			if(c == '@') {
				hasAt = true;
			} if(c == '.' && hasAt) {
				hasDot = true;
			}
		}
		
		if(hasAt && hasDot) {
			// TODO check the managers and employees for the email
			
			return true;
		}
		return false;
	}
	
	// Validate if the Username exists already
	public boolean validateUname(String uName) {
		List<Employee> emps = eDao.getEmployees();
		List<Manager> mans = mDao.getManagers();
		
		// Make sure there are no illegal characters
		if(!this.validateIllegalChars(uName)) {
			return false;
		}
		
		for(Employee emp : emps) {
			if(emp.getUserName().equals(uName)) {
				return true;
			}
		}
		for(Manager man : mans) {
			if(man.getUserName().equals(uName)) {
				return true;
			}
		}
		
		return false;
	}
	
	// Validate that the password is the right length and has no illegal characters
	public boolean validatePword(String pWord) {
		if(pWord.length() >= 6 && pWord.length() <= 18) {
			if(this.validateIllegalChars(pWord)) {
				return true;
			}
		}
		return false;
	}
	
	// Check if the amount put in parses and return it in the right format
	public double validateAmount(String amount) {
		double returnAmount = -1.00;
		
		try {
			// Attempt to parse the amount
			returnAmount = Double.parseDouble(amount);
			// If a non 0 and non negative amount was put in then format it correctly, otherwise set it to the failure value
			if(returnAmount > 0.00) {
				String hold = String.format("%.2f", returnAmount);
				returnAmount = Double.parseDouble(hold);
			} else {
				returnAmount = -1.00;
			}
		} catch(NumberFormatException e) {
			System.out.println("Failed to parse amount: " + amount);
		}
		
		return returnAmount;
	}
	
	// Try to parse the number
	public int validateInt(String num) {
		int returnNum = -1;
		
		try {
			returnNum = Integer.parseInt(num);
		} catch(NumberFormatException e) {
			System.out.println("Failed to parse integer: " + num);
		}
		
		return returnNum;
	}
	
	// Make sure there aren't any illegal characters in the string
	public boolean validateIllegalChars(String input) {
		char[] inputChars = input.toCharArray();
		
		for(char c : inputChars) {
			if(c == ';') {
				return false;
			} else if(c == ':') {
				return false;
			} else if(c == ' ') {
				return false;
			}
		}
		
		return true;
	}
	
	// Make sure that the manager id is an id that a manager actually has
	public boolean validateManId(int mId) {
		List<Manager> mans = mDao.getManagers();
		
		for(Manager m : mans) {
			if(m.getId() == mId) {
				return true;
			}
		}
		
		return false;
	}
	
	// Make sure that the name inputed is a valid name
	public boolean validateName(String name) {
		char[] inputChars = name.toCharArray();
		
		for(char c : inputChars) {
			if(!(c >= 97 && c <= 122) && !(c >= 65 && c <= 90)) {
				return false;
			}
		}
		
		return true;
	}
}
