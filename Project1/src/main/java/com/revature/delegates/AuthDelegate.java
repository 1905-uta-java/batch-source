package com.revature.delegates;

import java.util.ArrayList;
import java.util.List;

import com.revature.dao.UserAccountDao;
import com.revature.dao.UserAccountDaoImpl;
import com.revature.model.UserAccount;

import oracle.net.aso.u;

public class AuthDelegate {
	
	private UserAccountDao uad = new UserAccountDaoImpl();
	
	public String authenticate(String username, String password) {
		List<UserAccount> users = new ArrayList<>();
		users = uad.getUserAccounts();
		UserAccount u = uad.authenticatedUser(username, password, users);
		//System.out.println(u);
		if (u == null) {
			return null;
		}
		
		return u.getUsername() + ":" + u.getPassword() + ":" + u.getIsManager();
	}
	

}
