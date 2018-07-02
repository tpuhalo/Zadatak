package com.zadatak.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zadatak.daoimpl.ContactDao;
import com.zadatak.domain.Contact;

@Service("contactBase")
public class ContactService extends ContactDao implements ServiceBase<Long, Contact> {

	@Autowired
	ContactDao contact;
	
	@Override
	public List<Contact> getAll() {
		return contact.findAll();
	}

	@Override
	public int create(Contact newInstance) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update(Contact transientObject) {
		// TODO Auto-generated method stub

	}

	@Override
	public Contact findById(Long id) {
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
	public void saveOrUpdate(Contact entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub

	}

}
