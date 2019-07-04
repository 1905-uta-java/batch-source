package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.models.Admin;
import com.revature.models.Driver;
import com.revature.models.Manager;
import com.revature.models.User;
import com.revature.util.HibernateUtil;

public class UserDaoImpl implements UserDao {

	public void createDriver(Driver driver) {
		
		Session s = HibernateUtil.getSession();
		Transaction t = s.beginTransaction();
		
		s.save(driver);
		
		t.commit();
		s.close();
	}

	public void createManager(Manager manager) {
		
		Session s = HibernateUtil.getSession();
		Transaction t = s.beginTransaction();
		
		s.save(manager);
		
		t.commit();
		s.close();
	}

	public void createAdmin(Admin admin) {
		
		Session s = HibernateUtil.getSession();
		Transaction t = s.beginTransaction();
		
		s.save(admin);
		
		t.commit();
		s.close();
	}

	public Driver getDriver(int driverId) {
		
		Session s = HibernateUtil.getSession();
		
		Driver driver = s.get(Driver.class, driverId);
		
		s.close();
		
		return driver;
	}

	public Manager getManager(int managerId) {
		
		Session s = HibernateUtil.getSession();
		
		Manager manager = s.get(Manager.class, managerId);
		
		s.close();
		
		return manager;
	}
	
	public Admin getAdmin(int adminId) {
		
		Session s = HibernateUtil.getSession();
		
		Admin admin = s.get(Admin.class, adminId);
		
		s.close();
		
		return admin;
	}
	
	public List<Driver> getDriversForManager(int managerId) {
		
		Session s = HibernateUtil.getSession();
		
		List<Driver> drivers = s.get(Manager.class, managerId).getDrivers();
		
		s.close();
		
		return drivers;
	}
	
	public Manager getManagerForDriver(int driverId) {
		
		Session s = HibernateUtil.getSession();
		
		Manager manager = s.get(Driver.class, driverId).getManager();
		
		s.close();
		
		return manager;
	}
	
	public User getUser(int userId) {
		
		Session s = HibernateUtil.getSession();
		
		User user = s.get(User.class, userId);
		
		s.close();
		
		return user;
	}
	
	public User getUserByUsername(String username) {
		
		Session s = HibernateUtil.getSession();
		
		Query<User> query = s.createQuery("from User where USERNAME = :uVar");
		query.setParameter("uVar", username);
		User user = query.getSingleResult();
		
		s.close();
		
		return user;
	}
	
	public void updateDriver(Driver driver) {
		
		Session s = HibernateUtil.getSession();
		Transaction t = s.beginTransaction();
		
		s.update(driver);
		
		t.commit();
		s.close();
	}

	public void updateManager(Manager manager) {
		
		Session s = HibernateUtil.getSession();
		Transaction t = s.beginTransaction();
		
		s.update(manager);
		
		t.commit();
		s.close();
	}

	public void updateAdmin(Admin admin) {
		
		Session s = HibernateUtil.getSession();
		Transaction t = s.beginTransaction();
		
		s.update(admin);
		
		t.commit();
		s.close();
	}

	public void deleteDriver(int driverId) {
		
		Session s = HibernateUtil.getSession();
		Transaction t = s.beginTransaction();
		
		Driver driver = new Driver();
		driver.setId(driverId);
		
		s.delete(driver);
		
		t.commit();
		s.close();
	}

	public void deleteManager(int managerId) {
		
		Session s = HibernateUtil.getSession();
		Transaction t = s.beginTransaction();
		
		Driver driver = new Driver();
		driver.setId(managerId);
		
		s.delete(driver);
		
		t.commit();
		s.close();
	}

	public void deleteAdmin(int adminId) {
		
		Session s = HibernateUtil.getSession();
		Transaction t = s.beginTransaction();
		
		Admin admin = new Admin();
		admin.setId(adminId);
		
		s.delete(admin);
		
		t.commit();
		s.close();
	}
}
