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

}
