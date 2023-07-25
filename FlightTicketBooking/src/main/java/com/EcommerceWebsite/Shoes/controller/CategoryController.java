package com.EcommerceWebsite.Shoes.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.EcommerceWebsite.Shoes.bean.Category;
import com.EcommerceWebsite.Shoes.service.CategoryService;

@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/getallcategory")
    public Map<String, Object> getAllCategory()
    {
        return categoryService.getAllCategory();
    }

    @RequestMapping(method = RequestMethod.POST, value="/savecategory")
    public Map<String, Object> allCategory(@RequestBody Category category)
    {
        return categoryService.addCategory(category);
    }

    @RequestMapping(method = RequestMethod.POST, value="/getcategorybyid/{id}")
    public Map<String, Object> getCategoryById(@RequestBody String id)
    {
        return categoryService.getCategoryById(id);
    }

}
