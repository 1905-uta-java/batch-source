package com.revature.accountdao;

import java.util.List;

import com.revature.accountmodel.User;

// Interface to handle DAO of the Account table communication
public interface UserDao {
	// Interface Methods
	public List<User> getUsers();
	public User getUserById(int id);
	public User getUserByLogin(String usName, String paWord);
	public int createUser(User u);
	public int deleteUser(int id);
	public int changePassword(User u);
	public int changeUsername(User u);
	public int changeEmail(User u);
}
