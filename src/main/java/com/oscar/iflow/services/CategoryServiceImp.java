package com.oscar.iflow.services;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.oscar.iflow.model.Category;

public class CategoryServiceImp implements CategoryService{
    Map<Long, Category> storage = new HashMap<>();
    private Long idCounter = 1L;

    @Override
    public Category createCategory(Category category) {
        category.setId(idCounter++);
        storage.put(category.getId(), category);
        return category;
    }

    @Override
    public Category getCategoryById(Long id) {
        return storage.get(id);
    }

    @Override
    public Map<Long, Category> getAllCategories() {
        return storage;
    }

    @Override
    public Category deleteCategory(Long id) {
        Category category = storage.get(id);
        storage.remove(id);
        return category;
    }

}
