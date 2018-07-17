package com.zadatak.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.zadatak.domain.Address;
import com.zadatak.domain.City;
import com.zadatak.domain.Contact;
import com.zadatak.domain.Country;
import com.zadatak.service.ServiceBase;

/**
 * Main controller for handling get requests for displaying contacts, addresses,
 * cities and countries saved in database.
 * 
 * @author tpuhalo
 */

@Controller
public class ControllerMain {

	@Autowired
	private ServiceBase serviceBase;

	@RequestMapping(value = { "/", "/home" })
	public String home() {
		return "home";
	}

	 /**
	 * Method for login.
	 *
	 * @param username
	 * @param password
	 * @return String
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("home");

		return model;

	}
	//
	// @RequestMapping(value = "/logout", method = RequestMethod.GET)
	// public String logOut() {
	// return "home";
	// }

	/**
	 * Method for fetching contacts from service. And putting them to the page
	 * attribute.
	 * 
	 * @param model
	 * @param request
	 * @return String
	 * @throws IOException
	 */
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String contactList(Model model, HttpServletRequest request) throws IOException {
		List<Contact> contact = (List<Contact>) serviceBase.getContacts(); // fetching list of contacts
		String error = (String) request.getSession().getAttribute("error");
		request.getSession().removeAttribute("error");
		model.addAttribute("contact", contact); // adding contact to attribute
		model.addAttribute("error", error);
		return "info/contactInfo";
	}

	/**
	 * Method for fetching addreses from service. And putting them to the page
	 * attribute.
	 * 
	 * @param model
	 * @param request
	 * @return String
	 * @throws IOException
	 */
	@RequestMapping(value = "/address", method = RequestMethod.GET)
	public String addressList(Model model, HttpServletRequest request) throws IOException {
		List<Address> address = serviceBase.getAddresses();
		String error = (String) request.getSession().getAttribute("error");
		request.getSession().removeAttribute("error");
		model.addAttribute("address", address);
		model.addAttribute("error", error);
		return "info/addressInfo";
	}

	/**
	 * Method for fetching cities from service. And putting them to the page
	 * attribute.
	 * 
	 * @param model
	 * @param request
	 * @return String
	 * @throws IOException
	 */
	@RequestMapping(value = "/city", method = RequestMethod.GET)
	public String cityList(Model model, HttpServletRequest request) throws IOException {
		List<City> city = serviceBase.getCities();
		String error = (String) request.getSession().getAttribute("error");
		request.getSession().removeAttribute("error");
		model.addAttribute("city", city);
		model.addAttribute("error", error);
		return "info/cityInfo";
	}

	/**
	 * Method for fetching countries from service. And putting them to the page
	 * attribute.
	 * 
	 * @param model
	 * @param request
	 * @return String
	 * @throws IOException
	 */
	@RequestMapping(value = "/country", method = RequestMethod.GET)
	public String countryList(Model model, HttpServletRequest request) throws IOException {
		List<Country> country = serviceBase.getCountry();
		String error = (String) request.getSession().getAttribute("error");
		request.getSession().removeAttribute("error");
		model.addAttribute("country", country);
		model.addAttribute("error", error);
		return "info/countryInfo";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String invalidURL() {
		return "redirect:/";
	}
}
