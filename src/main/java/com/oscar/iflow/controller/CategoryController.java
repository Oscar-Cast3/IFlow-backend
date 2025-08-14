package com.oscar.iflow.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oscar.iflow.model.Category;
import com.oscar.iflow.services.CategoryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api")
public class CategoryController {
    @Autowired
    CategoryService service;

    @PostMapping("/categories")
    public ResponseEntity<?> createCategory(@RequestBody Category category) {
        service.createCategory(category);
        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable Long id) {
        Category category = service.getCategoryById(id);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @GetMapping("/categories")
    public ResponseEntity<?> getAllCategories() {
        Map<Long,Category> storage = service.getAllCategories();
        return new ResponseEntity<>(storage, HttpStatus.OK);
    }
    
    @DeleteMapping("/categories/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id){
        Category category = service.deleteCategory(id);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }
}
