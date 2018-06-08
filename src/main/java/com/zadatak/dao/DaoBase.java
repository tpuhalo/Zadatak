package com.zadatak.dao;

import java.io.Serializable;
import java.util.List;

public interface DaoBase<T> {

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
	public T findById(int id);

	void flush();

	void clear();

	void deleteAll();

	void saveOrUpdate(T entity);

	Serializable save(T entity);
}
