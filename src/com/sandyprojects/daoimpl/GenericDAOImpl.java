package com.sandyprojects.daoimpl;

import java.io.Serializable;

import org.hibernate.Session;

import com.sandyprojects.dao.GenericDAO;
import com.sandyprojects.util.HibernateUtil;

public class GenericDAOImpl<T, ID extends Serializable> implements GenericDAO<T, ID> {

	private HibernateUtil hibernateUtil = new HibernateUtil();
	private Session session;
	
	public GenericDAOImpl() {
		session = hibernateUtil.buildSessionFactory().openSession();
	}
	
	@Override
	public void save(T object) {
		session.beginTransaction();
		session.save(object);
		session.getTransaction().commit();
	}

	@Override
	public void delete(T object) {
		session.delete(object);		
	}

	@Override
	public T find(T object, ID id) {
		return null;
	}
}
