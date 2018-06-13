package com.zadatak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
	
	@RequestMapping(value = "/editCity")
	public ModelAndView editCity(@ModelAttribute City city,Model model) {
		return new ModelAndView("manipulation/editCity", "cityInfo", cityBase.findById(city.getId()));
		}

	@RequestMapping(value = "/editAddress")
	public ModelAndView editAddress(@ModelAttribute Address address,Model model) {
		return new ModelAndView("manipulation/editAddress", "addressInfo", addressBase.findById(address.getId()));
		}

	@RequestMapping(value = "/editCountry")
	public ModelAndView editCountry(@ModelAttribute Country country,Model model) {
		return new ModelAndView("manipulation/editCountry", "countryInfo", countryBase.findById(country.getId()));
		}

	@RequestMapping(value = "/editContact")
	public ModelAndView editCity(@ModelAttribute Contact contact,Model model) {
		return new ModelAndView("manipulation/editContact", "contactInfo", contactBase.findById(contact.getId()));
		}

	
}
