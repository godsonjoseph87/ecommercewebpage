package com.EcommerceWebsite.Shoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EcommerceWebsite.Shoes.bean.Customer;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface CustomerRepository extends JpaRepository<Customer, String>{

    @Query(value="select name, email, phone, address from customer", nativeQuery = true)
    public List<Map<String, Object>> getCustomerAllDetails();
}
