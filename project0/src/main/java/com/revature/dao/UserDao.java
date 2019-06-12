package com.revature.dao;

import java.util.List;

import com.revature.models.User;

public interface UserDao {
	public List<User> getUsers();
	public User getSingleUser(String username);
	public int createUser(User u);
	public boolean checkUsername(String username);
	public boolean checkPassword(String username, String password);
	public int getNewAccNum();
	
}
