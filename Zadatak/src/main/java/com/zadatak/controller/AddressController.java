package com.zadatak.controller;

import java.util.List;

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
import com.zadatak.domain.City;
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
		return "manipulation/editAddress";
	}
	
	@RequestMapping(value = "/saveAddress", method = RequestMethod.POST)
	public String saveAddress(@Valid @ModelAttribute("addressInfo") Address address, BindingResult result, Model model,
			HttpServletRequest request) {

		if (result.hasErrors()) {
			model.addAllAttributes(result.getModel());
			model.addAttribute("cities", mainService.getCities());
			return "manipulation/editAddress";
		} else {
			long cityID = Long.parseLong(request.getParameter("city"));
			String error = mainService.saveNewOrUpdatedAddress(address, cityID);
			model.addAttribute("success",
					"Address " + address.getStreet() + " " + address.getStreetNumber() + " saved successfully");
			request.getSession().setAttribute("error", error);
			return "manipulation/success";
		}
	}
	
	@RequestMapping(value = "/editAddress", method = RequestMethod.GET)
	public String editAddress(HttpServletRequest request, Model model) {
		long addressId = Long.parseLong(request.getParameter("id"));
		model.addAttribute("cities", mainService.getCities());
		model.addAttribute("addressInfo", mainService.prepareAddress(addressId));

		return "manipulation/editAddress";
	}

	@RequestMapping(value = "/saveEditAddress", method = RequestMethod.POST)
	public String saveEditAddress(@Valid @ModelAttribute("addressInfo") Address address, BindingResult result, Model model,
			HttpServletRequest request) {

		if (result.hasErrors()) {
			model.addAllAttributes(result.getModel());
			List<City> cities = mainService.getCities();
			model.addAttribute("cities", cities);
			return "manipulation/editAddress";
		} else {
			long cityID = Long.parseLong(request.getParameter("city"));
			model.addAttribute("success",
					"Address " + address.getStreet() + " " + address.getStreetNumber() + " updated successfully");
			String error = mainService.saveNewOrUpdatedAddress(address, cityID);
			request.getSession().setAttribute("error", error);
			return "manipulation/success";
		}

	}

	@RequestMapping(value = "/deleteAddress", method = RequestMethod.GET)
	public String deleteAddress(Model model, HttpServletRequest request) {
		long addressId = Long.parseLong(request.getParameter("id"));
		String error = mainService.deleteAddress(addressId);
		HttpSession session = request.getSession();
		session.setAttribute("error", error);
		return "redirect:/manipulation/success";
	}

	
	@RequestMapping(value = "/deleteCity", method = RequestMethod.GET)
	public String deleteCity(Model model, HttpServletRequest request) {
		long cityId = Long.parseLong(request.getParameter("id"));
		String error = mainService.deleteCity(cityId);
		HttpSession session = request.getSession();
		session.setAttribute("error", error);
		return "redirect:/manipulation/success";
	}

}
