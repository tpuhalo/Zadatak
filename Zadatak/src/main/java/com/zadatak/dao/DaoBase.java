package com.zadatak.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;

/**
 * Interface for DAO class
 * 
 * @author tpuhalo
 *
 * @param <PK>
 * @param <T>
 */

public interface DaoBase<PK extends Serializable, T> {

	public Criteria createEntityCriteria();

	/**
	 * Dao class for getting all object type T from database.
	 * 
	 * @return List<T>
	 */
	List<T> findAll();

	/**
	 * Dao class for getting T object by ID from database.
	 * 
	 * @param key
	 * @return T class
	 */
	public T getByKey(PK key);

	/**
	 * Dao class for deleting T object from database.
	 * 
	 * @param entity
	 */
	public void delete(T entity);

	/**
	 * Dao class for saving new T object to database.
	 * 
	 * @param entity
	 */
	void save(T entity);

	/**
	 * Dao class for updating T object in database.
	 * 
	 * @param entity
	 */
	void update(T entity);

}
