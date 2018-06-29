package com.zadatak.service;

import java.io.Serializable;
import java.util.List;
/**
 * Service interface for concrete objects
 * 
 */
public interface ServiceBase<PK extends Serializable, T> {

	public List<T> getAll();

	public int create(T newInstance);

	public void deleteById(Long id);

	public void update(T transientObject);

	public T findById(Long id);

	void flush();

	void clear();

	void deleteAll();

	void saveOrUpdate(T entity);

}
