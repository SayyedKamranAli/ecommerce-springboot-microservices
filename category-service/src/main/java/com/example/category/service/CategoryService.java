package com.example.category.service;

import com.example.category.model.Category;
import com.example.category.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
	

	@Autowired
	CategoryRepository categoryRepository;
    
//    public CategoryService(CategoryRepository categoryRepository) {
//   	 this.categoryRepository = categoryRepository;
//   }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
    
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category updateCategory(Long id, Category category) {
        Category existing = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        existing.setName(category.getName());
        existing.setDescription(category.getDescription());
        return categoryRepository.save(existing);
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
