package com.learnings.springJpa.onetomanyandmanytoone;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.learnings.springJpa.onetomanyandmanytoone.entities.Customer;
import com.learnings.springJpa.onetomanyandmanytoone.entities.PhoneNumber;
import com.learnings.springJpa.onetomanyandmanytoone.repo.CustomerRepo;

@SpringBootTest
class OnetomanyandmanytooneApplicationTests {
	@Autowired
	private CustomerRepo repo;
	@Test
	void contextLoads() {
	}
	@Test
	void addRecord() {
		Customer customer = new Customer();
		customer.setName("Rajini");
		Set<PhoneNumber> phoneNumbers = new HashSet<>();
		PhoneNumber ph1 = new PhoneNumber();
		ph1.setNumber("7305238584");
		ph1.setType("cell");
		//ph1.setCustomer(customer);
		customer.addPhoneNumber(ph1);
		PhoneNumber ph2 = new PhoneNumber();
		ph2.setNumber("43135822");
		ph2.setType("landline");
		//ph2.setCustomer(customer);
		//phoneNumbers.add(ph1);
		//phoneNumbers.add(ph2);
		customer.addPhoneNumber(ph2);
		//customer.setPhoneNumbers(phoneNumbers);
		repo.save(customer);
	}
	@Test
	@Transactional
	void fetchRecordByLazyLoading() {
		Customer customer = repo.findById(4l).get();
		System.out.println(customer.getName());
		customer.getPhoneNumbers().forEach(no->System.out.println(no.getNumber()));
		//customer.setPhoneNumbers(phoneNumbers);
	}
	@Test
	void updateRecord() {
		Customer customer = repo.findById(4l).get();
		customer.setName("priya");
		System.out.println(customer.getName());
		customer.getPhoneNumbers().forEach(no->no.setType("cell"));
		//customer.setPhoneNumbers(phoneNumbers);
		repo.save(customer);
	}
	@Test
	void deleteRecord() {
		 repo.deleteById(2l);
	}
		

}
