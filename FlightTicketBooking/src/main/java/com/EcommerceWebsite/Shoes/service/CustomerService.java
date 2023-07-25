package com.EcommerceWebsite.Shoes.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EcommerceWebsite.Shoes.bean.Customer;
import com.EcommerceWebsite.Shoes.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	public CustomerRepository customerRepo;

	
	public Optional<Customer> getCustomerDetails(String id) {
		return customerRepo.findById(id);
	}

	public void addCustomer(Customer customer) {
		customerRepo.save(customer);
	}
}
