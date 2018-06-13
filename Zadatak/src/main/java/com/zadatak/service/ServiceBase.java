package com.zadatak.service;

import java.util.List;
/**
 * Service interface for concrete objects
 * 
 */
public interface ServiceBase<T> {

	public List<T> getAll();

	public int create(T newInstance);

	public void delete(final T object);

	public void update(T transientObject);

	public T findById(int id);

	void flush();

	void clear();

	void deleteAll();

	void saveOrUpdate(T entity);

}
