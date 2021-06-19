package com.example.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Util {
	
	private static final SessionFactory sessionFactory;
	
	static{
		try{
			sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		}catch (Throwable ex) {
			System.err.println("Session Factory could not be created." + ex);
			throw new ExceptionInInitializerError(ex);
		}	
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
}
