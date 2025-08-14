package com.oscar.iflow.services;

import java.util.Map;

import com.oscar.iflow.model.Category;

public interface CategoryService {
    Category createCategory(Category category);
    Category getCategoryById(Long id);
    Map<Long, Category> getAllCategories();
    Category updateCategory(Category category, Long id);
    Category deleteCategory(Long id);
}
