package com.EcommerceWebsite.Shoes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EcommerceWebsite.Shoes.bean.Category;
import com.EcommerceWebsite.Shoes.repository.CategoryRepository;
import com.EcommerceWebsite.Shoes.util.JsonResponseUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    public CategoryRepository categoryRepo;

    public Map<String, Object> addCategory(Category category) {
        categoryRepo.save(category);
        return JsonResponseUtil.createJsonResponse("New Category Successfully Added", 200, "");

    }

    public Map<String, Object> getAllCategory() {
        List<Category> category = new ArrayList<>();
        category = categoryRepo.findAll();
        return JsonResponseUtil.createJsonResponse("Data Fetched Successfully.", 200, category);
    }

    public Map<String, Object> getCategoryById(String id) {
        Optional<Category> category = categoryRepo.findById(id);
        return JsonResponseUtil.createJsonResponse("Data fetched successfully", 200, category);
    }

}
