package com.zadatak.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;


public interface DaoBase<PK extends Serializable, T> {

	public T getByKey(PK key);

	public void persist(T entity);
	public void delete(T entity);

	public Criteria createEntityCriteria();

	List<T> findAll();

	void SaveOrUpdate(T entity);

}
