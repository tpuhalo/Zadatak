package com.zadatak.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zadatak.daoimpl.AddressDao;
import com.zadatak.domain.Address;

@Service
public class AddressService extends AddressDao implements ServiceBase<Long, Address> {

	@Override
	public List<Address> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int create(Address newInstance) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update(Address transientObject) {
		// TODO Auto-generated method stub

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
	public void saveOrUpdate(Address entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub

	}

}
