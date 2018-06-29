package com.zadatak.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
	CityService cityBase;
	@Autowired
	ContactService contactBase;
	@Autowired
	AddressService addressBase;
	@Autowired
	CountryService countryBase;

	@RequestMapping(value = { "/editCity-{id}" }, method = RequestMethod.GET)
	public String editCity(@PathVariable Long id, ModelMap model) {
		City city = cityBase.findById(id);
		model.addAttribute("city", city);
		return "manipulation/editCity";
	}

	@RequestMapping(value = { "/ediCity-{id}" }, method = RequestMethod.POST)
	public String updateCity(@Valid City city, BindingResult result, ModelMap model, @PathVariable Long id) {

		if (result.hasErrors()) {
			return "manipulation/editCity";
		}

		cityBase.update(city);

		model.addAttribute("success", "City " + city.getName() + " edited successfully");
		String page = "cityInfo";
		model.addAttribute("goto", page);
		return "manipulation/succes";
	}

	@RequestMapping(value = { "/editAddress-{id}" }, method = RequestMethod.GET)
	public String editAddress(@PathVariable Long id, ModelMap model) {
		Address address = addressBase.findById(id);
		model.addAttribute("address", address);
		return "manipulation/editAddress";
	}

	@RequestMapping(value = { "/editAddress-{id}" }, method = RequestMethod.POST)
	public String updateAddress(@Valid Address address, BindingResult result, ModelMap model, @PathVariable Long id) {

		if (result.hasErrors()) {
			return "manipulation/editAddress";
		}

		addressBase.update(address);

		model.addAttribute("success",
				"Address " + address.getStreet() + " " + address.getStreetNumber() + " edited successfully");
		String page = "addressInfo";
		model.addAttribute("goto", page);
		return "manipulation/succes";
	}

	@RequestMapping(value = { "/editContact-{id}" }, method = RequestMethod.GET)
	public String editContact(@PathVariable Long id, ModelMap model) {
		Contact contact = contactBase.findById(id);
		model.addAttribute("contact", contact);
		return "manipulation/editContact";
	}

	@RequestMapping(value = { "/editContact-{id}" }, method = RequestMethod.POST)
	public String updateContact(@Valid Contact contact, BindingResult result, ModelMap model, @PathVariable Long id) {

		if (result.hasErrors()) {
			return "manipulation/editContact";
		}

		contactBase.update(contact);

		model.addAttribute("success",
				"Contact " + contact.getFirstName() + " " + contact.getLastName() + " edited successfully");

		String page = "contactInfo";
		model.addAttribute("goto", page);
		return "manipulation/succes";
	}

	@RequestMapping(value = { "/editCountry-{id}" }, method = RequestMethod.GET)
	public String editCountry(@PathVariable Long id, ModelMap model) {
		Country country = countryBase.findById(id);
		model.addAttribute("contact", country);
		return "manipulation/editCountry";
	}

	@RequestMapping(value = { "/editCountry-{id}" }, method = RequestMethod.POST)
	public String updateCountry(@Valid Country country, BindingResult result, ModelMap model, @PathVariable Long id) {

		if (result.hasErrors()) {
			return "manipulation/editCountry";
		}

		countryBase.update(country);

		model.addAttribute("success", "Country " + country.getName() + " edited successfully");

		String page = "countryInfo";
		model.addAttribute("goto", page);
		return "manipulation/succes";
	}

}
