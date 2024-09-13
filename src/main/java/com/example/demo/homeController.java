package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class homeController {
	
	@Autowired
	ContactUsService Contsr;
	
	
	
	@PostMapping("/upload")
	public String upload(
			@RequestParam String name,
			@RequestParam String email,
			@RequestParam String message, Model m) {
		String msg = Contsr.SaveContactUs(name, email, message);
		return "redirect:/success";
		
	}
	@GetMapping("/show")
	public String show(Model m) {
		m.addAttribute("data", Contsr.show());
		return "show";
	}
	
	

}
