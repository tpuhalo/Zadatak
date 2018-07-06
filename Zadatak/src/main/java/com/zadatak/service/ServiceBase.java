package com.zadatak.service;

import java.util.List;

import com.zadatak.domain.Address;
import com.zadatak.domain.City;
import com.zadatak.domain.Contact;
import com.zadatak.domain.Country;
import com.zadatak.domain.Sex;

/**
 * Service interface for concrete objects
 * 
 */
public interface ServiceBase {

	List<Contact> getContacts();

	List<Address> getAddresses();

	List<City> getCities();

	List<Sex> getSexs();

	List<Country> getCountry();

	void deleteContact(long contactId);

	String deleteAddress(long addressId);

	Contact prepareContact(long contactId);

	Address prepareAddress(long addressId);

	String deleteCity(long cityId);

	String deleteCountry(long countryId);

	String saveNewContact(Contact contact);

	String saveNewAddress(Address address);

	String saveNewCity(City city);

	String saveNewCountry(Country country);


}
