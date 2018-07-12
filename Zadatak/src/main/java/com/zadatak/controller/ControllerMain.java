package com.zadatak.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
 *
 */

@Controller
public class ControllerMain {

	@Autowired
	private ServiceBase serviceBase;

	@RequestMapping(value = { "/", "/home" })
	public String home() {
		return "home";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String logIn(@Valid @ModelAttribute("username") String username,
			@Valid @ModelAttribute("password") String password, BindingResult result, Model model,
			HttpServletRequest request) {
		String view = "";
		if (username.equals("user") && password.equals("12345")) {
			view = "redirect:/contact";
		} else {
			view = "home";
		}
		return view;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logOut() {
		return "home";
	}

	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String contactList(Model model, HttpServletRequest request) throws IOException {
		List<Contact> contact = (List<Contact>) serviceBase.getContacts();
		String error = (String) request.getSession().getAttribute("error");
		request.getSession().removeAttribute("error");
		model.addAttribute("contact", contact);
		model.addAttribute("error", error);
		return "info/contactInfo";
	}

	@RequestMapping(value = "/address", method = RequestMethod.GET)
	public String addressList(Model model, HttpServletRequest request) throws IOException {
		List<Address> address = serviceBase.getAddresses();
		String error = (String) request.getSession().getAttribute("error");
		request.getSession().removeAttribute("error");
		model.addAttribute("address", address);
		model.addAttribute("error", error);
		return "info/addressInfo";
	}

	@RequestMapping(value = "/city", method = RequestMethod.GET)
	public String cityList(Model model, HttpServletRequest request) throws IOException {
		List<City> city = serviceBase.getCities();
		String error = (String) request.getSession().getAttribute("error");
		request.getSession().removeAttribute("error");
		model.addAttribute("city", city);
		model.addAttribute("error", error);
		return "info/cityInfo";
	}

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
