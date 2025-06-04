package com.torryharris.productservice.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.torryharris.productservice.entity.Product;
import com.torryharris.productservice.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public List<Product> getAllProducts()
	{
		return productService.getAllProducts();
	}
	
	@GetMapping("/{productId}")
	public Product getProductById(@PathVariable UUID productId)
	{
		return productService.getProductById(productId);
	}
	
	@PostMapping
	public ResponseEntity<String> addProduct(@RequestBody Product product)
	{
		productService.addProduct(product);
		
		return new ResponseEntity<String>("Product added successfully with ID:"+product.getProductId(),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{productId}")
	public ResponseEntity<String> deleteProductById(@PathVariable UUID productId)
	{
		productService.deleteProductById(productId);
		
		return new ResponseEntity<String>("Product deleted successfully with ID:"+productId,HttpStatus.OK);
	}
	
	@PutMapping("/{productId}")
	public ResponseEntity<String> updateProduct(@PathVariable UUID productId,@RequestBody Product updatedProduct)
	{
		productService.updateProduct(productId, updatedProduct);
		
		return new ResponseEntity<String>("Product updated successfully with productId:"+productId,HttpStatus.OK);
	}

}
