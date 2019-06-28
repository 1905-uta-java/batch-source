package com.revature.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.models.Bear;
import com.revature.util.HibernateUtil;

public class BearDaoImpl implements BearDao {

	@Override
	public List<Bear> getBears() {
		Session s = HibernateUtil.getSession();
		List<Bear> bears = s.createQuery("from Bear", Bear.class).list();
		s.close();
		return bears;
	}

	/*
	 * 
	 * READ OPERATIONS: 
	 * HQL (Query)
	 * CriteriaQuery
	 * Native SQL (Query)
	 * get
	 * 	 - eager fetching strategy
	 * 	 - returns null when object w requested identifier is not in db
	 * load
	 *   - lazy fetching strategy
	 *   - return proxy, data is loaded into that proxy when requested
	 *   - if data is requested outside of the scope of the session before it's been accessed
	 *   	load throws LazyInitializationException
	 *   - if the object is not in the DB, throws ObjectNotFoundException
	 */
	@Override
	public Bear getBearById(int id) {
		Session s = HibernateUtil.getSession();
		
		// Method 0: using session method to get one 
//		Bear b = s.get(Bear.class, id);
		
		// Method 1: using session method to get one 
//		Bear b = s.load(Bear.class, id);
//		System.out.println(b);
		
		// Method 2: using HQL query to get one
//		Query<Bear> query = s.createQuery("from Bear where id = :idVar");
//		query.setParameter("idVar", id);
//		Bear bear = query.getSingleResult();
		
		// Method 3: using saved HQL query to get one
		Query<Bear> query = s.getNamedQuery("getByIdQuery");
		query.setParameter("idVar", id);
		Bear bear = query.getSingleResult();
		s.close();
		return bear;
	}

	/*
	 * here we can use save or persist
	 * - both attempt to make an object persistent
	 * 
	 * save:
	 * - returns serializable id - returns the primary key of our persisted object
	 * - can make a transient and a detached object persistent
	 * - can execute an INSERT statement outside of transactional boundaries if 
	 * 		it's the only way to get the PK
	 * 
	 * persist:
	 * - doesn't assure pk immediately
	 * - void return type
	 * - throws an exception if we attempt to make a detached object persistent
	 * - will never execute non-transactionally
	 * 
	 */
	@Override
	public int createBear(Bear b) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		int pk = (int) s.save(b);
		tx.commit();
		s.close();
		return pk;
	}

	/*
	 * here we can use update or merge
	 * - attempt to make a detached object persistent
	 * 
	 * update:
	 * - if there's already a persistent object in the session with the same ID
	 * 		throws a NonUniqueObjectException
	 * - void
	 * - throws an exception if there isn't a record with the given ID 
	 * 
	 * merge:
	 * - if there is a persistent object which already has the given ID, the given 
	 * 		object will be merged with the persistent object
	 * - can be used regardless of the object state
	 * - returns merged object
	 * 
	 */
	@Override
	public void updateBear(Bear b) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		// we run no risk of a NonUniqueObject because we don't have any
			// other persistent objects in the scope of this session
		s.update(b); 
		tx.commit();
		s.close();
	}

	@Override
	public void deleteBearById(int bearId) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.delete(new Bear(bearId));
		tx.commit();
		s.close();
		
	}

	@Override
	public List<Bear> getBearsByName(String name) {
		Session s = HibernateUtil.getSession();
		String sql = "SELECT * FROM BEAR WHERE BEAR_NAME = ?";
		Query<Bear> q = s.createNativeQuery(sql, Bear.class);
		q.setParameter(1, name);
		List<Bear> bears = q.list();
		s.close();
		return bears;
	}

	@Override
	public List<Bear> getBearsByNameWithCritQ(String name) {
		Session s = HibernateUtil.getSession();
		
		CriteriaBuilder cb = s.getCriteriaBuilder();
		CriteriaQuery<Bear> cq = cb.createQuery(Bear.class);
		Root<Bear> root = cq.from(Bear.class);
		cq.select(root); // allows us to get one column, since we're not retrieving a specific column we can just say root
		cq.where(cb.equal(root.get("name"), name));
		
		Query<Bear> q = s.createQuery(cq);
		List<Bear> bears = q.list();
		
		s.close();
		return bears;
	}

	@Override
	public List<Bear> getYBears() {
		Session s = HibernateUtil.getSession();
		
		CriteriaBuilder cb = s.getCriteriaBuilder();
		CriteriaQuery<Bear> cq = cb.createQuery(Bear.class);
		
		Root<Bear> root = cq.from(Bear.class);
		cq.select(root); // root.get("name") to select just my name column
		cq.where(cb.like(root.get("name"), "Y%"));
		
		Query<Bear> q = s.createQuery(cq);
		List<Bear> bears = q.list();
		s.close();
		return bears;
	}

	@Override
	public long getBearCount() {
		Session s = HibernateUtil.getSession();
		
		CriteriaBuilder cb = s.getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		
		Root<Bear> root = cq.from(Bear.class);
		cq.select(cb.count(root));
		
		Query<Long> q = s.createQuery(cq);
		Long count = q.getSingleResult();
		s.close();
		return count;
	}

}
