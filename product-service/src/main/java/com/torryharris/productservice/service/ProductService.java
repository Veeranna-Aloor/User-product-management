package com.torryharris.productservice.service;

import java.util.List;
import java.util.UUID;

import com.torryharris.productservice.entity.Product;

public interface ProductService {
	
	List<Product> getAllProducts();
	
	Product getProductById(UUID productId);
	void addProduct(Product product);
	void deleteProductById(UUID productId);
	void updateProduct(UUID productId,Product updatedProduct);

}
