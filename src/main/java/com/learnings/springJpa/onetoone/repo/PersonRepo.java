package com.learnings.springJpa.onetoone.repo;

import org.springframework.data.repository.CrudRepository;

import com.learnings.springJpa.onetoone.entities.Person;

public interface PersonRepo extends CrudRepository<Person, Long> {

}
