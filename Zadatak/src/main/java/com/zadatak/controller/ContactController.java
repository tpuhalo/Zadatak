package com.zadatak.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zadatak.domain.Contact;
import com.zadatak.service.MainService;

@Controller
public class ContactController {

	@Autowired
	private MainService mainService;

	@RequestMapping(value = "/newContact", method = RequestMethod.GET)
	public String newContact(Model model) {
		Contact contact = new Contact();
		model.addAttribute("addresses", mainService.getAddresses());
		model.addAttribute("sexs", mainService.getSexs());
		model.addAttribute("newContact", contact);
		return "manipulation/editContact";
	}
	
	@RequestMapping(value = "/saveContact", method = RequestMethod.POST)
	public String saveContact(@Valid @ModelAttribute("newContact") Contact contact, BindingResult result, Model model,
			HttpServletRequest request) {

		if (result.hasErrors()) {
			model.addAllAttributes(result.getModel());
			model.addAttribute("addresses", mainService.getAddresses());
			model.addAttribute("sexs", mainService.getSexs());
			return "manipulation/editContact";
		} else {
			long addressID = Long.parseLong(request.getParameter("addresses"));
			long sexID = Long.parseLong(request.getParameter("sexs"));
			String error = mainService.saveNewOrUpdatedContact(contact, sexID, addressID);
			model.addAttribute("success",
					"Address " + contact.getFirstName() + " " + contact.getLastName() + " saved successfully");
			request.getSession().setAttribute("error", error);
			return "manipulation/success";
		}

	}


	@RequestMapping(value = "/editContact", method = RequestMethod.GET)
	public String editContact(HttpServletRequest request, Model model) {
		long contactId = Long.parseLong(request.getParameter("id"));
		Contact contact = mainService.prepareContact(contactId);
		model.addAttribute("editContact", contact);

		model.addAttribute("addresses", mainService.getAddresses());
		model.addAttribute("sexs", mainService.getSexs());

		return "manipulation/editContact";
	}
	
	@RequestMapping(value = "/saveEditContact", method = RequestMethod.POST)
	public String saveEditContact(@Valid @ModelAttribute("newContact") Contact contact, BindingResult result, Model model,
			HttpServletRequest request) {

		if (result.hasErrors()) {
			model.addAllAttributes(result.getModel());
			return "manipulation/editContact";
		} else {
			long addressId = Long.parseLong(request.getParameter("addresses"));
			long sexID = Long.parseLong(request.getParameter("sexs"));
			String error = mainService.saveNewOrUpdatedContact(contact, sexID, addressId);
			model.addAttribute("success",
					"Address " + contact.getFirstName() + " " + contact.getLastName() + " updated successfully");
			request.getSession().setAttribute("error", error);
			return "manipulation/success";
		}

	}


	@RequestMapping(value = "/deleteContact", method = RequestMethod.GET)
	public String deleteContact(HttpServletRequest request) {
		long contactId = Long.parseLong(request.getParameter("id"));

		mainService.deleteContact(contactId);
		return "redirect:/";
	}
}
