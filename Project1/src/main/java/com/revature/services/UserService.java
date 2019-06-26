package com.revature.services;

import java.util.List;

import com.revature.dao.UserAccountDao;
import com.revature.dao.UserAccountDaoImpl;
import com.revature.model.UserAccount;

public class UserService {
	
	UserAccountDao uDao = new UserAccountDaoImpl();
	
	public List<UserAccount> getUserAccounts() {
		return uDao.getUserAccounts();
	}
	
	public int createUserAccount(UserAccount u) {
		return uDao.createUserAccount(u);
	}
	
	public int updateUserAccount(UserAccount u, int id) {
		return uDao.updateUserAccount(u, id);
	}
	
	public int deleteUserAccount(int id) {
		return uDao.deleteUserAccount(id);
	}
	

}
