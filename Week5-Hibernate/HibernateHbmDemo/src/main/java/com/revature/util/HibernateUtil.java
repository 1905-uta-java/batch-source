package com.revature.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	private static StandardServiceRegistry registry;
	
	private static SessionFactory getSessionFactory() {
		if( sessionFactory == null ) {
			registry = new StandardServiceRegistryBuilder().configure().build();
			MetadataSources sources = new MetadataSources(registry);
			Metadata metadata = sources.getMetadataBuilder().build();
			sessionFactory = metadata.getSessionFactoryBuilder().build();
		}
		return sessionFactory;
	}
	
	public static Session getSession() {
		return getSessionFactory().openSession();
	}
	
	public static void closeSessionFactory() {
		if(sessionFactory == null) {
			return;
		}
		sessionFactory.close();
	}
	

}
