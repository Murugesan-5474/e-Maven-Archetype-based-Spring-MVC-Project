package com.gl.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gl.ems.model.Employee;
import com.gl.ems.model.User;
import com.gl.ems.service.EmployeeService;

@Controller
public class EmployeeController {
@Autowired
EmployeeService service;

@PostMapping("/processAddEmployee")
public String processAddEmployee(@ModelAttribute ("emp") Employee e,Model m) {
	service.addEmployee(e);
	return "redirect:/showAllEmployees";
	
}

@PostMapping("/processUpdateEmployee")
public String processUpdateEmployee(@ModelAttribute ("emp") Employee e,Model m) {
	service.updateEmployee(e);
	return "redirect:/showAllEmployees";
	
}
@PostMapping("/showUpdateEmployee")
public String showUpdateEmployee(@RequestParam int empId,Model m) {
	m.addAttribute("emp",service.getEmployeeById(empId));
	return "showUpdateEmployee";
	
}
@PostMapping("/deleteEmployeeById")
public String processAddEmployee(@RequestParam int empId) {
	service.deleteById(empId);
	return "redirect:/showAllEmployees";
	
}
@RequestMapping("/showAllEmployees")
public String showAllEmployees(Model m) {
	m.addAttribute("emp",new Employee());
	m.addAttribute("employees",service.getAllEmployees());
	return "menu";
}
}

