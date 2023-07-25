package com.EcommerceWebsite.Shoes.repository;

import com.EcommerceWebsite.Shoes.bean.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import com.EcommerceWebsite.Shoes.bean.Product;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String>{

    @Query(value="select * from product where categoryid=?1", nativeQuery = true)
    public List<Product> findByCategoryId(String id);
}
