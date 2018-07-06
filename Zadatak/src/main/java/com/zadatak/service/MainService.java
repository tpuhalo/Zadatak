package com.zadatak.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zadatak.daoimpl.AddressDao;
import com.zadatak.daoimpl.CityDao;
import com.zadatak.daoimpl.ContactDao;
import com.zadatak.daoimpl.CountryDao;
import com.zadatak.daoimpl.SexDao;
import com.zadatak.domain.Address;
import com.zadatak.domain.City;
import com.zadatak.domain.Contact;
import com.zadatak.domain.Country;
import com.zadatak.domain.Sex;

@Service
@Transactional
public class MainService implements ServiceBase {

	@Autowired
	private ContactDao contactDAO;
	@Autowired
	private SexDao sexDAO;
	@Autowired
	private AddressDao addressDAO;
	@Autowired
	private CityDao cityDAO;
	@Autowired
	private CountryDao countryDAO;

	public MainService() {
	}

	@Override
	public List<Contact> getContacts() {
		List<Contact> contacts = contactDAO.findAll();
		for (Contact c : contacts) {
			c.setAddresses(getAddressObject(c.getAddressID()));
			c.setSex(getSexObject(c.getSexID()));
		}
		return contacts;
	}

	private Sex getSexObject(long sexID) {
		Sex sex = sexDAO.getByKey(sexID);
		return sex;
	}

	private Address getAddressObject(long addressID) {
		Address address = addressDAO.getByKey(addressID);
		long cityID = address.getCityID();
		City city = cityDAO.getByKey(cityID);
		long countryID = city.getCountryID();
		Country country = countryDAO.getByKey(countryID);
		city.setCountry(country);
		address.setCity(city);
		return address;
	}

	@Override
	public List<Address> getAddresses() {
		List<Address> addresses = addressDAO.findAll();
		for (Address a : addresses) {
			a.setCity(getCityObject(a.getCityID()));
		}
		return addresses;
	}

	private City getCityObject(long cityID) {
		City city = cityDAO.getByKey(cityID);
		long countryID = city.getCountryID();
		Country country = countryDAO.getByKey(countryID);
		city.setCountry(country);
		return city;
	}

	@Override
	public List<City> getCities() {
		List<City> cities = cityDAO.findAll();
		for (City c : cities) {
			c.setCountry(getCountryObject(c.getCountryID()));
		}
		return cities;
	}

	private Country getCountryObject(long countryID) {
		Country country = countryDAO.getByKey(countryID);
		return country;
	}

	@Override
	public List<Sex> getSexs() {
		List<Sex> sexs = sexDAO.findAll();
		return sexs;
	}

	@Override
	public List<Country> getCountry() {
		List<Country> countries = countryDAO.findAll();
		return countries;
	}

	@Override
	public String saveNewOrUpdatedContact(Contact contact, Long sexID, Long addressID) {
		String error = "";
		contact.setSexID(sexID);
		contact.setAddressID(addressID);
		if (contact != null) {
			boolean check = contactExists(contact);
			if (!check) {
				contactDAO.SaveOrUpdate(contact);
			} else {
				error = "This contact exist in database.";
			}
		}
		return error;
	}

	public boolean contactExists(Contact contact) {
		List<Contact> contacts = contactDAO.findAll();
		return contacts.iterator().next().equals(contact);
	}

	@Override
	public String saveNewOrUpdatedAddress(Address address, Long cityID) {
		String error = "";
		address.setCityID(cityID);
		if (address != null) {
			boolean check = addressExists(address);
			if (!check) {
				addressDAO.SaveOrUpdate(address);
			} else {
				error = "This address exist in database.";
			}
		}
		return error;
	}

	public boolean addressExists(Address address) {
		List<Address> addresses = addressDAO.findAll();
		return addresses.iterator().next().equals(address);
	}

	@Override
	public String saveNewOrUpdatedCity(City city, long countryID) {
		String error = "";
		city.setCountryID(countryID);
		if (city != null) {
			boolean check = cityExists(city);
			if (!check) {
				cityDAO.SaveOrUpdate(city);
			} else {
				error = "This address exist in database.";
			}
		}
		return error;
	}

	public boolean cityExists(City city) {
		List<City> cities = cityDAO.findAll();
		return cities.iterator().next().equals(city);
	}

	@Override
	public void deleteContact(long contactId) {
		contactDAO.deleteById(contactId);
	}

	@Override
	public String deleteAddress(long addressId) {

		List<Contact> contacts = contactDAO.findAll();
		boolean check = false;
		for (Contact contact : contacts) {
			if (contact.getAddressID() == addressId)
				check = true;
		}

		if (!check) {
			addressDAO.deleteById(addressId);
			return "";
		} else {
			Address address = addressDAO.getByKey(addressId);
			return "Address " + address.getStreet() + " " + address.getStreetNumber() + " is important.";
		}
	}

	@Override
	public String deleteCity(long cityId) {

		List<Address> addresses = addressDAO.findAll();
		boolean check = false;
		for (Address address : addresses) {
			if (address.getCityID() == cityId)
				check = true;
		}

		if (!check) {
			cityDAO.deleteById(cityId);
			return "";
		} else {
			City city = cityDAO.getByKey(cityId);
			return "City " + city.getName() + " is important";
		}
	}

	public City prepareCity(long cityId) {
		City city = cityDAO.getByKey(cityId);
		return city;
	}

	@Override
	public Contact prepareContact(long contactId) {
		Contact contact = contactDAO.getByKey(contactId);
		contact.setAddresses(getAddressObject(contact.getAddressID()));
		return contact;
	}

	@Override
	public Address prepareAddress(long addressId) {
		Address address = addressDAO.getByKey(addressId);
		return address;
	}

}
