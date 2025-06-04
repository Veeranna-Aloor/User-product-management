package com.torryharris.userservice.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.torryharris.userservice.entity.User;
import com.torryharris.userservice.exception.UserNotFoundException;
import com.torryharris.userservice.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return (List<User>)userRepository.findAll();
	}

	@Override
	public User getUserById(Integer userId) {
		// TODO Auto-generated method stub
		Optional<User>userOpt=userRepository.findById(userId);
		if(userOpt.isPresent())
		{
			return userOpt.get();
		}else {
			throw new UserNotFoundException("User not found with ID:"+userId);
		}
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		userRepository.save(user);
		
	}

	@Override
	public void deleteUserById(Integer userId) {
		// TODO Auto-generated method stub
		User user=getUserById(userId);
		userRepository.delete(user);
		
	}

	@Override
	public void updateUser(Integer userId, User updatedUser) {
		// TODO Auto-generated method stub
		User user=getUserById(userId);
		user.setUserName(updatedUser.getUserName());
		user.setLocation(updatedUser.getLocation());
		user.setEmailId(updatedUser.getEmailId());
		
		userRepository.save(user);
		
		
	}

}
