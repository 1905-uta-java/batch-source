package com.revature.dao;

import java.util.List;

import com.revature.model.Manager;

public interface ManagerDao {
	public List<Manager> getManagers();
	public Manager getManagerById(int id);
	public Manager getManagerByLogin(String mName, String mWord);
	public int createManager(Manager m);
	public int deleteManager(int id);
	public int changeEmail(int id, String eMail);
	public int changePWord(int id, String pWord);
	public int changeUName(int id, String uName);
}
