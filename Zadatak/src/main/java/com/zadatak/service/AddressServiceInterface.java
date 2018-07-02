package com.zadatak.service;

import com.zadatak.domain.Address;


public interface AddressServiceInterface extends ServiceBase<Long, Address> {
	public void deleteById(Long id);

	public int create(Address newInstance);

	public void update(Address transientObject);

	public Address findById(Long id);

	public void flush();

	public void clear();

	public void deleteAll();

	public void saveOrUpdate(Address entity);
}
