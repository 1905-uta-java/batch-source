package com.revature.dao;

import java.util.List;

import com.revature.model.ProfileAcc;

public interface ProfileAccDAO {

	
	public ProfileAcc getProfile(int id);
	public List<String> getEmails();
	public boolean createProfile();
}
