package com.learnings.springJpa.componentmapping;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.learnings.springJpa.componentmapping.enities.Address;
import com.learnings.springJpa.componentmapping.enities.Employee;
import com.learnings.springJpa.componentmapping.repo.EmployeeRepo;

@SpringBootTest
class ComponentmappingApplicationTests {

	@Autowired
	private EmployeeRepo repo;
	@Test
	void contextLoads() {
	}
	@Test
	void createEmployee() {
		Employee emp = new Employee();
		emp.setId(1);
		emp.setName("Arun");
		Address address = new Address();
		address.setStreetaddress("Armenian Street");
		address.setCity("chennai");
		address.setState("TN");
		address.setCountry("India");
		address.setZipCode("600001");
		emp.setAddress(address);
		repo.save(emp);
	}
}
