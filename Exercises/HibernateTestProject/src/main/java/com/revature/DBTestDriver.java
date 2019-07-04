package com.revature;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import com.revature.dao.RouteDao;
import com.revature.dao.RouteDaoImpl;
import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.models.Admin;
import com.revature.models.Driver;
import com.revature.models.Manager;
import com.revature.models.Route;
import com.revature.models.RouteNode;
import com.revature.models.User;
import com.revature.util.HibernateUtil;

public class DBTestDriver {
	
	private static Logger log = Logger.getRootLogger();
	
	public static void main(String[] args) {
		
		UserDao userDao = new UserDaoImpl();
		RouteDao routeDao = new RouteDaoImpl();
		
		User user = userDao.getUserByUsername("paul");
//		System.out.println("is user manager?: " + (user instanceof Manager));
		System.out.println(user.toString());
		
		HibernateUtil.closeSessionFactory();
		
		System.out.println("done");
	}
}
