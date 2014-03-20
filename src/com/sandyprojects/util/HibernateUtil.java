package com.sandyprojects.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private SessionFactory sessionFactory;
	
	public SessionFactory buildSessionFactory() {
		Configuration configuration = new AnnotationConfiguration();
		sessionFactory = configuration.configure().buildSessionFactory();
		
		return sessionFactory;
	}
	
	public Session openSession() {
		return sessionFactory.openSession();
	}
	
	public void closeSession(Session session) {
		session.close();
	}
	
	public void beginTransaction() {
		if(sessionFactory == null)
			buildSessionFactory();
			sessionFactory.openSession().beginTransaction();
	}
	
	public void commitTransaction() {
		sessionFactory.getCurrentSession().getTransaction().commit();
	}
	
}
