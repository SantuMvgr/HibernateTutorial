package com.sandyprojects.dao;

import java.io.Serializable;

public interface GenericDAO<T, ID extends Serializable> {

	public void save(T object);
	public void delete(T object);
	
	public T find(T object, ID id);
	
}
