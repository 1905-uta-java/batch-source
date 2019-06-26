package com.revature.dao;

import java.util.List;
import com.revature.model.UserAccount;

public interface UserAccountDao {
	
	public List<UserAccount> getUserAccounts();
	public int createUserAccount(UserAccount u);
	public int updateUserAccount(UserAccount u, int id);
	public int deleteUserAccount(int id);
	public UserAccount authenticatedUser(String username, String password, List<UserAccount> users);
	public UserAccount getUserAccountByUsername(String userName);

}
