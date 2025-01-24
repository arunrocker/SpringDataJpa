package com.learnings.springJpa.onetomanyandmanytoone.repo;

import org.springframework.data.repository.CrudRepository;

import com.learnings.springJpa.onetomanyandmanytoone.entities.Customer;

public interface CustomerRepo extends CrudRepository<Customer, Long>{

}
