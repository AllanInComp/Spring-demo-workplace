package com.allanudemy.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.allanudemy.springdemo.entity.Customer;
import com.allanudemy.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//inject the customer service instead
	@Autowired
	private CustomerService customerService;
	
	/*
	 * //need to inject the DAO into the controller, @Autowired scans the package
	 * for the DAO object
	 * 
	 * @Autowired private CustomerDAO customerDAO;
	 */
	
	/**
	 * Returns address of customer list  
	 * @param theModel
	 * @return
	 */
	@GetMapping("/list") //similar to @RequestMapping("/list"), but only handles get mappings 
	public String listCustomers(Model theModel) {
//		//get customers from DAO
//		List<Customer> theCustomers = customerDAO.getCustomers();
		
		
		//get the customer from the service instead of the DAO
		List<Customer> theCustomers = customerService.getCustomers();
		
		//add customers to the model to be used by the JSP
		theModel.addAttribute("customers",theCustomers);
		
		return "list-customer";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Customer theCustomer = new Customer();
		theModel.addAttribute("customer",theCustomer);
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		customerService.saveCustomer(theCustomer);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {
		
		//get the Customer from the database (using the service) specifying the id
		Customer theCustomer = customerService.getCustomer(theId);
		
		//set customer as a model attribute to pre-populate the form
		theModel.addAttribute("customer",theCustomer);
		
		//send over to the form in view (jsp)
		return "customer-form";
	}
	
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId) {
		customerService.deleteCustomer(theId);
		
		return "redirect:/customer/list";
	}
	
	
	
	
	
	
}
