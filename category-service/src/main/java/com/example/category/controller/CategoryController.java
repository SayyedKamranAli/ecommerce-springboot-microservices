package com.example.category.controller;

import com.example.category.model.Category;
import com.example.category.service.CategoryService;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {

	@Autowired
    CategoryService categoryService;
    
//    public CategoryController(CategoryService categoryService) {
//    	 this.categoryService = categoryService;
//    }

    @GetMapping
    public List<Category> getAll() {
        return categoryService.getAllCategories();
    }
    
    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }

    @PostMapping
    public Category create(@RequestBody Category category) {
        return categoryService.createCategory(category);
    }

    @PutMapping("/update/{id}")
    public Category update(@PathVariable Long id, @RequestBody Category category) {
        return categoryService.updateCategory(id, category);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }
}
