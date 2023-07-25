package com.EcommerceWebsite.Shoes.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.EcommerceWebsite.Shoes.bean.Product;
import com.EcommerceWebsite.Shoes.service.ProductService;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/getAllProducts")
    public Map<String, Object> getAllProducts()
    {
        return productService.getAllProducts();
    }

    @RequestMapping(method = RequestMethod.GET, value="/getProductById/{id}")
    public Map<String, Object> getProductById(@RequestBody String id)
    {
        return productService.getProductById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value="/getProductByCategoryId/{id}")
    public Map<String, Object> getProductByCategoryId(@RequestBody String id)
    {
        return productService.getProductByCategoryId(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value="/updateProduct")
    public Map<String, Object> updateProducts(Product product)
    {
        return productService.updateProducts(product);
    }

    @RequestMapping(method = RequestMethod.POST, value="/addproduct")
    public Map<String, Object> addProduct(@RequestBody Product product)
    {
        return productService.addProduct(product);
    }

}
