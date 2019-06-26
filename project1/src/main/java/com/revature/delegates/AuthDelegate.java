package com.revature.delegates;

import com.revature.daos.UserDao;
import com.revature.daos.UserDaoImpl;
import com.revature.models.User;

public class AuthDelegate {
	private UserDao userDao = new UserDaoImpl();
	
	public String authenticate(String user, String pass) {
		User u = userDao.authenticatedUser(user,pass);
		
		System.out.println(u);
		
		if(u == null || u.getUserRole() == null) {
			return null;
		}
		
		return u.getUsername() + ":" + u.getEmployeeId() + ":" + u.getUserRole();
	}
	
	public boolean isAuthorized(String authToken) {
		if(authToken != null && authToken.split(":").length == 3){
			String usrnmStr = authToken.split(":")[0];
			String idStr = authToken.split(":")[1];
			String roleStr = authToken.split(":")[2];
			
			if(idStr.matches("^\\d+$")) {
				User u = userDao.getUserByUsername(usrnmStr);
			
				if(u != null && u.getUserRole().equals(roleStr))
					return true;
			}
		}
		return false;
	}

}
