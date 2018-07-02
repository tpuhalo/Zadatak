package com.zadatak.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zadatak.daoimpl.ContactDao;
import com.zadatak.daoimpl.CountryDao;
import com.zadatak.domain.Country;

@Service("countryBase")
public class CountryService extends ContactDao implements ServiceBase<Long, Country> {

	@Autowired
	CountryDao country;

	@Override
	public List<Country> getAll() {
		// TODO Auto-generated method stub
		return country.findAll();
	}

	@Override
	public int create(Country newInstance) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update(Country transientObject) {
		// TODO Auto-generated method stub

	}

	@Override
	public Country findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub

	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveOrUpdate(Country entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub

	}

}
