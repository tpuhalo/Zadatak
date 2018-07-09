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
	
	List<Country> getCountry();

	List<Sex> getSexs();
	
	
	String saveNewCity(City city, Long countryID);

	String saveNewAddress(Address address, Long cityID);

	String saveNewContact(Contact contact, Long addressID, Long sexID);

	String saveNewCountry(Country country);



	String deleteContact(long contactId);

	String deleteAddress(long addressId);

	String deleteCity(long cityId);

	String deleteCountry(long countryId);


	Contact prepareContact(long contactId);

	Address prepareAddress(long addressId);

	Country prepareCountry(long countryID);

	City prepareCity(long cityId);
	
	


	String saveUpdatedAddress(Address address, Long addressID, Long cityID);

	String saveUpdatedCountry(Country country, Long countryID);

	String saveUpdatedContact(Contact contact, Long contactID, Long addressID, Long sexID);

	String saveUpdatedCity(City city, Long cityID, Long countryID);



}
