package com.EcommerceWebsite.Shoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.EcommerceWebsite.Shoes.bean.Orders;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders, String>{

    @Query(value="select * from orders where customerid=?2", nativeQuery = true)
    public List<Orders> findByUserId(String id);
}
