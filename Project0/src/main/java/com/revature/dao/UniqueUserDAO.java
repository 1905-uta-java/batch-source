package com.revature.dao;

import java.util.List;

import com.revature.model.UniqueUser;

public interface UniqueUserDAO {
	
	public List<String> getAllUserNames();
	public UniqueUser getUser(int id);
	public boolean createUser(String username, String password);
	public int checkCreds(String username, String password);

	

}
