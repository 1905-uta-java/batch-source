package com.revature.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.models.Cave;
import com.revature.util.HibernateUtil;

public class CaveDaoImpl implements CaveDao {

	@Override
	public List<Cave> getCaves() {
		Session s = HibernateUtil.getSession();
		Query<Cave> q = s.createQuery("from Cave", Cave.class);
		List<Cave> caves = q.list();
		s.close();
		return caves;
	}

	@Override
	public Cave getCaveById(int id) {
		Session s = HibernateUtil.getSession();
		Cave c = s.get(Cave.class, id);
		s.close();
		return c;
	}

	@Override
	public int createCave(Cave c) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		int cavePK = (int) s.save(c);
		tx.commit();
		s.close();
		return cavePK;
	}

	@Override
	public void updateCave(Cave c) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.merge(c);
		tx.commit();
		s.close();
	}

	@Override
	public void deleteCaveById(int caveId) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
//		Cave c = new Cave();
//		c.setId(caveId);
		s.delete(new Cave(caveId));
		tx.commit();
		s.close();
		
	}

}
