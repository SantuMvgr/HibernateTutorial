package com.sandyprojects.daoimpl;

import java.io.Serializable;

import com.sandyprojects.dao.GenericDAO;
import com.sandyprojects.util.HibernateUtil;

public class GenericDAOImpl<T, ID extends Serializable> implements GenericDAO<T, ID> {

	protected HibernateUtil hibernateUtil = new HibernateUtil();
	
	@Override
	public void save(T object) {
		HibernateUtil.startTransaction();
		HibernateUtil.getCurrentSession().save(object);
		HibernateUtil.commitTransaction();
		HibernateUtil.releaseConnection();
		
	}

	@Override
	public void delete(T object) {
		HibernateUtil.startTransaction();
		HibernateUtil.getCurrentSession().delete(object);
		HibernateUtil.commitTransaction();
		HibernateUtil.releaseConnection();
	}

	@Override
	public T find(T object, ID id) {
		return null;
	}
}
