package com.zadatak.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;


public interface DaoBase<PK extends Serializable, T> {
	
	public Criteria createEntityCriteria();
	
	List<T> findAll();
	
	public T getByKey(PK key);

	void SaveOrUpdate(T entity);
	
	public void delete(T entity);

}
