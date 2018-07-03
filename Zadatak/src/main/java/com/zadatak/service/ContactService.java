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
		contact.SaveOrUpdate(entity);
	}

	@Override
	public void deleteById(Long id) {
		contact.deleteById(id);
	}

}
