package com.zadatak.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zadatak.dao.DaoBase;
import com.zadatak.domain.Contact;

@Service
public class ContactService extends ServiceClass<Contact>{

	@Autowired
	static DaoBase<Contact> dao;
	
	public void setDao(DaoBase<Contact> entityClass) {
		ContactService.dao = entityClass;
		dao.setClass(Contact.class);
	}
	
}
