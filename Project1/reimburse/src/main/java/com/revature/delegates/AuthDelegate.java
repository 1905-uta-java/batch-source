package com.revature.delegates;

import com.revature.daos.UserDao;
import com.revature.daos.UserDaoImpl;
import com.revature.models.User;

public class AuthDelegate {
	
	private UserDao userDao = new UserDaoImpl(); 
	
	// used to process POST request to "/login" (RequestHelper processPost)
	public String authenticate(String user, String pass) {
		User u = userDao.authenticatedUser(user, pass);
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
				User u = userDao.getById(Integer.parseInt(idStr));
				if(u != null && u.getUserRole().equals(roleStr)) {
					System.out.println("successful login");
					return true;
				}
			}
		}
		return false;
	}

}
