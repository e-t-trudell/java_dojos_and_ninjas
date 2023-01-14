package com.erictrudell.java_dojos_and_ninjas.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.erictrudell.java_dojos_and_ninjas.models.DojoModel;
import com.erictrudell.java_dojos_and_ninjas.services.DojoService;

@Controller
public class HomeController {
	@Autowired
	public DojoService dojoServ;
	@GetMapping("/")
	public String land(Model model) {
		List<DojoModel> allDojos = dojoServ.getAllDojos();
		model.addAttribute("allDojos", allDojos);
		return"index.jsp";
	}
	
	
}
