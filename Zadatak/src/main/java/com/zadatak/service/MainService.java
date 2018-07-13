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

/**
 * Service class for spring framework.
 * Here we are coding bussines logic.
 * 
 * @author tpuhalo
 *
 */

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
		return contactDAO.findAll();

	}

	@Override
	public List<Address> getAddresses() {
		return addressDAO.findAll();

	}

	@Override
	public List<City> getCities() {
		return cityDAO.findAll();

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
	public String saveNewContact(Contact contact, Long addressID, Long sexID) {
		String error = "";
		if (contact != null) {
			boolean check = contactExists(contact);
			//if contact exist(checking mail) in database we don't do saving
			if (!check) { //if contact don't exist we setting his parameters and saving it into database
				Address address = addressDAO.getByKey(addressID);
				contact.setAddress(address);
				Sex sex = sexDAO.getByKey(sexID);
				contact.setSex(sex);
				contactDAO.save(contact);
				error = contact.getFirstName() + " " + contact.getLastName() + " added succesfully."; //sending error message
			} else {
				error = "This contact exist in database.";
			}
		}
		return error;
	}

	public boolean contactExists(Contact contact) {
		List<Contact> contacts = contactDAO.findAll();
		boolean check = false;
		if (contacts == null)//if null it doesnt exists
			return check;
		else
			//checking for every contact from database if it equal to requested contact
			for (Contact contactDatabase : contacts) {
				if (contact.equals(contactDatabase))
					check = true;
			}
		return check;
	}

	@Override
	public String saveNewAddress(Address address, Long cityID) {
		String error = "";
		if (address != null) {
			boolean check = addressExists(address);
			if (!check) {
				City city = cityDAO.getByKey(cityID);
				address.setCity(city);
				addressDAO.save(address);
				error = address.getStreet() + " added sucessfully.";
			} else {
				error = "This address exist in database.";
			}
		}
		return error;
	}

	public boolean addressExists(Address address) {
		List<Address> addresses = addressDAO.findAll();
		boolean check = false;
		if (addresses == null)
			return check;
		else
			for (Address addressDatabase : addresses) {
				if (address.equals(addressDatabase))
					check = true;
			}
		return check;
	}

	@Override
	public String saveNewCity(City city, Long countryID) {
		String error = "";
		if (city != null) {
			boolean check = cityExists(city);
			if (!check) {
				Country country = countryDAO.getByKey(countryID);
				city.setCountry(country);
				cityDAO.save(city);
				error = city.getName() + " added succesfully.";
			} else {
				error = "This address exist in database.";
			}
		}
		return error;
	}

	public boolean cityExists(City city) {
		List<City> cities = cityDAO.findAll();
		boolean check = false;
		if (cities == null)
			return false;
		else
			for (City cityDatabase : cities) {
				if (city.equals(cityDatabase))
					check = true;
			}
		return check;
	}

	@Override
	public String deleteContact(long contactId) {
		contactDAO.deleteById(contactId);
		return "Contact deleted.";
	}

	@Override
	public String deleteAddress(long addressID) {

		List<Contact> contacts = contactDAO.findAll();
		boolean check = false;
		for (Contact contact : contacts) { //checking if some contact have address we want to delete
			if (contact.getAddress() == addressDAO.getByKey(addressID)) //if that is true we cannot delete that address
				check = true;
		}

		if (!check) {
			addressDAO.deleteById(addressID);
			return "Address deleted.";
		} else {
			Address address = addressDAO.getByKey(addressID);
			return "Address " + address.getStreet() + " " + address.getStreetNumber() + " can't be deleted..";
		}
	}

	@Override
	public String deleteCity(long cityId) {

		List<Address> addresses = addressDAO.findAll();
		boolean check = false;
		for (Address address : addresses) {
			if (address.getCity() == cityDAO.getByKey(cityId))
				check = true;
		}

		if (!check) {
			cityDAO.deleteById(cityId);
			return "City deleted.";
		} else {
			City city = cityDAO.getByKey(cityId);
			return "City " + city.getName() + " can't be deleted.";
		}
	}

	@Override
	public String deleteCountry(long countryId) {

		List<City> cities = cityDAO.findAll();
		boolean check = false;
		for (City city : cities) {
			if (city.getCountry() == countryDAO.getByKey(countryId))
				check = true;
		}

		if (!check) {
			countryDAO.deleteById(countryId);
			return "Country deleted.";
		} else {
			Country country = countryDAO.getByKey(countryId);
			return "Country " + country.getName() + " can't be deleted.";
		}
	}

	@Override
	public String saveNewCountry(Country country) {
		String error = "";
		if (country != null) {
			boolean check = countryExists(country);
			if (check) {
				countryDAO.save(country);
				error = country.getName() + " added sucessfully.";
			} else {
				error = "This country exist in database.";
			}
		}
		return error;
	}

	@Override
	public City prepareCity(long cityId) {
		return cityDAO.getByKey(cityId);
		
	}

	@Override
	public Contact prepareContact(long contactId) {
		return contactDAO.getByKey(contactId);
	}

	@Override
	public Address prepareAddress(long addressId) {
		return addressDAO.getByKey(addressId);
	}

	@Override
	public Country prepareCountry(long countryID) {
		return countryDAO.getByKey(countryID);
	}

	private boolean countryExists(Country country) {
		List<Country> countries = countryDAO.findAll();
		boolean check = false;
		for (Country countryDatabase : countries) {
			if (country.equals(countryDatabase))
				check = true;
		}
		return check;
	}

	@Override
	public String saveUpdatedCity(City city, Long cityID, Long countryID) {
		city.setId(cityID);
		city.setCountry(countryDAO.getByKey(countryID));
		cityDAO.update(city); //setting parameters of city and updating it into database
		return "City was updated."; //sending back error message
	}

	@Override
	public String saveUpdatedContact(Contact contact, Long contactID, Long addressID, Long sexID) {
		contact.setId(contactID);
		contact.setAddress(addressDAO.getByKey(addressID));
		contact.setSex(sexDAO.getByKey(sexID));
		contactDAO.update(contact);
		return "Contact was updated.";
	}

	@Override
	public String saveUpdatedAddress(Address address, Long addressID, Long cityID) {
		address.setId(addressID);
		address.setCity(cityDAO.getByKey(cityID));
		addressDAO.update(address);
		return "Address was updated.";
	}

	@Override
	public String saveUpdatedCountry(Country country, Long countryID) {
		country.setId(countryID);
		countryDAO.update(country);
		return "Country was updated.";
	}

}
