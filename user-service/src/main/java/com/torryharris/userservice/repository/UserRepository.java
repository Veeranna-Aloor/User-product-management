package com.torryharris.userservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.torryharris.userservice.entity.User;


@Repository
public interface UserRepository extends CrudRepository<User,Integer>{

}
