package com.zadatak.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface DaoBase<T> {

	public void setClass(Class<T> entityClass);

	/**
	 * Get objects of type T
	 */
	public List<T> getAll();

	/**
	 * Save object of type T
	 * 
	 * @param object
	 * @return true if created false if not created
	 */
	public int create(T newInstance);

	/**
	 * Delete object of type T
	 * 
	 * @param object
	 * @return true if removed false if not removed
	 */
	public void delete(final T object);

	/**
	 * Update Object of type T
	 * 
	 * @param object
	 * @return Object type
	 */
	public void update(T transientObject);

	/**
	 * Find object by 'id' of type T
	 * 
	 * @param identifier
	 * @return Object type
	 */
	public T findById(Long long1);

	void flush();

	void clear();

	void deleteAll();

	void saveOrUpdate(T entity);

}
