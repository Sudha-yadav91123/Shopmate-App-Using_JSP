package com.tka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tka.model.Customer;
import com.tka.service.CustomerService;

import jakarta.servlet.http.HttpSession;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping("/register-customer")
	public String addCustomer(@ModelAttribute Customer customer, Model model) {
		System.err.println("customer >> " + customer);
		customerService.addCustomer(customer);
		model.addAttribute("msg", "User registered successfully!");
		return "login"; // after registration, redirect to login page
	}

	@PostMapping("/verify-login")
	public String verifyLoginCred(String username, String password, Model model, HttpSession httpsessn) {
	    Customer customer = customerService.verifyLoginCred(username, password);
	    if (customer != null) {
	        httpsessn.setAttribute("log", "user");
	        httpsessn.setAttribute("id", customer.getCid());
	        httpsessn.setAttribute("email", customer.getEmail());
	        model.addAttribute("msg", customer.getUsername()+" login successfully!");
	        return "home";
	    }
	    model.addAttribute("msg", "User login FAILED!");
	    return "login";
	}


	@GetMapping("/profile")
	public String getCustomer(Model model, HttpSession sessn) {
		String log = (String) sessn.getAttribute("log");
		if ("user".equals(log)) {
			int id = (int) sessn.getAttribute("id");
			Customer customer = customerService.getCustomerById(id);
			model.addAttribute("customer", customer);
			return "profile";
		}
		model.addAttribute("msg", "Login first**");
		return "login";
	}

	@GetMapping("/update-profile")
	public String updateCustomer(Model model, HttpSession session) {

	    int id = (int) session.getAttribute("id");

	    Customer customer = customerService.getCustomerById(id);

	    model.addAttribute("customer", customer);

	    return "update-profile";
	}


	@PostMapping("/update-profile")
	public String updateProfile(Customer customer, HttpSession session, Model model) {

	    int id = (int) session.getAttribute("id");

	    customer.setCid(id);   // VERY IMPORTANT

	    customerService.addCustomer(customer);

	    model.addAttribute("msg", "Profile Updated Successfully");

	    return "redirect:/profile";
	}


}