package com.allanudemy.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * You can have multiple controller classes in a spring bean web app setting
 * Risk: @RequestMapping ambiguity may not be apparent in different classes
 * Solution: Include a request mapping for the controller class as well
 * @author Allan Yu
 *
 */
@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String displayTheForm() {
		return "main-menu";
	}
}
