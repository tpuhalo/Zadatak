package com.zadatak.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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
import com.zadatak.service.SexService;


@Controller
public class AddController {

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
	@Autowired
	@Qualifier("sexBase")
	SexService sexBase;

	@RequestMapping(value = "/addCity", method = RequestMethod.GET)
	public String newCity(ModelMap model) {
		City city = new City();
		model.addAttribute("cityInfo", city);
		return "manipulation/editCity";
	}

	@RequestMapping(value = { "/addCity" }, method = RequestMethod.POST)
	public String addCity(@Valid City city, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "manipulation/editCity";
		}
		cityBase.saveOrUpdate(city);
		model.addAttribute("success", "City " + city.getName() + " added successfully");

		String page = "cityInfo";
		model.addAttribute("goto", page);
		return "redirect:/manipulation/succes";
	}

	@RequestMapping(value = { "/addAddress" }, method = RequestMethod.GET)
	public String newAddress(ModelMap model) {
		Address address = new Address();
		model.addAttribute("addressInfo", address);
		return "manipulation/editAddress";
	}

	@RequestMapping(value = { "/addAddress" }, method = RequestMethod.POST)
	public String addAddress(@Valid Address address, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "manipulation/editAddress";
		}
		addressBase.saveOrUpdate(address);
		model.addAttribute("success",
				"Address " + address.getStreet() + " " + address.getStreetNumber() + " added successfully");

		String page = "addressInfo";
		model.addAttribute("goto", page);
		return "redirect:/manipulation/succes";
	}

	@RequestMapping(value = "/addContact", method = RequestMethod.GET)
	public String newContact(ModelMap model) {
		Contact contact = new Contact();
		model.addAttribute("contactInfo", contact);
		return "manipulation/editContact";
	}

//	@RequestMapping(value = "/newContact", method = RequestMethod.GET)
//	public String newContact(Model model) {
//		ContactEntity contactEntity = new ContactEntity();
//		List<Address> addresses = addressBookManager.fetchAddresses();
//		List<Sex> genders = addressBookManager.fetchGenders();
//		model.addAttribute("addresses", addresses);
//		model.addAttribute("genders", genders);
//		model.addAttribute("contactEntity", contactEntity);
//		return "ContactForm";
//	}

	@RequestMapping(value = "/saveContact", method = RequestMethod.POST)
	public String addContact(@Valid @ModelAttribute Contact contact, BindingResult result, Model model,
			HttpServletRequest request) {

		if (result.hasErrors()) {
			model.addAllAttributes(result.getModel());
			return "manipulation/editContact";
		} else {
			long addressID = Long.parseLong(request.getParameter("addresses"));
			contact.setAddressID(addressID);
			long sexID = Long.parseLong(request.getParameter("sex"));
			contact.setSexID(sexID);
			String error = contactBase.saveOrUpdate(contact);
			model.addAttribute("error", error);
			model.addAttribute("success",
					"Address " + contact.getFirstName() + " " + contact.getLastName() + " added successfully");
			String page = "addressInfo";
			model.addAttribute("goto", page);
			return "redirect:/manipulation/succes";
		}

	}

	@RequestMapping(value = { "/addCountry" }, method = RequestMethod.GET)
	public String newCountry(ModelMap model) {
		Country country = new Country();
		model.addAttribute("countryInfo", country);
		return "manipulation/editCountry";
	}

	@RequestMapping(value = { "/addCountry" }, method = RequestMethod.POST)
	public String addCountry(@Valid Country country, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "manipulation/editCountry";
		}
		countryBase.saveOrUpdate(country);
		model.addAttribute("success", "Country " + country.getName() + " added successfully");

		String page = "countryInfo";
		model.addAttribute("goto", page);
		return "redirect:/manipulation/succes";
	}

	@ModelAttribute
	public void modelAttributeTest1(Model model) {
		model.addAttribute("sexList", sexBase.getAll());
		model.addAttribute("addressList", addressBase.getAll());
		model.addAttribute("cityList", cityBase.getAll());
		model.addAttribute("countryList", countryBase.getAll());
	}

}
