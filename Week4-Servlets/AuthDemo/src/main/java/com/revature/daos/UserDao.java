package com.revature.daos;

import com.revature.models.User;

public interface UserDao {

	public User authenticatedUser(String username, String pass);
	// other crud methods
	
}
