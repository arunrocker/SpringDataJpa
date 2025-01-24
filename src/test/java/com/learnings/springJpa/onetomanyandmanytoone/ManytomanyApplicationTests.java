package com.learnings.springJpa.onetomanyandmanytoone;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.learnings.springJpa.onetomanyandmanytoone.entities.Programmer;
import com.learnings.springJpa.onetomanyandmanytoone.entities.Project;
import com.learnings.springJpa.onetomanyandmanytoone.repo.ProgrammerRepo;

@SpringBootTest
class ManytomanyApplicationTests {

	@Autowired
	ProgrammerRepo repo;
	@Test
	void contextLoads() {
	}
	@Test
	void addProgrammerAndProject() {
		Programmer programmer = new Programmer();
		programmer.setName("Arun");
		programmer.setSalary(10000);
		Project project = new Project();
		project.setName("Hibernate");
		Set<Project> projects = new HashSet<>();
		projects.add(project);
		programmer.setProjects(projects);
		repo.save(programmer);
	}
	@Test
	@Transactional
	void getProgrammerAndProject() {
		Programmer programmer = repo.findById(1).get();
		System.out.println(programmer);
		System.out.println(programmer.getProjects());
	}

}
