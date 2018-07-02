package com.zadatak.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
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
@RequestMapping("/")
public class MainController {

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
	
	@RequestMapping(value = { "/" })
	public String listUsers(ModelMap model) {
		return "home";
	}

	@RequestMapping(value = "/city", method=RequestMethod.GET)
	public String cityList(Model model) {
		List<City> city = cityBase.getAll();
		model.addAttribute("city", city);
		return "info/cityInfo";
	}
	
	@RequestMapping(value = "/contact", method=RequestMethod.GET)
	public String contactList(Model model) {
		List<Contact> contact = (List<Contact>) contactBase.getAll();
		model.addAttribute("contact", contact);
		return "info/contactInfo";
	}

	@RequestMapping(value = "/address", method=RequestMethod.GET)
	public String addressList(Model model) {
		List<Address> address = addressBase.getAll();
		model.addAttribute("address", address);
		return "info/addressInfo";
	}
	
	@RequestMapping(value = "/country", method=RequestMethod.GET)
	public String countryList(Model model) {
		List<Country> country = countryBase.getAll();
		model.addAttribute("country", country);
		return "info/countryInfo";
	}

}
