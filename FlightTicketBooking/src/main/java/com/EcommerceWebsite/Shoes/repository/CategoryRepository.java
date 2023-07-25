package com.EcommerceWebsite.Shoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.EcommerceWebsite.Shoes.bean.Category;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, String>{

    @Transactional
    @Modifying
    @Query(value="delete from categories where id=?1", nativeQuery = true)
    public void deleteByCatId(String id);
}
