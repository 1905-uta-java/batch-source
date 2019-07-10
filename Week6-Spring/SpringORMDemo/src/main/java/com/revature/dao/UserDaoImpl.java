package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sf;
	
	@Override
	@Transactional(propagation=Propagation.SUPPORTS)
	public List<User> getUsers() {
		Session s = sf.getCurrentSession();
		List<User> users = s.createQuery("from User").list();
		return users;
	}

	@Override
	@Transactional//(propagation=Propagation.MANDATORY)
	public User getUserById(int id) {
		Session s = sf.getCurrentSession();
		User u = (User) s.get(User.class, id);
		return u;
	}

	

}
