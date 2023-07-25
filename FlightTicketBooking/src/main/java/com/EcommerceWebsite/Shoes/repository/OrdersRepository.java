package com.EcommerceWebsite.Shoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.EcommerceWebsite.Shoes.bean.Orders;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface OrdersRepository extends JpaRepository<Orders, String>{

    @Query(value="select * from orders where customerid=?2", nativeQuery = true)
    public List<Orders> findByUserId(String id);

    @Query(value="select o.quantity, o.price, o.date, o.orderstatus," +
            "c.name as customername, p.name as productname, cat.name as categoryname" +
            " from orders as o " +
            "left join customer as c on c.id = o.customerid " +
            "left join product as p on p.id = o.productid " +
            "left join categories as cat on cat.id = o.categoryid", nativeQuery = true)
    public List<Map<String, Object>> getAllOrdersDetails();
}
