package com.EcommerceWebsite.Shoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EcommerceWebsite.Shoes.bean.Payments;

public interface PaymentRepository extends JpaRepository<Payments, String>{


}
