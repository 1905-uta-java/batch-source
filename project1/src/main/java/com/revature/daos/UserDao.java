package com.revature.daos;

import java.util.List;

import com.revature.models.User;

public interface UserDao {
	public List<User> getAllUsers();
	public User getUserByUsername(String username);
	public int createUser(User u);
	public boolean checkUsername(String username);
	public boolean checkPassword(String username, String password);
	public int deleteAccount(String username);
	public int updateLogin(User u);
	public User authenticatedUser(String user, String pass);
}
