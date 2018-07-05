package com.zadatak.controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zadatak.domain.Address;
import com.zadatak.domain.Contact;
import com.zadatak.service.MainService;


@Controller
public class ControllerMain {

	@Autowired
	private MainService mainService;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String listContact(Model model, HttpServletRequest request) throws IOException {
		List<Contact> contacts = mainService.getContacts();
		List<Address> addresses = mainService.getAddresses();
		String error = (String) request.getSession().getAttribute("error");
		request.getSession().removeAttribute("error");
		model.addAttribute("contacts", contacts);
		model.addAttribute("addresses", addresses);
		model.addAttribute("error", error);
		return "home";
	}


	@RequestMapping(value = "/newContact", method = RequestMethod.GET)
	public String newContact(Model model) {
		Contact contact = new Contact();
		model.addAttribute("addresses", mainService.getAddresses());
		model.addAttribute("genders", mainService.getSexs());
		model.addAttribute("contact", contact);
		return "ContactForm";
	}

	@RequestMapping(value = "/newAddress", method = RequestMethod.GET)
	public String newAddress(Model model) {
		Address address = new Address();
		model.addAttribute("cities", mainService.getCities());
		model.addAttribute("address", address);
		return "AddressForm";
	}


	@RequestMapping(value = "/deleteContact", method = RequestMethod.GET)
	public String deleteContact(HttpServletRequest request) {
		long contactId = Long.parseLong(request.getParameter("id"));

		mainService.deleteContact(contactId);
		return "redirect:/";
	}

	@RequestMapping(value = "/deleteAddress", method = RequestMethod.GET)
	public String deleteAddress(Model model, HttpServletRequest request) {
		long addressId = Long.parseLong(request.getParameter("id"));
		String error = mainService.deleteAddress(addressId);
		HttpSession session = request.getSession();
		session.setAttribute("error", error);
		return "redirect:/";
	}

	@RequestMapping(value = "/editContact", method = RequestMethod.GET)
	public String editContact(HttpServletRequest request, Model model) {
		long contactId = Long.parseLong(request.getParameter("id"));
		HttpSession session = request.getSession();
		session.setAttribute("contactId", contactId);
		Contact contact = mainService.prepareContact(contactId);
		model.addAttribute("contact", contact);

		model.addAttribute("addresses", mainService.getAddresses());
		model.addAttribute("genders", mainService.getSexs());

		return "ContactEditForm";
	}

	@RequestMapping(value = "/editAddress", method = RequestMethod.GET)
	public String editAddress(HttpServletRequest request, Model model) {
		long addressId = Long.parseLong(request.getParameter("id"));
		HttpSession session = request.getSession();
		session.setAttribute("addressId", addressId);

		model.addAttribute("cities", mainService.getCities());
		model.addAttribute("address", mainService.prepareAddress(addressId));

		return "AddressEditForm";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String invalidURL(HttpServletRequest request) {
		return "redirect:/";
	}

}
