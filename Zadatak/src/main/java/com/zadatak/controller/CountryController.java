package com.zadatak.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zadatak.service.MainService;

@Controller
public class CountryController {

	@Autowired
	private MainService mainService;

	@RequestMapping(value = "/deleteCountry", method = RequestMethod.GET)
	public String deleteCountry(HttpServletRequest request) {
		long countryId = Long.parseLong(request.getParameter("id"));
		String error = mainService.deleteCountry(countryId);
		HttpSession session = request.getSession();
		session.setAttribute("error", error);
		return "redirect:/country";
	}
}
