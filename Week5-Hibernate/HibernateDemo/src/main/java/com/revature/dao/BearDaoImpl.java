package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Bear;
import com.revature.util.HibernateUtil;

public class BearDaoImpl implements BearDao {

	@Override
	public List<Bear> getBears() {
		Session s = HibernateUtil.getSession();
		List<Bear> bears = s.createQuery("from Bear", Bear.class).list();
//		for(Bear b: bears) {
//			System.out.println(b);
//		}
		s.close();
		return bears;
	}

	@Override
	public Bear getBearById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int createBear(Bear b) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		int pk = (int) s.save(b);
		tx.commit();
		s.close();
		return pk;
	}

	@Override
	public void updateBear(Bear b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBearById(int bearId) {
		// TODO Auto-generated method stub
		
	}

}
