package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.repository.SchedularService;
//import com.example.demo.model.User;
import com.example.demo.service.SecurityService;
//import com.example.demo.service.UserService;

@Controller
public class UserController {
	
//	@Autowired
//	private UserService userService;

	@Autowired
	private SecurityService securityService;
	
	@Autowired
	private SchedularService schedularService;

//	@GetMapping("/registration")
//	public String registration(Model model) {
//		if (securityService.isAuthenticated()) {
//			return "redirect:/";
//		}
//
//		model.addAttribute("userForm", new User());
//
//		return "registration";
//	}

//	@PostMapping("/registration")
//	public String registration(@ModelAttribute("userForm") User userForm) {
//
//		userService.save(userForm);
//		securityService.autoLogin(userForm.getUsername(), userForm.getPassword());
//
//		return "redirect:/welcome";
//	}

	@GetMapping("/login")
	public String login(Model model, String error, String logout) {
		if (securityService.isAuthenticated()) {
			return "redirect:/";
		}

		if (error != null)
			model.addAttribute("error", "Your username and password is invalid.");

		if (logout != null)
			model.addAttribute("message", "You have been logged out successfully.");

		return "login";
	}
 
	@GetMapping({ "/", "/welcome" })
	public String welcome(Model model) {
		return "welcome";
	}
	
	@GetMapping({ "/schedulars" })
	public String schedular(Model model) {
		model.addAttribute("schedulars",schedularService.findAllSchedular());
		return "table";
	}
}
