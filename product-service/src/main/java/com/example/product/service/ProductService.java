package com.example.product.service;

import com.example.product.Client.CategoryClient;
import com.example.product.POJO.Category;
import com.example.product.POJO.ProductResp;
import com.example.product.model.Product;
import com.example.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
	

	@Autowired
    ProductRepository productRepository;
	
	@Autowired
    private CategoryClient categoryClient;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    
    public List<ProductResp> getProductByCategory(Long categoryId) {
        List<Product> products = productRepository.findAllByCategoryId(categoryId);
        List<ProductResp> resps = new ArrayList<>();

        for (Product product : products) {
            try {
                Category category = categoryClient.getCategoryById(product.getCategoryId());
                resps.add(new ProductResp(product, category));
            } catch (Exception e) {
                // ✅ Agar category service fail ho gayi, to fallback already chalega
                Category defaultCategory = new Category();
                defaultCategory.setId(product.getCategoryId());
                defaultCategory.setName("Unknown");
                defaultCategory.setDescription("Category service down");
                resps.add(new ProductResp(product, defaultCategory));
            }
        }
        return resps;
    }



    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product product) {
        Product existing = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        existing.setName(product.getName());
        existing.setDescription(product.getDescription());
        existing.setPrice(product.getPrice());
        return productRepository.save(existing);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
