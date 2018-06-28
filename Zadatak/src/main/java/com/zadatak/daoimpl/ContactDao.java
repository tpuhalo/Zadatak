package com.zadatak.daoimpl;

import org.springframework.data.repository.CrudRepository;

import com.zadatak.domain.Contact;

public interface ContactDao extends CrudRepository<Contact, Long> {

}
