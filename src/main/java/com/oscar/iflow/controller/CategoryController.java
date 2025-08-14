package com.oscar.iflow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oscar.iflow.services.CategoryService;

@RestController
@RequestMapping("/api")
public class CategoryController {
    @Autowired
    CategoryService service;
}
