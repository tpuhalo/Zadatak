package com.zadatak.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zadatak.domain.Contact;
import com.zadatak.service.ServiceBase;

/**
 * Contact controller for handling GET and POST requests for 
 * creating new contact, changing particular contact or deleting 
 * existing contact from database.
 * 
 * @author tpuhalo
 *
 */

@Controller
public class ContactController {

	@Autowired
	private ServiceBase serviceBase;

	@RequestMapping(value = "/newContact", method = RequestMethod.GET)
	public String newContact(Model model) {
		Contact contact = new Contact();
		model.addAttribute("addresses", serviceBase.getAddresses());
		model.addAttribute("sexs", serviceBase.getSexs());
		model.addAttribute("newContact", contact);
		return "manipulation/newContact";
	}

	@RequestMapping(value = "/saveContact", method = RequestMethod.POST)
	public String saveContact(@Valid @ModelAttribute("newContact") Contact contact, BindingResult result, Model model,
			HttpServletRequest request) {

		if (result.hasErrors()) {
			System.out.println(result.getFieldError());
			model.addAllAttributes(result.getModel());
			model.addAttribute("addresses", serviceBase.getAddresses());
			model.addAttribute("sexs", serviceBase.getSexs());
			return "manipulation/newContact";
		} else {
			long addressID = Long.parseLong(request.getParameter("addresses"));
			long sexID = Long.parseLong(request.getParameter("sexs"));
			System.out.println(addressID + sexID);
			String error = serviceBase.saveNewContact(contact, addressID, sexID);
			request.getSession().setAttribute("error", error);
			return "redirect:/contact";
		}

	}

	@RequestMapping(value = "/editContact", method = RequestMethod.GET)
	public String editContact(HttpServletRequest request, Model model) {
		long contactId = Long.parseLong(request.getParameter("id"));
		Contact contact = serviceBase.prepareContact(contactId);
		HttpSession session = request.getSession();
		session.setAttribute("contactId", contactId);
		model.addAttribute("editContact", contact);

		model.addAttribute("addresses", serviceBase.getAddresses());
		model.addAttribute("sexs", serviceBase.getSexs());

		return "manipulation/editContact";
	}

	@RequestMapping(value = "/saveEditContact", method = RequestMethod.POST)
	public String saveEditContact(@Valid @ModelAttribute("editContact") Contact contact, BindingResult result,
			Model model, HttpServletRequest request) {

		if (result.hasErrors()) {
			System.out.println(result.getFieldError());
			model.addAllAttributes(result.getModel());
			model.addAttribute("addresses", serviceBase.getAddresses());
			model.addAttribute("sexs", serviceBase.getSexs());
			return "manipulation/editContact";
		} else {
			HttpSession session = request.getSession();
			long contactID = (Long) session.getAttribute("contactId");
			long addressID = Long.parseLong(request.getParameter("addresses"));
			long sexID = Long.parseLong(request.getParameter("sexs"));
			String error = serviceBase.saveUpdatedContact(contact, contactID, addressID, sexID);
			request.getSession().setAttribute("error", error);
			return "redirect:/contact";
		}

	}

	@RequestMapping(value = "/deleteContact", method = RequestMethod.GET)
	public String deleteContact(HttpServletRequest request) {
		long contactId = Long.parseLong(request.getParameter("id"));

		serviceBase.deleteContact(contactId);
		return "redirect:/contact";
	}
}
