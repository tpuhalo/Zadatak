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

import com.zadatak.domain.City;
import com.zadatak.service.MainService;

@Controller
public class CityController {

	@Autowired
	private MainService mainService;

	public CityController() {

	}

	@RequestMapping(value = "/newCity", method = RequestMethod.GET)
	public String newAddress(Model model) {
		City city = new City();
		model.addAttribute("countries", mainService.getCountry());
		model.addAttribute("cityInfo", city);
		return "manipulation/newCity";
	}

	@RequestMapping(value = "/saveCity", method = RequestMethod.POST)
	public String saveAddress(@Valid @ModelAttribute("cityInfo") City city, BindingResult result, Model model,
			HttpServletRequest request) {

		if (result.hasErrors()) {
			model.addAllAttributes(result.getModel());
			model.addAttribute("countries", mainService.getCountry());
			return "manipulation/newCity";
		} else {
			String error = mainService.saveNewCity(city);
			request.getSession().setAttribute("error", error);
			return "redirect:/city";
		}
	}

	@RequestMapping(value = "/editCity", method = RequestMethod.GET)
	public String editAddress(HttpServletRequest request, Model model) {
		long cityId = Long.parseLong(request.getParameter("id"));
		model.addAttribute("countries", mainService.getCountry());
		model.addAttribute("editCity", mainService.prepareCity(cityId));

		return "manipulation/editCity";
	}

	@RequestMapping(value = "/saveEditCity", method = RequestMethod.POST)
	public String saveEditAddress(@Valid @ModelAttribute("editCity") City city, BindingResult result,
			Model model, HttpServletRequest request) {

		if (result.hasErrors()) {
			model.addAllAttributes(result.getModel());
			model.addAttribute("countries", mainService.getCountry());
			return "manipulation/editAddress";
		} else {
			String error = mainService.saveUpdatedCity(city);
			request.getSession().setAttribute("error", error);
			return "redirect:/city";
		}

	}

	@RequestMapping(value = "/deleteCity", method = RequestMethod.GET)
	public String deleteCity(Model model, HttpServletRequest request) {
		long cityId = Long.parseLong(request.getParameter("id"));
		String error = mainService.deleteCity(cityId);
		HttpSession session = request.getSession();
		session.setAttribute("error", error);
		return "redirect:/city";
	}

}
