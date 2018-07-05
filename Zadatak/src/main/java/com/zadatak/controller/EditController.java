package com.zadatak.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zadatak.domain.Address;
import com.zadatak.domain.City;
import com.zadatak.domain.Contact;
import com.zadatak.domain.Country;
import com.zadatak.service.AddressService;
import com.zadatak.service.CityService;
import com.zadatak.service.ContactService;
import com.zadatak.service.CountryService;

@Controller
public class EditController {

	@Autowired
	@Qualifier("cityBase")
	CityService cityBase;
	@Autowired
	@Qualifier("contactBase")
	ContactService contactBase;
	@Autowired
	@Qualifier("addressBase")
	AddressService addressBase;
	@Autowired
	@Qualifier("countryBase")
	CountryService countryBase;

	@RequestMapping(value = "/editCity-{id}", method = RequestMethod.GET)
	public String editCity(@PathVariable Long id, ModelMap model) {
		City city = cityBase.findById(id);
		model.addAttribute("cityInfo", city);
		return "manipulation/editCity";
	}

	@RequestMapping(value = { "/ediCity-{id}" }, method = RequestMethod.POST)
	public String updateCity(@Valid City city, BindingResult result, ModelMap model, @PathVariable Long id) {

		if (result.hasErrors()) {
			return "manipulation/editCity";
		}

		cityBase.saveOrUpdate(city);

		model.addAttribute("success", "City " + city.getName() + " edited successfully");
		String page = "cityInfo";
		model.addAttribute("goto", page);
		return "manipulation/succes";
	}

	@RequestMapping(value = "/editAddress-{id}", method = RequestMethod.GET)
	public String editAddress(@PathVariable Long id, ModelMap model) {
		Address address = addressBase.findById(id);
		model.addAttribute("addressInfo", address);
		return "manipulation/editAddress";
	}

	@RequestMapping(value = "/editAddress-{id}", method = RequestMethod.POST)
	public String updateAddress(@Valid Address address, BindingResult result, ModelMap model, @PathVariable Long id) {

		if (result.hasErrors()) {
			return "manipulation/editAddress";
		}

		addressBase.saveOrUpdate(address);

		model.addAttribute("success",
				"Address " + address.getStreet() + " " + address.getStreetNumber() + " edited successfully");
		String page = "addressInfo";
		model.addAttribute("goto", page);
		return "manipulation/succes";
	}

	@RequestMapping(value = "/editContact-{id}", method = RequestMethod.GET)
	public String editContact(@PathVariable Long id, ModelMap model) {
		Contact contact = contactBase.findById(id);
		model.addAttribute("contactInfo", contact);
		return "manipulation/editContact";
	}

	@RequestMapping(value = "/editContact-{id}", method = RequestMethod.POST)
	public String updateContact(@Valid Contact contact, BindingResult result, ModelMap model, @PathVariable Long id) {

		if (result.hasErrors()) {
			return "manipulation/editContact";
		}

		contactBase.saveOrUpdate(contact);

		model.addAttribute("success",
				"Contact " + contact.getFirstName() + " " + contact.getLastName() + " edited successfully");

		String page = "contactInfo";
		model.addAttribute("goto", page);
		return "manipulation/succes";
	}

	@RequestMapping(value = "/editCountry-{id}", method = RequestMethod.GET)
	public String editCountry(@PathVariable Long id, ModelMap model) {
		Country country = countryBase.findById(id);
		model.addAttribute("countryInfo", country);
		return "manipulation/editCountry";
	}

	@RequestMapping(value = "/editCountry-{id}", method = RequestMethod.POST)
	public String updateCountry(@Valid Country country, BindingResult result, ModelMap model, @PathVariable Long id) {

		if (result.hasErrors()) {
			return "manipulation/editCountry";
		}

		countryBase.saveOrUpdate(country);

		model.addAttribute("success", "Country " + country.getName() + " edited successfully");

		String page = "countryInfo";
		model.addAttribute("goto", page);
		return "manipulation/succes";
	}

}
