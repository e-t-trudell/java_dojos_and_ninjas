package com.erictrudell.java_dojos_and_ninjas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erictrudell.java_dojos_and_ninjas.models.DojoModel;
import com.erictrudell.java_dojos_and_ninjas.services.DojoService;

@Controller
@RequestMapping("/dojo")
public class DojoController {
	
	@Autowired
	public DojoService dojoServ;
	
	@GetMapping("/new")
	public String newDojo(@ModelAttribute("dojo")DojoModel dojo) {
		return"newDojo.jsp";
	}
	@PostMapping("/create")
	public String create(@Valid @ModelAttribute("dojo") DojoModel dojo,
			BindingResult result) {
		if(result.hasErrors()) {
			return"newDojo.jsp";
		}else {
			dojoServ.createDojo(dojo);
			return"redirect:/";
		}
	}
	@GetMapping("/show/{dojo_id}")
	public String showDojo(@PathVariable("dojo_id")Long id, 
			Model model) {
		model.addAttribute("dojo", dojoServ.getOneDojo(id));
		model.addAttribute("allDojos", dojoServ.getAllDojos());
		return"show.jsp";
	}
}
