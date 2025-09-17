package com.example.product.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.product.POJO.Category;

@FeignClient(
	    name = "category-service",
	    url = "http://localhost:8082/api/categories",
	    fallback = CategoryClientFallback.class
	)
public interface CategoryClient {
	
	@GetMapping("/{id}")
    Category getCategoryById(@PathVariable Long id);

}
