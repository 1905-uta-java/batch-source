package com.company.delegates;

import com.company.model.Employee;
import com.company.services.EmployeeService;
import com.company.util.PasswordEncryptionUtil;

public class AuthDelegate {
	private EmployeeService es = new EmployeeService();
	
	public String authenticate(String email, String password) {
		Employee e = verifyEmployee(email,password);
		
		//Check if invalid email or password was given
		if(e == null) {
			return null;
		}
		
		//Combine email and id to create preToken
		String token = e.getEmpId()+":"+e.getEmail();
		
		//Encrypt preToken to get final verification token
		return token;
	
	}
	
	//Check token if its a valid token
	public boolean isAuth(String token) {
		
		String idStr = token.split(":")[0];
		int id = es.convertIdString(idStr);
		
		String email = token.split(":")[1];
		
		//Get employee with that id
		Employee e = es.getById(id);
		
		if(email.equals(e.getEmail())) {
			return true;
		}
		return false;
		
	}
	
	private Employee verifyEmployee(String email, String password) {
		
		//Make sure neither email or password are null before accessing database
		if(email != null && password != null)
		{
			Employee e = es.getByEmail(email);
			
			//Hash Password
			String encrypted = PasswordEncryptionUtil.encryptPassword(password);
			
			if(encrypted.equals(e.getPassword())) {
				return e;
			}
		}
		
		return null;
	}
	
	
	
}
