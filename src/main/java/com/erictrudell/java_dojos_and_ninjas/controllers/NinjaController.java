package com.erictrudell.java_dojos_and_ninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erictrudell.java_dojos_and_ninjas.models.DojoModel;
import com.erictrudell.java_dojos_and_ninjas.models.NinjaModel;
import com.erictrudell.java_dojos_and_ninjas.services.DojoService;
import com.erictrudell.java_dojos_and_ninjas.services.NinjaService;
@Controller
@RequestMapping("/ninja")
public class NinjaController {
	
	@Autowired
	public NinjaService ninjaServ;
	@Autowired
	public DojoService dojoServ;
	
	@GetMapping("/new")
	public String newNinja(@ModelAttribute("ninja")NinjaModel ninja,
			Model model) {
		List<DojoModel> allDojos = dojoServ.getAllDojos();
		model.addAttribute("dojos",allDojos);
		model.addAttribute("ninja", ninja);
		return"newNinja.jsp";
	}
//	add dojo to model att
	@PostMapping("/create")
	public String create(@Valid @ModelAttribute("ninja") NinjaModel ninja,
			BindingResult result, 
			Model model) {
		if(result.hasErrors()) {
//			model.addAttribute("dojo", dojoServ.getOneDojo(id));
			return"newDojo.jsp";
		}else {
			model.addAttribute("dojos", dojoServ.getAllDojos());
			ninjaServ.createNinja(ninja);
			return"redirect:/";
		}
		
		
		
	}
}
