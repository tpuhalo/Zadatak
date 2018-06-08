package com.zadatak.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zadatak.dao.DaoBase;
import com.zadatak.domain.Address;

@Service
public class AddressService extends ServiceClass<Address>{

	@Autowired
	static DaoBase<Address> dao;
	
	public AddressService() {
		super(dao);
	}

}
