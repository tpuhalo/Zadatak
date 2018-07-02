package com.zadatak.service;

import com.zadatak.domain.Country;


public interface CountryServiceInterface extends ServiceBase<Long, Country> {
	public void deleteById(Long id);

	public int create(Country newInstance);

	public void update(Country transientObject);

	public Country findById(Long id);

	public void flush();

	public void clear();

	public void deleteAll();

	public void saveOrUpdate(Country entity);
}