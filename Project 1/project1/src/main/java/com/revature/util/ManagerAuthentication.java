package com.revature.util;

import java.util.List;

import com.revature.doa.ManagerDoa;
import com.revature.model.Manager;

public class ManagerAuthentication {
	public static boolean isManagerLogIn(String user, String pass) {
		ManagerDoa md = new ManagerDoa();
		List<Manager>managers =  md.getManagers();
		for(Manager m : managers) {
			if(m.getUsername().equals(user) && m.getPassword().equals(pass)) {
				return true;
			}
		}
		return false;
		
	}
	
	public static Manager user(String user, String pass) {
		Manager manager = null;
		ManagerDoa ed = new ManagerDoa();
		List<Manager>man = ed.getManagers();
		for(Manager m: man) {
			if(m.getUsername().equals(user) && m.getPassword().equals(pass)) {
				manager = m;
			}
		}
		return manager.safeManager();
	}
	
	public static boolean managerConfirmation(String fn, String ln, String un, String pass) {
		if(fn != null && ln !=null && un != null && pass != null) {
			return true;
		}
		return false;
	}
	
	public static boolean isManagerId(String id) {
		ManagerDoa md = new ManagerDoa();
		if( id != null && Integer.parseInt(id) > 20000) {
			int manId = Integer.parseInt(id);
			if(manId < md.highestIdNumber()) {
				return true;
			}
		}
		return false;
	}
	
}
