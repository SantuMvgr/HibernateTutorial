package com.sandyprojects.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	private static boolean initialized = false;
	private static ThreadLocal<Session> currentSession = new ThreadLocal<Session>();
	
	public static void init() {
		if(initialized) return;
		Configuration configuration = new AnnotationConfiguration();
		sessionFactory = configuration.configure().buildSessionFactory();
		
		initialized = true;
	}
	
	
	public static void setSessionFactory(SessionFactory sessionFactory) {
		HibernateUtil.sessionFactory = sessionFactory;
	}
	
	public static Session startTransaction() {
		Session session = currentSession.get();
		if(session != null) {
			System.out.println("Attempt to create nested transaction!");
		}
		session = sessionFactory.openSession();
		session.beginTransaction();
		currentSession.set(session);
		
		return session;
	}
	
	public static Session getNewSession() {
		return sessionFactory.openSession();
	}
	
	public static Session getCurrentSession() {
		return currentSession.get();
	}
	
	public static void commitTransaction() {
		Session session = currentSession.get();
		session.getTransaction().commit();
	}
	
	public static void rollbackTransaction() {
		Session session = currentSession.get();
		session.getTransaction().rollback();
	}
	
	public static void releaseConnection() {
		Session session = currentSession.get();
		currentSession.remove();
		session.close();
	}
	
}
