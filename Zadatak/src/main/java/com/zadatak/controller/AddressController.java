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
import com.zadatak.service.ServiceBase;

/**
 * Address controller for handling GET and POST requests for creating new
 * address, changing particular address or deleting existing address from
 * database.
 * 
 * @author tpuhalo
 *
 */

@Controller
public class AddressController {

	@Autowired
	private ServiceBase serviceBase;


	/**
	 * Method for creating new blank address and putting it into page attribute.
	 * 
	 * @param model
	 * @return String
	 */

	@RequestMapping(value = "/newAddress", method = RequestMethod.GET)
	public String newAddress(Model model) {
		Address address = new Address();
		model.addAttribute("cities", serviceBase.getCities());
		model.addAttribute("addressInfo", address);
		return "manipulation/newAddress";
	}

	/**
	 * Method for parsing new created address to service.
	 * 
	 * @param address
	 * @param result
	 * @param model
	 * @param request
	 * @return String
	 */

	@RequestMapping(value = "/saveAddress", method = RequestMethod.POST)
	public String saveAddress(@Valid @ModelAttribute("addressInfo") Address address, BindingResult result, Model model,
			HttpServletRequest request) {

		// if result have errors we sending it back to form for new city
		if (result.hasErrors()) {
			model.addAllAttributes(result.getModel());
			model.addAttribute("cities", serviceBase.getCities());
			return "manipulation/newAddress";
		} else {
			long cityID = Long.parseLong(request.getParameter("cities"));// getting cityId from form
			String error = serviceBase.saveNewAddress(address, cityID); // and sending data to service and receiving
																		// string
			request.getSession().setAttribute("error", error); // putting string into attribute
			return "redirect:/address";
		}
	}

	/**
	 * Method for putting into page attribute address we want edit.
	 * 
	 * @param request
	 * @param model
	 * @return String
	 */

	@RequestMapping(value = "/editAddress", method = RequestMethod.GET)
	public String editAddress(HttpServletRequest request, Model model) {
		long addressId = Long.parseLong(request.getParameter("id"));
		HttpSession session = request.getSession();
		session.setAttribute("addressId", addressId);
		model.addAttribute("cities", serviceBase.getCities());
		model.addAttribute("editAddress", serviceBase.prepareAddress(addressId));

		return "manipulation/editAddress";
	}

	/**
	 * Method for parsing edited address to service.
	 * 
	 * @param address
	 * @param result
	 * @param model
	 * @param request
	 * @return String
	 */
	@RequestMapping(value = "/saveEditAddress", method = RequestMethod.POST)
	public String saveEditAddress(@Valid @ModelAttribute("editAddress") Address address, BindingResult result,
			Model model, HttpServletRequest request) {

		if (result.hasErrors()) {
			model.addAllAttributes(result.getModel());
			model.addAttribute("cities", serviceBase.getCities());
			return "manipulation/editAddress";
		} else {
			HttpSession session = request.getSession();
			long addressId = (Long) session.getAttribute("addressId"); // getting back address id
			session.removeAttribute("addressId"); // because we needing it for updating

			long cityID = Long.parseLong(request.getParameter("cities"));
			// sending address object, addressId and cityID to service to update address
			String error = serviceBase.saveUpdatedAddress(address, addressId, cityID);
			request.getSession().setAttribute("error", error);
			return "redirect:/address";
		}

	}

	/**
	 * Method for parsing id of address to be deleted.
	 * 
	 * @param model
	 * @param request
	 * @return String
	 */
	@RequestMapping(value = "/deleteAddress", method = RequestMethod.GET)
	public String deleteAddress(Model model, HttpServletRequest request) {
		long addressId = Long.parseLong(request.getParameter("id"));
		String error = serviceBase.deleteAddress(addressId);
		HttpSession session = request.getSession();
		session.setAttribute("error", error);
		return "redirect:/address";
	}

}
