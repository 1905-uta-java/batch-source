package com.revature.dao;

import java.util.List;

import com.revature.model.Profile;

public interface ProfileDAO {
	
	public List<String> getUsernames();
	public Profile getUser(String username, String password);
	public Profile getUserById(int id);
	public int createProfile(String username, String password, int empId);
	public int setPassword(String password, int empId);
	public int setUsername(String newusername, int empId);

}
