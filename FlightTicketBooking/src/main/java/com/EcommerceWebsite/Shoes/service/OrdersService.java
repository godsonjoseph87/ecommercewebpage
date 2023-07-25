package com.EcommerceWebsite.Shoes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EcommerceWebsite.Shoes.bean.Orders;
import com.EcommerceWebsite.Shoes.repository.OrdersRepository;
import com.EcommerceWebsite.Shoes.util.JsonResponseUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class OrdersService {
    @Autowired
    public OrdersRepository ordersRepo;

    public Map<String, Object> addOrder(Orders orders) {
        ordersRepo.save(orders);
        return JsonResponseUtil.createJsonResponse("New Order Placed Successfully.", 200, "");
    }

    public Map<String, Object> getAllOrders() {
        List<Orders> orders = new ArrayList<>();
        orders = ordersRepo.findAll();
        return JsonResponseUtil.createJsonResponse("Data Fetched Successfully.", 200, orders);
    }

    public Map<String, Object> getOrderByUserId(String id) {
        List<Orders> order = ordersRepo.findByUserId(id);
        return JsonResponseUtil.createJsonResponse("Data fetched successfully", 200, order);
    }

    public Map<String, Object> getOrderById(String id) {
        Optional<Orders> order = ordersRepo.findById(id);
        return JsonResponseUtil.createJsonResponse("Data fetched successfully", 200, order);
    }

    public Map<String, Object> updateOrder(Orders order) {
        ordersRepo.save(order);
        return JsonResponseUtil.createJsonResponse("Order Updated Successfully", 200, "");
    }

}
