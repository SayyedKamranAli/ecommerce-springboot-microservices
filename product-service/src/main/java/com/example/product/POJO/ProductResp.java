package com.example.product.POJO;

import com.example.product.model.Product;

public class ProductResp {
	
	public Long id;
	public String name;
	public String description;
	public Double price;
    public Category category;
    
    public ProductResp(Product product, Category category) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.category = category;
    }

}
