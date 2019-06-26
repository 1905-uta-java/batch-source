package com.revature.daos;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.User;

public class UserDaoImpl implements UserDao {
	List<User> users = new ArrayList<>();
	
	public UserDaoImpl() {
		users.add(new User(1, "DStoneley", "password", "associate"));
		users.add(new User(2, "o", "p", "manager"));
		users.add(new User(3, "SHarvatt", "password", "associate"));
		users.add(new User(4, "SHindenburg", "password", "associate"));
		users.add(new User(5, "LLanda", "password", "manager"));
		users.add(new User(6, "NPetken", "password", "associate"));
		users.add(new User(7, "GBrennon", "password", "associate"));
		users.add(new User(8, "BDimitrie", "password", "manager"));
		users.add(new User(9, "HPyner", "password", "associate"));
		users.add(new User(10, "LGrebbin", "password", "associate"));
	}
	
	// called in the AuthDelegate to accomplish /login post when attempting to login
	public User authenticatedUser(String username, String password) {
		for(User u: users) {
			if(u.getUsername()!=null && u.getUsername().equals(username)) {
				if(u.getPassword()!=null && u.getPassword().equals(password)) {
					return u;
				}
			}
		}
		return null;
	}

//	@Override
	public List<User> getAll() {
		List<User> userCopy = new ArrayList<>(users);
//		userCopy.stream().forEach(u->u.setPassword("*****"));
		return userCopy;
	}

//	@Override
	public User getById(int id) {
		for(User u: users) {
			if(u.getId() == id) {
				return u;
			}
		}
		return null;
	}
}
