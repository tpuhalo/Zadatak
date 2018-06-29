package com.zadatak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zadatak.service.AddressService;
import com.zadatak.service.CityService;
import com.zadatak.service.ContactService;
import com.zadatak.service.CountryService;

@Controller
public class DeleteController {

	@Autowired
	CityService cityBase;
	@Autowired
	ContactService contactBase;
	@Autowired
	AddressService addressBase;
	@Autowired
	CountryService countryBase;

	@RequestMapping(value = { "/deleteCity-{id}" }, method = RequestMethod.GET)
	public String deleteCity(@PathVariable Long id) {
		cityBase.deleteById(id);
		return "redirect:/cityList";
	}

	@RequestMapping(value = { "/deleteContact-{id}" }, method = RequestMethod.GET)
	public String deleteContact(@PathVariable Long id) {
		contactBase.deleteById(id);
		return "redirect:/contactList";
	}

	@RequestMapping(value = { "/deleteAddress-{id}" }, method = RequestMethod.GET)
	public String deleteAddress(@PathVariable Long id) {
		addressBase.deleteById(id);
		return "redirect:/addressList";
	}

	@RequestMapping(value = { "/deleteCountry-{id}" }, method = RequestMethod.GET)
	public String deleteCountry(@PathVariable Long id) {
		countryBase.deleteById(id);
		return "redirect:/countryList";
	}

}
