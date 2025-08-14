package com.oscar.iflow.services;

import java.util.HashMap;
import java.util.Map;

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

}
