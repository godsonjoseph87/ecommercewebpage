package com.EcommerceWebsite.Shoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EcommerceWebsite.Shoes.bean.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String>{
	

}
