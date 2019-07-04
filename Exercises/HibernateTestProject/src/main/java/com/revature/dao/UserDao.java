package com.revature.dao;

import java.util.List;

import com.revature.models.Admin;
import com.revature.models.Driver;
import com.revature.models.Manager;
import com.revature.models.User;

public interface UserDao {
	
	void createDriver(Driver driver);
	void createManager(Manager manager);
	void createAdmin(Admin admin);
	
	Driver getDriver(int driverId);
	Manager getManager(int managerId);
	Admin getAdmin(int adminId);
	List<Driver> getDriversForManager(int managerId);
	Manager getManagerForDriver(int driverId);
	User getUser(int userId);
	User getUserByUsername(String username);
	
	void updateDriver(Driver driver);
	void updateManager(Manager manager);
	void updateAdmin(Admin admin);
	
	void deleteDriver(int driverId);
	void deleteManager(int managerId);
	void deleteAdmin(int adminId);
}
