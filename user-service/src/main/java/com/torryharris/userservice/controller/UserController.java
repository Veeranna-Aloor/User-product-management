package com.torryharris.userservice.controller;

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
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.torryharris.userservice.entity.Product;
import com.torryharris.userservice.entity.User;
import com.torryharris.userservice.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	private final String url="http://product-service/product";
	
	/*private final String url="http://localhost:8200/product";
	
	public UserController()
	{
		restTemplate=new RestTemplate();
	}
	*/
	@Autowired
	private UserService userService;
	
	@GetMapping
	public List<User> getAllUser(){
		return userService.getAllUsers();
	}
	
	//Micro-service call to get all products
	
	@SuppressWarnings("unchecked")
	@GetMapping("/product")
	public List<Product> getAllProducts()
	{
		//String url="http://localhost:8200/product";
		List<Product> prodList=restTemplate.getForObject(url, List.class);
		//We use .getForObject when return type is object
		//if return type is entity we use .getForEntity
		return prodList;
	}
	
	//microservice to get product by ID
	
	/*
	 * @GetMapping("/product/{productId}")
	 
	public Product getProductById(@PathVariable UUID productId)
	{
		Product product=restTemplate.getForObject(url+"/"+productId, Product.class);
		
		return product;
	}
	*/
	
	
	@GetMapping("/product/{productId}")
	public ResponseEntity<Object> getProductById(@PathVariable UUID productId)
	{
		try {
			Product product=restTemplate.getForObject(url+"/"+productId,Product.class);
			return new ResponseEntity<Object>(product,HttpStatus.OK);
		}
		catch(HttpClientErrorException ex){
			
			return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.NOT_FOUND);
			
		}
	}
	

	//microservice to add a product
	
	/*
	 * @PostMapping("/product") public ResponseEntity<String>
	 * addProduct(@RequestBody Product product) { restTemplate.
	 * 
	 * }
	 */
	
	
	@GetMapping("/{userId}")
	public User getUserById(@PathVariable Integer userId)
	{
		return userService.getUserById(userId);
	}
	
	@PostMapping
	public ResponseEntity<String> addUser(@RequestBody User user)
	{
		userService.addUser(user);
		return new ResponseEntity<String>("User added successfully with ID:"+user.getUserId(),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<String> deleteUserById(@PathVariable Integer userId)
	{
		userService.deleteUserById(userId);
		return new ResponseEntity<String>("User deleted successfully with ID:"+userId,HttpStatus.OK);
	}
	
	@PutMapping("/{userId}")
	public ResponseEntity<String> updateUser(@RequestBody User updatedUser,@PathVariable Integer userId)
	{
		userService.updateUser(userId, updatedUser);
		
		return new ResponseEntity<String>("User updated successfully with ID:"+userId,HttpStatus.OK);
	}
	
	

}
