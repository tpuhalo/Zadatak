package com.zadatak.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zadatak.dao.DaoBase;
import com.zadatak.domain.City;

@Service
public class CityService extends ServiceClass<City> {

	@Autowired
	static DaoBase<City> dao;

	public void setDao(DaoBase<City> entityClass) {
		CityService.dao = entityClass;
		dao.setClass(City.class);
	}

}
