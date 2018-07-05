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
public class AddressFormController {

	@Autowired
	private MainService mainService;

	public AddressFormController() {
	}

	@RequestMapping(value = "/saveAddress", method = RequestMethod.POST)
	public String saveAddress(@Valid @ModelAttribute Address address, BindingResult result, Model model,
			HttpServletRequest request) {

		if (result.hasErrors()) {
			model.addAllAttributes(result.getModel());
			model.addAttribute("cities", mainService.getCities());
			return "AddressForm";
		} else {
			long cityID = Long.parseLong(request.getParameter("cities"));

			String error = mainService.saveNewOrUpdatedAddress(address, cityID);
			request.getSession().setAttribute("error", error);
			return "redirect:/";
		}
	}


	@RequestMapping(value = "/saveEditAddress", method = RequestMethod.POST)
	public String saveEditAddress(@Valid @ModelAttribute Address address, BindingResult result, Model model,
			HttpServletRequest request) {

		if (result.hasErrors()) {
			model.addAllAttributes(result.getModel());
			List<City> cities = mainService.getCities();
			model.addAttribute("cities", cities);
			return "AddressEditForm";
		} else {
			HttpSession session = request.getSession();
			long addressId = (Long) session.getAttribute("addressId");
			address.setId(addressId);
			session.removeAttribute("addressId");
			long cityID = Long.parseLong(request.getParameter("cities"));
			String error = mainService.saveNewOrUpdatedAddress(address, cityID);
			request.getSession().setAttribute("error", error);
			return "redirect:/";
		}

	}
}
