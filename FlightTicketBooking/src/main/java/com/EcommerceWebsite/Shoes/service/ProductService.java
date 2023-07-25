package com.EcommerceWebsite.Shoes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EcommerceWebsite.Shoes.bean.Product;
import com.EcommerceWebsite.Shoes.repository.ProductRepository;
import com.EcommerceWebsite.Shoes.util.JsonResponseUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    public ProductRepository productRepo;

    public Map<String, Object> addProduct(Product product) {
        productRepo.save(product);
        return JsonResponseUtil.createJsonResponse("New Product Successfully Added", 200, "");

    }

    public Map<String, Object> updateProducts(Product product) {
        productRepo.save(product);
        return JsonResponseUtil.createJsonResponse("Product Updated Successfully", 200, "");

    }

    public Map<String, Object> getProductById(String id) {
        Optional<Product> product = productRepo.findById(id);
        return JsonResponseUtil.createJsonResponse("Product Details Fetched", 200, product);

    }

    public Map<String, Object> getAllProducts() {
        List<Product> product = new ArrayList<>();
        product = productRepo.findAll();
        return JsonResponseUtil.createJsonResponse("Data Fetched Successfully.", 200, product);
    }

    public Map<String, Object> getProductByCategoryId(String id) {
        List<Product> category = productRepo.findByCategoryId(id);
        return JsonResponseUtil.createJsonResponse("Data fetched successfully", 200, category);
    }

}