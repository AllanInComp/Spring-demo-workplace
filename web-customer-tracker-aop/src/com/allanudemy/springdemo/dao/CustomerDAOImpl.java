package com.allanudemy.springdemo.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.allanudemy.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	//injects session factory
	@Autowired 
	private SessionFactory sessionFactory;
	
	//doesn't need transactional, already handled by Service layer
	@Override
	public List<Customer> getCustomers() {
		//get current hibernate session
			//session is autowired into this DAO class via @Autowired
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create query
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName",Customer.class);
		
		//execute query and get result list 
		List<Customer> customers = theQuery.getResultList();
		
		//return the results (customers that we retrieved)
		return customers;
		
	}

	/**
	 * Save or update a Customer according to if the primary key exists in the database
	 */
	@Override
	public void saveCustomer(Customer theCustomer) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theCustomer);
		
	}

	@Override
	public Customer getCustomer(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();

		Customer theCustomer = currentSession.get(Customer.class, theId);
		
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
	
		Query theQuery = currentSession.createQuery("delete from Customer where id =:theCustomerId");
		theQuery.setParameter("theCustomerId", theId);
		
		theQuery.executeUpdate();
	}

}
