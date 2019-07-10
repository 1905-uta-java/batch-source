package com.revature;

import java.util.List;

import com.revature.dao.CaveDao;
import com.revature.dao.CaveDaoImpl;
import com.revature.models.Cave;
import com.revature.util.HibernateUtil;

public class Driver {

	public static void main(String[] args) {

//		Session s = HibernateUtil.getSession();
//		s.close();
		
		CaveDao cd = new CaveDaoImpl();
		
		/*
		Cave c1 = new Cave("Devil's Ice Box");
		Cave c2 = new Cave("King Philip's Cave");
		Cave c3 = new Cave("Lascaux Cave");
		// c1, c2, and c3 are transient
		
		cd.createCave(c1);
		// c1 is detached, c2 and c3 are still transient
		
		cd.createCave(c2);
		// c1 and c2 are detached, c3 is still transient
		
		cd.createCave(c3);
		// c1, c2, and c3 are detached
		*/
		
//		System.out.println(cd.getCaveById(3));
//		List<Cave> caves = cd.getCaves();
//		for(Cave c: caves) {
//			System.out.println(c);
//		}
		

		
//		Cave c = cd.getCaveById(2);
//		System.out.println(c);
//		c.setName("King Philip's Cave");
//		cd.updateCave(c);
//		System.out.println(c);
		
		
//		cd.deleteCaveById(4);
		
		
		
		
//		HibernateUtil.closeSessionFactory();
		
	}

}
