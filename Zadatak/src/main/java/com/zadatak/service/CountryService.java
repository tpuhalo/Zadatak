package com.zadatak.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zadatak.daoimpl.CityDao;
import com.zadatak.daoimpl.ContactDao;
import com.zadatak.daoimpl.CountryDao;
import com.zadatak.domain.Country;

@Service("countryBase")
public class CountryService extends ContactDao implements ServiceBase<Long, Country> {

	@Autowired
	CountryDao country;
	@Autowired
	CityDao city;

	@Override
	public List<Country> getAll() {
		// TODO Auto-generated method stub
		return country.findAll();
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
		saveOrUpdate(entity);

	}

	@Override
	public void deleteById(Long id) {
		if (!city.findAll().iterator().next().getCountry().getName().equals(country.findAll().iterator().next().getName()))
		country.deleteById(id);
	}

}
