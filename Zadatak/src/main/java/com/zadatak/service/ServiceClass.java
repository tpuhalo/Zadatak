package com.zadatak.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zadatak.dao.DaoBase;

@Service
public abstract class ServiceClass<T> implements ServiceBase<T> {

	DaoBase<T> dao;

	public List<T> getAll() {

		return dao.getAll();
	}

	@Override
	public int create(T newInstance) {
		return dao.create(newInstance);
	}

	@Override
	public void delete(final T object) {
		dao.delete(object);
	}

	@Override
	public void update(T object) {
		dao.update(object);
	}

	@Override
	public T findById(int id) {
		return dao.findById(id);
	}

	@Override
	public void flush() {
		dao.flush();
	}

	@Override
	public void clear() {
		dao.clear();
	}

	@Override
	public void deleteAll() {
		dao.deleteAll();
		;
	}

	@Override
	public void saveOrUpdate(T entity) {
		dao.saveOrUpdate(entity);
	}

}
