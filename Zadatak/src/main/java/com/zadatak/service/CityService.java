package com.zadatak.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zadatak.daoimpl.CityDao;
import com.zadatak.domain.City;

@Service("cityBase")
public class CityService extends CityDao implements ServiceBase<Long, City> {

	@Autowired
	CityDao city;

	@Override
	public List<City> getAll() {
		return city.findAll();
	}

	public void deleteById(Long id) {
		city.deleteById(id);
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
<<<<<<< HEAD
	public void saveOrUpdate(City entity) {
		city.SaveOrUpdate(entity);
=======
	public String saveOrUpdate(City entity) {
		city.SaveOrUpdate(entity);
		return null;
>>>>>>> git head fatal new commit
	}

}
