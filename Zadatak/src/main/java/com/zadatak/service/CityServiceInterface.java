package com.zadatak.service;

import com.zadatak.domain.City;


public interface CityServiceInterface extends ServiceBase<Long, City> {
	public void deleteById(Long id);

	public int create(City newInstance);

	public void update(City transientObject);

	public City findById(Long id);

	public void flush();

	public void clear();

	public void deleteAll();

	public void saveOrUpdate(City entity);
}
