package com.zadatak.service;

import java.util.List;

import com.zadatak.domain.Address;
import com.zadatak.domain.City;
import com.zadatak.domain.Contact;
import com.zadatak.domain.Country;
import com.zadatak.domain.Sex;

/**
 * Service interface
 * 
 * @author tpuhalo 
 */
public interface ServiceBase {

	/**
	 * Class for fetching contacts.
	 * 
	 * @return List<Contact>
	 */
	List<Contact> getContacts();

	/**
	 * Class for fetching addresses.
	 * 
	 * @return List<Address>
	 */
	List<Address> getAddresses();

	/**
	 * Class for fetching cities.
	 * 
	 * @return List<City>
	 */
	List<City> getCities();

	/**
	 * Class for fetching countries.
	 * 
	 * @returnList<Country>
	 */
	List<Country> getCountry();

	/**
	 * Class for fetching sexes.
	 * 
	 * @returnList<Sex>
	 */
	List<Sex> getSexs();

	/**
	 * Class for saving new city in database.
	 * 
	 * @param city
	 * @param countryID
	 * @return String
	 */

	String saveNewCity(City city, Long countryID);

	/**
	 *  Class for saving new address in database.
	 *  
	 * @param address
	 * @param cityID
	 * @return String
	 */
	String saveNewAddress(Address address, Long cityID);

	/**
	 *  Class for saving new contact in database.
	 * 
	 * @param contact
	 * @param addressID
	 * @param sexID
	 * @return String
	 */
	String saveNewContact(Contact contact, Long addressID, Long sexID);

	/**
	 *  Class for saving new country in database.
	 * 
	 * @param country
	 * @return String
	 */
	String saveNewCountry(Country country);

	/**
	 * Class for deleting contact by ID from database.
	 * 
	 * @param contactId
	 * @return String
	 */
	String deleteContact(long contactId);

	/**
	 * Class for deleting address by ID from database.
	 * 
	 * @param addressId
	 * @return String
	 */
	String deleteAddress(long addressId);

	/**
	 * Class for deleting city by ID from database.
	 * 
	 * @param cityId
	 * @return String
	 */
	String deleteCity(long cityId);

	/**
	 * Class for deleting country by ID from database.
	 * 
	 * @param countryId
	 * @return String
	 */
	String deleteCountry(long countryId);

	/**
	 * Fetching contact by ID from database.
	 * 
	 * @param contactId
	 * @return Contact
	 */
	Contact prepareContact(long contactId);

	/**
	 * Fetching address by ID from database.
	 * 
	 * @param addressId
	 * @return Address
	 */
	Address prepareAddress(long addressId);

	/**
	 * Fetching country by ID from database.
	 * 
	 * @param countryID
	 * @return Country
	 */
	Country prepareCountry(long countryID);

	/**
	 * Fetching city by ID from database.
	 * 
	 * @param cityId
	 * @return City
	 */
	City prepareCity(long cityId);

	/**
	 * Class for saving updated address to database.
	 * 
	 * @param address
	 * @param addressID
	 * @param cityID
	 * @return String
	 */
	String saveUpdatedAddress(Address address, Long addressID, Long cityID);

	/**
	 * Class for saving updated country to database.
	 * 
	 * @param country
	 * @param countryID
	 * @return String
	 */
	String saveUpdatedCountry(Country country, Long countryID);

	/**
	 * Class for saving updated contact to database.
	 * 
	 * @param contact
	 * @param contactID
	 * @param addressID
	 * @param sexID
	 * @return String
	 */
	String saveUpdatedContact(Contact contact, Long contactID, Long addressID, Long sexID);

	/**
	 * Class for saving updated city to database.
	 * 
	 * @param city
	 * @param cityID
	 * @param countryID
	 * @return
	 */
	String saveUpdatedCity(City city, Long cityID, Long countryID);

}
