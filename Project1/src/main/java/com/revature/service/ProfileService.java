package com.revature.service;

import java.util.List;

import com.revature.dao.ProfileDAO;
import com.revature.dao.ProfileDAOImpl;
import com.revature.model.Profile;

public class ProfileService {
	
	private ProfileDAO profDao = new ProfileDAOImpl();
	//Implement some validation
	public List<String> getAllUsernames(){
		return profDao.getUsernames();
	}
	
	public Profile getUserByUserName(String username, String password) {
		if(username != null && username != "") {
		return profDao.getUser(username, password);
		} else return null; 
		
	}
	
	public Profile getUserById(int id) {
		if(id > 0) {
			return profDao.getUserById(id);
		} else return null;
	}
	
	public int createProfile(String username, String password, int empId) {
		if(username != null && username != "") {
			if(password != null && password.length() > 8) {
				if(empId > 0) {
					return profDao.createProfile(username, password, empId);
				}
			}
		}
		return 0;
	}
	
	public int setPassword(String password, int empId) {
			if(password != null && password.length() > 8) {
				if(empId > 0) {
		return profDao.setPassword(password, empId);
				}
			}
		return 0;
	}
	
	public int setUsername(String newName, int empId) {
			if(newName != null && newName != "") {
				if(empId > 0) {
					return profDao.setUsername(newName, empId);
				}
			}
		return 0;
	}

}
