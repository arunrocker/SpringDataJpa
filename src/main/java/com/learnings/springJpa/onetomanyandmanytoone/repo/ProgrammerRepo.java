package com.learnings.springJpa.onetomanyandmanytoone.repo;

import org.springframework.data.repository.CrudRepository;

import com.learnings.springJpa.onetomanyandmanytoone.entities.Programmer;

public interface ProgrammerRepo extends CrudRepository<Programmer, Integer>{

}
