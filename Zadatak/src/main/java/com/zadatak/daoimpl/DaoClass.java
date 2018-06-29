package com.zadatak.daoimpl;

import java.io.Serializable;

import java.lang.reflect.ParameterizedType;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.zadatak.dao.DaoBase;


public abstract class DaoClass<PK extends Serializable, T> implements DaoBase<PK,T>{
	
	private final Class<T> persistentClass;
	
	@SuppressWarnings("unchecked")
	public DaoClass(){
		this.persistentClass =(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
	}
	
	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public T getByKey(PK key) {
		return (T) getSession().get(persistentClass, key);
	}

	public void persist(T entity) {
		getSession().persist(entity);
	}

	public void delete(T entity) {
		getSession().delete(entity);
	}
	
	public Criteria createEntityCriteria(){
		return getSession().createCriteria(persistentClass);
	}

}
