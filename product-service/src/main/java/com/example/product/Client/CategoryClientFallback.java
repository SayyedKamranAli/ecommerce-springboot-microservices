package com.example.product.Client;
import org.springframework.stereotype.Component;

import com.example.product.POJO.Category;

@Component
public class CategoryClientFallback implements CategoryClient {

    @Override
    public Category getCategoryById(Long id) {
        // ✅ Category service down hai, to default response return karo
        Category category = new Category();
        category.setId(id);
        category.setName("Unknown Category");
        category.setDescription("Category service unavailable right now");
        return category;
    }
}
