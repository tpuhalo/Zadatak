package com.zadatak.dao;

import java.io.Serializable;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

@Repository
public interface DaoBase<PK extends Serializable, T> {

	public T getByKey(PK key);

	public void persist(T entity);
	public void delete(T entity);

	public Criteria createEntityCriteria();

}
