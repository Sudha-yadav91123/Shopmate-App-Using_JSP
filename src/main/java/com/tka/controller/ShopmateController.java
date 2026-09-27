
package com.tka.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class ShopmateController {

	@GetMapping("/")
	public String getIndexPage(HttpSession sessn) {
		sessn.setAttribute("log", "");
		return "index";
	}

	@GetMapping("/home")
	public String getHomePage(HttpSession sessn, Model model) {
		String log = (String) sessn.getAttribute("log");
		if (log.equals("user")) {
			return "home";
		} else
			model.addAttribute("msg", "Login first**");
		return "login";
	}

	@GetMapping("/login")
	public String getLoginPage() {
		return "login";
	}

	@GetMapping("/register")
	public String getRegisterPage() {
		return "register";
	}

	@GetMapping("/logout")
	public String logout(HttpSession sessn) {
		sessn.setAttribute("log", "");
		return "index";
	}

	@GetMapping("/payment-success")
	public String paymentSuccess() {
		return "payment-success";
	}

}
