package com.zadatak.daoimpl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.zadatak.dao.DaoBase;

@SuppressWarnings("unchecked")
public abstract class DaoClass<T> implements DaoBase<T> {

	private final Class<T> entityClass;

	public DaoClass() {
		this.entityClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}
	
	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public T findById(int id) {
		return (T) getSession().get(this.entityClass, id);
	}

	@Override
	public Serializable save(T entity) {
		return getSession().save(entity);
	}

	@Override
	public void saveOrUpdate(T entity) {
		getSession().saveOrUpdate(entity);
	}

	@Override
	public void delete(T entity) {
		getSession().delete(entity);
	}

	@Override
	public void deleteAll() {
		List<T> entities = getAll();
		for (T entity : entities) {
			getSession().delete(entity);
		}
	}

	@Override
	public List<T> getAll() {
		return getSession().createNamedQuery("FROM" + entityClass.getName().toLowerCase()).list();
	}


	@Override
	public void clear() {
		getSession().clear();

	}

	@Override
	public void flush() {
		getSession().flush();

	}
	 
}
