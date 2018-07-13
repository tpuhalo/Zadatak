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

import com.zadatak.domain.Country;
import com.zadatak.service.ServiceBase;

/**
 * Country controller for handling GET and POST requests for creating new
 * country, changing particular country or deleting existing country from
 * database.
 * 
 * @author tpuhalo
 *
 */

@Controller
public class CountryController {

	@Autowired
	private ServiceBase serviceBase;

	/**
	 * Method for creating new blank country and putting it into page attribute.
	 * 
	 * @param model
	 * @return String
	 */
	@RequestMapping(value = "/newCountry", method = RequestMethod.GET)
	public String newCountry(Model model) {
		Country country = new Country();
		model.addAttribute("newCountry", country);
		return "manipulation/newCountry";
	}

	/**
	 * Method for parsing new created country to service.
	 * 
	 * @param address
	 * @param result
	 * @param model
	 * @param request
	 * @return String
	 */
	@RequestMapping(value = "/saveCountry", method = RequestMethod.POST)
	public String saveCountry(@Valid @ModelAttribute("newCountry") Country country, BindingResult result, Model model,
			HttpServletRequest request) {

		if (result.hasErrors()) {
			model.addAllAttributes(result.getModel());
			return "manipulation/newCountry";
		} else {
			String error = serviceBase.saveNewCountry(country);
			request.getSession().setAttribute("error", error);
			return "redirect:/country";
		}

	}

	/**
	 * Method for putting into page attribute country we want edit.
	 * 
	 * @param request
	 * @param model
	 * @return String
	 */
	@RequestMapping(value = "/editCountry", method = RequestMethod.GET)
	public String editCountry(HttpServletRequest request, Model model) {
		long countryID = Long.parseLong(request.getParameter("id"));
		Country country = serviceBase.prepareCountry(countryID);
		HttpSession session = request.getSession();
		session.setAttribute("countryId", countryID);
		model.addAttribute("editCountry", country);

		return "manipulation/editCountry";
	}

	/**
	 * Method for parsing edited country to service.
	 * 
	 * @param address
	 * @param result
	 * @param model
	 * @param request
	 * @return String
	 */
	@RequestMapping(value = "/saveEditCountry", method = RequestMethod.POST)
	public String saveEditCountry(@Valid @ModelAttribute("editCountry") Country country, BindingResult result,
			Model model, HttpServletRequest request) {

		if (result.hasErrors()) {
			model.addAllAttributes(result.getModel());
			return "manipulation/editCountry";
		} else {
			HttpSession session = request.getSession();
			long countryID = (Long) session.getAttribute("countryId");
			System.out.println(countryID);
			String error = serviceBase.saveUpdatedCountry(country, countryID);
			request.getSession().setAttribute("error", error);
			return "redirect:/country";
		}

	}

	/**
	 * Method for parsing id of country to be deleted.
	 * 
	 * @param model
	 * @param request
	 * @return String
	 */
	@RequestMapping(value = "/deleteCountry", method = RequestMethod.GET)
	public String deleteCountry(HttpServletRequest request) {
		long countryId = Long.parseLong(request.getParameter("id"));
		String error = serviceBase.deleteCountry(countryId);
		HttpSession session = request.getSession();
		session.setAttribute("error", error);
		return "redirect:/country";
	}
}
