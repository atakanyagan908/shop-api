package com.example.shopapi.service;

import com.example.shopapi.entity.Category;

import java.util.List;

public interface CategoryService {
    void add(Category category);
    void deleteCategory(Long id);
    void updateCategory(Long id, Category category);

    List<Category> getAllCategories();

    Category getCategoryById(Long id);



}
