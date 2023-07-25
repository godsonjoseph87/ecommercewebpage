package com.EcommerceWebsite.Shoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.EcommerceWebsite.Shoes.bean.Category;

public interface CategoryRepository extends JpaRepository<Category, String>{

}
