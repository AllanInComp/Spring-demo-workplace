package com.allanudemy.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	@RequestMapping("showMyLoginPage")
	public String showLoginPage() {
		return "plain-login";
	}
	
	

}
