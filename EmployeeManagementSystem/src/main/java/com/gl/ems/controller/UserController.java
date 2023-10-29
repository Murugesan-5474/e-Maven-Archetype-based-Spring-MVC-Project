package com.gl.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gl.ems.model.Employee;
import com.gl.ems.model.User;
import com.gl.ems.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService service;
	
	@RequestMapping("/")
	public String showHomePage() {
		return "home";
	}
	
	@GetMapping("/showRegister")
	public String showRegisterPage(Model m) {
		m.addAttribute("user", new User());
		return "registration";
	}

	@PostMapping("/processRegistrationForm")
	public String processRegisterPage(@ModelAttribute ("user") User u,Model m) {
	    service.addUser(u);
		m.addAttribute("message","User added successfully,Please login to continue");
		return "home";
	}

	@GetMapping("/showLogin")
	public String showLoginPage(Model m) {
		m.addAttribute("user", new User());
		return "login";
	}
	
	@PostMapping("/processLoginForm")
	public String processLoginPage(@ModelAttribute ("user") User u,Model m) {
	    boolean flag=service.validateUser(u);
	    
	    if (flag)
	    {
	    m.addAttribute("emp",new Employee());
		return "redirect:/showAllEmployees";
	    }
	    else
	    {
	    	m.addAttribute("errorMessage","Incorrect Credentials, Login again");
	    	return "home";
	    }
		
	}
}
