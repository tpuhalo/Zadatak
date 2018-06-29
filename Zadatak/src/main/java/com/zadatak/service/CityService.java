package com.zadatak.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zadatak.daoimpl.CityDao;
import com.zadatak.domain.City;

@Service
public class CityService extends CityDao implements ServiceBase<Long, City> {

	@Override
	public List<City> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteById(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public int create(City newInstance) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update(City transientObject) {
		// TODO Auto-generated method stub

	}

	@Override
	public City findById(Long id) {
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
	public void saveOrUpdate(City entity) {
		// TODO Auto-generated method stub

	}

}
