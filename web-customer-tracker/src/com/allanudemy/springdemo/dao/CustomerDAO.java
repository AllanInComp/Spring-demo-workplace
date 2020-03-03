package com.allanudemy.springdemo.dao;

import java.util.List;

import com.allanudemy.springdemo.entity.Customer;

/**
 * Data Access Object, mediates data retrieval from the mySQL database
 * @author Allan Yu
 *
 */
public interface CustomerDAO {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);
}
