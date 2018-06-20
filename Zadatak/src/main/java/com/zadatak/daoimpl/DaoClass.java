package com.zadatak.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zadatak.config.HibernateConfig;
import com.zadatak.dao.DaoBase;

@Repository
@SuppressWarnings("unchecked")
public abstract class DaoClass<T> implements DaoBase<T> {

	private Class<T> entityClass;

	public void setClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	@Autowired
	Session session = HibernateConfig.getSessionFactory().getCurrentSession();

	@Override
	public T findById(int id) {
		return (T) session.get(this.entityClass, id);
	}

	@Override
	public int create(T entity) {
		return (int) session.save(entity);
	}

	@Override
	public void saveOrUpdate(T entity) {
		session.saveOrUpdate(entity);
	}

	@Override
	public void delete(T entity) {
		session.delete(entity);
	}

	@Override
	public void deleteAll() {
		List<T> entities = getAll();
		for (T entity : entities) {
			session.delete(entity);
		}
	}

	@Override
	public List<T> getAll() {
		session.beginTransaction();
		List<T> result = session.createQuery("select * from " + this.entityClass.getName().toLowerCase()).list();
		session.close();
		;
		return result;
	}

	@Override
	public void clear() {
		session.clear();

	}

	@Override
	public void flush() {
		session.flush();

	}

}
