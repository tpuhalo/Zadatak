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

	String saveNewOrUpdatedContact(Contact contact, Long sexID, Long AddressID);

	String saveNewOrUpdatedAddress(Address address, Long cityID);

	void deleteContact(long contactId);

	String deleteAddress(long addressId);

	Contact prepareContact(long contactId);

	Address prepareAddress(long addressId);

	String saveNewOrUpdatedCity(City city, long countryID);

	String deleteCity(long cityId);


}
