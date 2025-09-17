package com.example.product.controller;

import com.example.product.POJO.ProductResp;
import com.example.product.model.Product;
import com.example.product.service.ProductService;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

	@Autowired
    ProductService productService;

    @GetMapping
    public List<Product> getAll() {
        return productService.getAllProducts();
    }
    
    @GetMapping("/{id}")
    public List<ProductResp> getProductByCategory(@PathVariable Long id) {
    	try {
            return productService.getProductByCategory(id);    		
    	}catch (Exception e) {
    		e.printStackTrace();
            return null;
		}
    }

    @PostMapping
    public Product create(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PutMapping("/update/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}
