package com.learnings.springJpa.hibernateinheritance.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.learnings.springJpa.hibernateinheritance.entity.Payment;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, Integer>{

}
