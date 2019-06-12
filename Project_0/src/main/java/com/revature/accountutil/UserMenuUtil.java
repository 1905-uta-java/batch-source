package com.revature.accountutil;

import java.util.List;

import com.revature.accountdao.UserDaoImp;
import com.revature.accountmodel.User;

public class UserMenuUtil {
	private UserDaoImp uDao = new UserDaoImp();
	
	// Ask the user to put in their username and password and login to their user account
		public User login(String uName, String pWord) {
					
			return uDao.getUserByLogin(uName, pWord);
		}
		// Ask the user to fill in the proper information to create a user account
		public User createUser(String uName, String pWord, String eMail) {
			// Create variables to hold the user information
			int id = -1;
						
			if(uName != "" && pWord != "" && eMail != "") {
				List<User> uList = uDao.getUsers();
				id = uList.size() + 1;
				User u = new User(id, uName, pWord, eMail);
				uDao.createUser(u);
				return u;
			}
			return null;
		}
}
