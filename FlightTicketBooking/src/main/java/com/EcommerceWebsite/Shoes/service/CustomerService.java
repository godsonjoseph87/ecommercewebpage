package com.EcommerceWebsite.Shoes.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.EcommerceWebsite.Shoes.util.JsonResponseUtil;
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

	public Map<String, Object> getCustomerAllDetails() {
		List<Map<String, Object>> obj = customerRepo.getCustomerAllDetails();
		return JsonResponseUtil.createJsonResponse("Data fetched successfully", 200, obj);
	}

	public void addCustomer(Customer customer) {
		customerRepo.save(customer);
	}
}
