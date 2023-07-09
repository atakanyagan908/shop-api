package com.example.shopapi.service;

import com.example.shopapi.entity.Category;
import com.example.shopapi.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Service
public class CategoryServiceImpl implements CategoryService{

    private CategoryRepository categoryRepository;

    @Autowired
    CategoryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }


    @Override
    public void add(Category category) {
        this.categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Long id) {
        this.categoryRepository.deleteById(id);



    }

    @Override
    public void updateCategory(Long id, Category category) {
        Optional<Category> result = this.categoryRepository.findById(id);
        Category _category = result.get();
        _category.setId(category.getId());
        _category.setCategoryName(category.getCategoryName());
        this.categoryRepository.save(category);

    }

    @Override
    public List<Category> getAllCategories() {
        return this.categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long id) {
        Optional<Category> category =  this.categoryRepository.findById(id);
        return category.get();
    }
}
