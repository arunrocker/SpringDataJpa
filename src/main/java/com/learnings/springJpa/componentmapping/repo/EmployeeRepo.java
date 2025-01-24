package com.learnings.springJpa.componentmapping.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.learnings.springJpa.componentmapping.enities.Employee;

@Repository
public interface EmployeeRepo extends CrudRepository<Employee, Integer> {

}
