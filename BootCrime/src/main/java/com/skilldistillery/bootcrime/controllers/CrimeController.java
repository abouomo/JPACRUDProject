package com.skilldistillery.bootcrime.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.bootcrime.data.CrimeDAO;
import com.skilldistillery.jpacrime.entities.Crime;

@Controller
public class CrimeController {
	
	private final CrimeDAO dao;

	public CrimeController(CrimeDAO dao) {
		super();
		this.dao = dao;
	}
	
	@GetMapping(path = { "/", "home.do", "index.do" })
	public String index(Model model) {

		List<Crime> crimes = dao.findAll();
		model.addAttribute("crimes", crimes);
		return "home";
	}
	
	@GetMapping("getCrime.do")
	public ModelAndView getFilmById(@RequestParam("crimeId") int id) {
		ModelAndView mv = new ModelAndView();
		Crime theCrime = dao.findById(id);
		mv.addObject("crime", theCrime);
		mv.setViewName("show");

		return mv;
	}
	

}
