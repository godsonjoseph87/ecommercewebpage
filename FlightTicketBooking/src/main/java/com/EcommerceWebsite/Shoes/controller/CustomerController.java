package com.EcommerceWebsite.Shoes.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.EcommerceWebsite.Shoes.bean.Customer;
import com.EcommerceWebsite.Shoes.service.CustomerService;

@RestController
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@RequestMapping(method = RequestMethod.GET, value="/customer/{id}")
	public Optional<Customer> getCustomerDetails(@PathVariable String id)
	{
		return customerService.getCustomerDetails(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/customer")
	public void addCustomer(@RequestBody Customer customer)
	{
		customerService.addCustomer(customer);
	}
	
}
