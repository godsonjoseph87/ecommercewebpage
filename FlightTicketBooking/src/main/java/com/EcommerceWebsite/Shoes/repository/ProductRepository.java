package com.EcommerceWebsite.Shoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.EcommerceWebsite.Shoes.bean.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String>{

    @Query(value="select * from product where categoryid=?1", nativeQuery = true)
    public List<Product> findByCategoryId(String id);

    @Transactional
    @Modifying
    @Query(value="delete from product where id=?1", nativeQuery = true)
    public void deleteById(Long id);
}
