package com.torryharris.productservice.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.torryharris.productservice.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, UUID>{

}
