package com.zadatak.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zadatak.daoimpl.AddressDao;
import com.zadatak.domain.Address;

@Service("addressBase")
public class AddressService extends AddressDao implements ServiceBase<Long, Address> {

	@Autowired
	AddressDao address;

	@Override
	public List<Address> getAll() {
		return address.findAll();
	}

	@Override
	public Address findById(Long id) {
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
<<<<<<< HEAD
	public void saveOrUpdate(Address entity) {
		address.SaveOrUpdate(entity);
=======
	public String saveOrUpdate(Address entity) {
		address.SaveOrUpdate(entity);
		return null;
>>>>>>> git head fatal new commit
=======
	public void saveOrUpdate(Address entity) {
		address.SaveOrUpdate(entity);
>>>>>>> 95a346ea9318b7d9bfd78bd20dd538a1febc2151

	}

	@Override
	public void deleteById(Long id) {
		
		
		address.deleteById(id);

	}

}
