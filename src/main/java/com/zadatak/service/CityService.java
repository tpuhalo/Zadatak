package com.zadatak.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zadatak.dao.DaoBase;
import com.zadatak.domain.City;
import com.zadatak.domain.Country;

@Service
public class CityService extends ServiceClass<City> {

	@Autowired
	static DaoBase<City> dao;

	public CityService() {
		super(dao);
	}
	
	 @Override
	 public List<City> getAll() {
	 List<City> list = new ArrayList<>();
	 list.add(new City(0, "zagreb", "1000", new Country(1, "hrv", "hr", "hrv")));
	
	 return list;
	 }
	
	

}
