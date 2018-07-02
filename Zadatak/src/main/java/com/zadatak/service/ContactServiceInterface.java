package com.zadatak.service;

import com.zadatak.domain.Contact;

public interface ContactServiceInterface extends ServiceBase<Long, Contact> {
	public void deleteById(Long id);

	public int create(Contact newInstance);

	public void update(Contact transientObject);

	public Contact findById(Long id);

	public void flush();

	public void clear();

	public void deleteAll();

	public void saveOrUpdate(Contact entity);
}
