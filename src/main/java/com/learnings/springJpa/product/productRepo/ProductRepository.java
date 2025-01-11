package com.learnings.springJpa.product.productRepo;

import org.springframework.data.repository.CrudRepository;

import com.learnings.springJpa.product.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>{

}
