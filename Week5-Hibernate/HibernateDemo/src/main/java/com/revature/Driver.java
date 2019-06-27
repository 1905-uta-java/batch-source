package com.revature;

import java.sql.Date;
import java.util.List;

import com.revature.dao.BearDao;
import com.revature.dao.BearDaoImpl;
import com.revature.dao.CaveDao;
import com.revature.dao.CaveDaoImpl;
import com.revature.models.Bear;
import com.revature.models.Cave;
import com.revature.util.HibernateUtil;

public class Driver {

	public static void main(String[] args) {
//		Session s = HibernateUtil.getSession();
//		s.close();
		
		/*
		CaveDao cd = new CaveDaoImpl();
		
		Cave c1 = new Cave("Devil's Ice Box");
		Cave c2 = new Cave("King Philip's Cave");
		Cave c3 = new Cave("Lascaux Cave");
		cd.createCave(c1);
		cd.createCave(c2);
		cd.createCave(c3);
		
		BearDao bd = new BearDaoImpl();
		bd.createBear(new Bear("Smokey", Date.valueOf("1960-02-03"),c1));
		bd.createBear(new Bear("Winnie the Pooh", Date.valueOf("1924-02-03"),c2));
		bd.createBear(new Bear("Yogi", Date.valueOf("1960-07-01"),c1));
		bd.createBear(new Bear("Jacques", Date.valueOf("1991-09-10"),c3));
		*/

		BearDao bd = new BearDaoImpl();

		List<Bear> bears = bd.getBears();
		for(Bear b: bears) {
			System.out.println(b);
		}
		
		HibernateUtil.closeSessionFactory();

	}

}
