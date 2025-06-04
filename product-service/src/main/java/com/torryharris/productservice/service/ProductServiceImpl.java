package com.torryharris.productservice.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.torryharris.productservice.entity.Product;
import com.torryharris.productservice.exception.ProductNotFoundException;
import com.torryharris.productservice.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	
	@Autowired
	private ProductRepository productRepository;
	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return (List<Product>) productRepository.findAll();
	}

	@Override
	public Product getProductById(UUID productId) {
		// TODO Auto-generated method stub
		Optional<Product> productopt=productRepository.findById(productId);
		if(productopt.isPresent())
		{
			return productopt.get();
		}
		else {
			throw new ProductNotFoundException("Product Not found with ID:"+productId);
		}
	}

	@Override
	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		productRepository.save(product);
		
	}

	@Override
	public void deleteProductById(UUID productId) {
		// TODO Auto-generated method stub
		Product product=getProductById(productId);
		productRepository.delete(product);
		
	}

	@Override
	public void updateProduct(UUID productId, Product updatedProduct) {
		// TODO Auto-generated method stub
		Product product=getProductById(productId);
		product.setProductName(updatedProduct.getProductName());
		product.setCategory(updatedProduct.getCategory());
		product.setPrice(updatedProduct.getPrice());
		
		productRepository.save(product);
		
	}

}
