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
public class ContactFormController {

	@Autowired
	private MainService mainService;

	@RequestMapping(value = "/saveContact", method = RequestMethod.POST)
	public String saveContact(@Valid @ModelAttribute Contact contact, BindingResult result, Model model,
			HttpServletRequest request) {
		String view = "";
		if (result.hasErrors()) {
			model.addAllAttributes(result.getModel());
			model.addAttribute("addresses", mainService.getAddresses());
			model.addAttribute("genders", mainService.getSexs());
			view = "ContactForm";
		} else {
			long addressID = Long.parseLong(request.getParameter("addresses"));
			long sexID = Long.parseLong(request.getParameter("genders"));
			String error = mainService.saveNewOrUpdatedContact(contact, sexID, addressID);
			request.getSession().setAttribute("error", error);
			view = "redirect:/";
		}
		return view;
	}

	@RequestMapping(value = "/saveEditContact", method = RequestMethod.POST)
	public String saveEditContact(@Valid @ModelAttribute Contact contact, BindingResult result, Model model,
			HttpServletRequest request) {
		String view = "";

		if (result.hasErrors()) {
			model.addAllAttributes(result.getModel());
			view = "ContactEditForm";
		} else {
			long addressId = Long.parseLong(request.getParameter("addresses"));
			long sexID = Long.parseLong(request.getParameter("sex"));
			String error = mainService.saveNewOrUpdatedContact(contact, sexID, addressId);
			request.getSession().setAttribute("error", error);
			view = "redirect:/";
		}
		return view;
	}

}
