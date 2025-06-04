package com.torryharris.userservice.service;

import java.util.List;

import com.torryharris.userservice.entity.User;

public interface UserService {
	
	List<User> getAllUsers();
	User getUserById(Integer userId);
	void addUser(User user);
	void deleteUserById(Integer userId);
	void updateUser(Integer userId,User updatedUser);

}
