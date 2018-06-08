package com.zadatak.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zadatak.dao.DaoBase;
import com.zadatak.domain.Country;

@Service
public class CountryService extends ServiceClass<Country>{

	@Autowired
	static DaoBase<Country> dao;
	
	public CountryService() {
		super(dao);
	}

}
