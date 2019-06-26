package com.revature.delegate;

import com.revature.dao.ProfileDAO;
import com.revature.dao.ProfileDAOImpl;
import com.revature.model.Profile;

public class AuthenticationDelegate {

	private ProfileDAO pDao = new ProfileDAOImpl();
	
	public String authenticate(String user, String pass) {
		Profile prof = pDao.getUser(user, pass);
		if(prof==null) {
			return null;
		}
		return prof.getEmpId()+":"+prof.getUsername();
	}
	
	public boolean isAuthorized(String authToken) {
		if(authToken!=null&&authToken.split(":").length==2) {
			String idStr = authToken.split(":")[0];
			String usernameStr = authToken.split(":")[1];
			if(idStr.matches("^\\d+$")) {
				Profile prof = pDao.getUserById(Integer.parseInt(idStr));
				if(prof != null && prof.getUsername().equals(usernameStr)) {
					return true;
				}
			}
		}
		return false;
	}
}
