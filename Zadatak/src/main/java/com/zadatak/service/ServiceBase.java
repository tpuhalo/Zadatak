package com.zadatak.service;

import java.io.Serializable;
import java.util.List;

/**
 * Service interface for concrete objects
 * 
 */
public interface ServiceBase<PK extends Serializable, T> {

	public List<T> getAll();

	public void deleteById(Long id);

	public T findById(Long id);

	void flush();

	void clear();

	void deleteAll();

	String saveOrUpdate(T entity);

}
