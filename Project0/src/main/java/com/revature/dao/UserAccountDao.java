package com.revature.dao;

import java.util.List;

import com.revature.model.Customer;
import com.revature.model.UserAccount;

public interface UserAccountDao {
	
	public List<UserAccount> getUserAccounts();
	public int createUserAccount(UserAccount u);
	public int updateUserAccount(UserAccount u);
	public int deleteUserAccount(UserAccount u);
	public UserAccount getUserAccountByID(int id);

}
