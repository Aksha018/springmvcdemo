package com.chainsys.springmvcdemo;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/emp")
public class EmployeeController {
	
	@Autowired 
	EmployeeServices employeeServices;
	
	
	@GetMapping("/register")
	public String showAdd(Model model) {
		EmployeeModel regist = new EmployeeModel();
		model.addAttribute("add", regist);
		return "register";
	}

	@PostMapping("/addemployee")
	public String addNewPerson(@ModelAttribute("add") EmployeeModel regist) {
		employeeServices.save(regist);
		return "redirect:/emp/login";
	}
	
	@GetMapping("/login")
	public String loginForm(Model model) {
		EmployeeLogin login = new EmployeeLogin();
		model.addAttribute("login", login);
		return "login";
	}

	@PostMapping("/loginPage")
	public String loginPage(@ModelAttribute("login") EmployeeLogin login, Model model) {
		EmployeeModel emp = employeeServices.getEmailAndPassword(login.getEmail(),login.getPassword());
		if(emp != null) {
			model.addAttribute("login", emp);
			return "home";
		} else {
			model.addAttribute("result", "Password or Email Id is wrong");
			return "login";	
		}
	}

}


