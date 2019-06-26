package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import com.revature.daos.UserDao;
import com.revature.daos.UserDaoImpl;
import com.revature.models.User;

public class UserService {
	UserDao userDao = new UserDaoImpl();
	List<User> userList = new ArrayList<>();
	User u = null;
	
	public UserService() {
		userList = getAll();
		System.out.println(userList);
	}
	
	public List<User> getAll(){
		return userDao.getAllUsers();
	}
	
	public User getByUsername(String username) {
		System.out.println("GetByUSERNAME HERE. Username = " + username);
		System.out.println("Anwyays, here's the list: " + userList);
		
		for(int i = 0; i<userList.size(); i++) {
			
			if (userList.get(i).getUsername().equals(username)) {
				u = userList.get(i);
				return u;
			}
		}
		return null;
	}
	
	public int create(User u) {
		userList.add(u);
		return userDao.createUser(u);
	}
	
	//return updated user object 
	public User updateUser(User u) {
		this.u = u;
		return u;
	}
	
	public void updateUserDB(User u) {
		for(int i = 0; i< userList.size(); i++) {
			if(userList.get(i).getUsername().equals(u.getUsername())){
				userList.set(i, u);
			}
		}
		
		userDao.updateLogin(u);
	}
	
	public boolean checkUsername(String username) {
		for(int i = 0; i < userList.size(); i++) {
			if(userList.get(i).getUsername().equals(username))
				return true;
		}
		return false;
	}
	
	//update user info on DB, clear the user object 
	public void logout() {
		u = null;
	}
	
	
	public boolean validateUser(String username, String password) {
		if(userDao.checkUsername(username))
			if(userDao.checkPassword(username, password)) 
				return true;
		
		return false;
	}

	
	
	public User getCurrentUser() {
//		if(u = null) {
//			
//		}
//		
		return u;
	}
}
