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

import com.zadatak.domain.Address;
import com.zadatak.service.MainService;

@Controller
public class AddressController {

	@Autowired
	private MainService mainService;

	public AddressController() {
	}

	@RequestMapping(value = "/newAddress", method = RequestMethod.GET)
	public String newAddress(Model model) {
		Address address = new Address();
		model.addAttribute("cities", mainService.getCities());
		model.addAttribute("addressInfo", address);
		return "manipulation/newAddress";
	}

	@RequestMapping(value = "/saveAddress", method = RequestMethod.POST)
	public String saveAddress(@Valid @ModelAttribute("addressInfo") Address address, BindingResult result, Model model,
			HttpServletRequest request) {

		if (result.hasErrors()) {
			model.addAllAttributes(result.getModel());
			model.addAttribute("cities", mainService.getCities());
			return "manipulation/newAddress";
		} else {
			long cityID = Long.parseLong(request.getParameter("cities"));
			String error = mainService.saveNewAddress(address, cityID);
			request.getSession().setAttribute("error", error);
			return "redirect:/address";
		}
	}

	@RequestMapping(value = "/editAddress", method = RequestMethod.GET)
	public String editAddress(HttpServletRequest request, Model model) {
		long addressId = Long.parseLong(request.getParameter("id"));
		HttpSession session = request.getSession();
		session.setAttribute("addressId", addressId);
		model.addAttribute("cities", mainService.getCities());
		model.addAttribute("editAddress", mainService.prepareAddress(addressId));

		return "manipulation/editAddress";
	}

	@RequestMapping(value = "/saveEditAddress", method = RequestMethod.POST)
	public String saveEditAddress(@Valid @ModelAttribute("editAddress") Address address, BindingResult result,
			Model model, HttpServletRequest request) {

		if (result.hasErrors()) {
			model.addAllAttributes(result.getModel());
			model.addAttribute("cities", mainService.getCities());
			return "manipulation/editAddress";
		} else {
			HttpSession session = request.getSession();
			long addressId = (Long) session.getAttribute("addressId");
			session.removeAttribute("addressId");

			long cityID = Long.parseLong(request.getParameter("cities"));
			String error = mainService.saveUpdatedAddress(address, addressId, cityID);
			request.getSession().setAttribute("error", error);
			return "redirect:/address";
		}

	}

	@RequestMapping(value = "/deleteAddress", method = RequestMethod.GET)
	public String deleteAddress(Model model, HttpServletRequest request) {
		long addressId = Long.parseLong(request.getParameter("id"));
		String error = mainService.deleteAddress(addressId);
		HttpSession session = request.getSession();
		session.setAttribute("error", error);
		return "redirect:/address";
	}

}
