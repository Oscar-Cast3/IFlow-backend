package com.oscar.iflow.services;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.oscar.iflow.exceptions.APIException;
import com.oscar.iflow.exceptions.ResourceNotFoundException;
import com.oscar.iflow.model.Category;

public class CategoryServiceImp implements CategoryService{
    Map<Long, Category> storage = new HashMap<>();
    private Long idCounter = 1L;

    @Override
    public Category createCategory(Category category) {
        String normalizeName = category.getName().trim().toLowerCase();

        boolean exists = storage.values().stream()
                            .anyMatch(c -> c.getName().trim().toLowerCase().equals(normalizeName));

        if (exists) {
            throw new APIException("The category with the name: " + category.getName() + " already exists.");
        }

        category.setName(normalizeName);
        category.setId(idCounter++);
        storage.put(category.getId(), category);
        return category;
    }

    @Override
    public Category getCategoryById(Long id) {
        return Optional.ofNullable(storage.get(id))
                .orElseThrow(() -> new ResourceNotFoundException("Category ", "id", id));
    }

    @Override
    public Map<Long, Category> getAllCategories() {
        if(storage.isEmpty()) 
            throw new APIException("No categories found");

        return storage;
    }

    @Override
    public Category updateCategory(Category category, Long id){
        if (!storage.containsKey(id)) 
            throw new ResourceNotFoundException("Category", "id", id);
        
        String normalizeName = category.getName().trim().toLowerCase();

        boolean exists = storage.values().stream()
                            .anyMatch(c -> !c.getId().equals(id) && c.getName().trim().toLowerCase().equals(normalizeName));

        if (exists) {
            throw new APIException("The category with the name: " + category.getName() + " already exists.");
        }

        category.setName(normalizeName);
        storage.replace(id, category);
        return storage.get(id);
    }

    @Override
    public Category deleteCategory(Long id) {
        if (!storage.containsKey(id)) 
            throw new ResourceNotFoundException("Category", "id", id);
        
        Category category = storage.get(id);
        storage.remove(id);
        return category;
    }

}
