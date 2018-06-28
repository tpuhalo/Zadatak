package com.zadatak.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.zadatak.domain.Address;
import com.zadatak.domain.City;
import com.zadatak.domain.Contact;
import com.zadatak.domain.Country;
import com.zadatak.service.AddressService;
import com.zadatak.service.CityService;
import com.zadatak.service.ContactService;
import com.zadatak.service.CountryService;
import com.zadatak.service.SexService;

@Controller
public class AddController {

	@Autowired
	SexService sexBase;
	@Autowired
	CityService cityBase;
	@Autowired
	ContactService contactBase;
	@Autowired
	AddressService addressBase;
	@Autowired
	CountryService countryBase;

	
	@RequestMapping("/addCity")
	public ModelAndView addCity(Model model) {
		return new ModelAndView("manipulation/editCity", "cityInfo", new City());
	}

	@RequestMapping("/addAddress")
	public ModelAndView addAddress(Model model) {
		return new ModelAndView("manipulation/editAddress", "addressInfo", new Address());
	}

	@RequestMapping("/addContact")
	public ModelAndView addContact(Model model) {
		return new ModelAndView("manipulation/editContact", "contactInfo", new Contact());
	}

	@RequestMapping("/addCountry")
	public ModelAndView addCountry(Model model) {
		return new ModelAndView("manipulation/editCountry", "countryInfo", new Country());
	}

	@RequestMapping(value = "/city", method = RequestMethod.POST)
	public String submitCity(@Valid @ModelAttribute ("city") City city, Model model) {
		cityBase.create(city);
		return "info/cityInfo";
	}

	@RequestMapping(value = "/country", method = RequestMethod.POST)
	public String submitCountry(@Valid @ModelAttribute ("country") Country country, Model model) {
		countryBase.create(country);
		return "info/countryInfo";
	}

	@RequestMapping(value = "/contact", method = RequestMethod.POST)
	public String submitContact(@Valid @ModelAttribute ("contact") Contact contact, Model model) {
		contactBase.save(contact);
		return "info/contactInfo";
	}

	@RequestMapping(value = "/address", method = RequestMethod.POST)
	public String submitAddress(@Valid @ModelAttribute("address") Address address, Model model) {
		addressBase.create(address);
		return "info/countryInfo";
	}

	@ModelAttribute
	public void populateFormObjectWithData(Model model) {
		Map<String, Object> map = model.asMap();
		map.put("sexList", sexBase.getAll());
		map.put("countryList", countryBase.getAll());
		map.put("cityList", cityBase.getAll());
	}

}
