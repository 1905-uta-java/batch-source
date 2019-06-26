package com.revature.delegates;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.model.Employee;
import com.revature.services.LoginService;

public class LoginDelegate {
	
	private EmployeeDao userDao = new EmployeeDaoImpl(); 
	
	// used to process POST request to "/login" (RequestHelper processPost)
	/*
	public String authenticate(String user, String pass) {
		Employee e  = userDao.authenticatedUser(user, pass);
		System.out.println(u);
		if(u==null|| u.getUserRole()==null) {
			return null;
		}
		return u.getId()+":"+u.getUserRole();
	}
	
	public boolean isAuthorized(String authToken) {
		if(authToken!=null && authToken.split(":").length==2) {
			String idStr = authToken.split(":")[0];
			String roleStr = authToken.split(":")[1];
			if(idStr.matches("^\\d+$")) {
				Employee u = EmployeeDao.getEmployeeById(Integer.parseInt(idStr));
				if(u != null && u.getUserRole().equals(roleStr)) {
					return true;
				}
			}
		}
		return false;
	}
	*/

}
