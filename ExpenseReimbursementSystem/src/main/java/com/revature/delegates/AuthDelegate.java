package com.revature.delegates;

import com.revature.models.Employee;
import com.revature.services.EmployeeService;

public class AuthDelegate {
	
	private EmployeeService eService = new EmployeeService();
	
	// used to process POST request to "/login" (RequestHelper processPost)
	public String authenticate(String user, String pass) {
		Employee e = eService.authenticatedUser(user, pass);
		System.out.println(e);
		if(e==null|| e.getTitle()==null) {
			return null;
		}
		return e.getId()+":"+e.getTitle();
	}
	
	public boolean isAuthorized(String authToken) {
		if(authToken!=null && authToken.split(":").length==2) {
			String idStr = authToken.split(":")[0];
			String roleStr = authToken.split(":")[1];
			if(idStr.matches("^\\d+$")) {
				Employee e = eService.getEmployeeById(Integer.parseInt(idStr));
				if(e != null && e.getTitle().equals(roleStr)) {
					return true;
				}
			}
		}
		return false;
	}

}
