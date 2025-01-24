package com.learnings.springJpa.onetoone;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.learnings.springJpa.onetoone.entities.License;
import com.learnings.springJpa.onetoone.entities.Person;
import com.learnings.springJpa.onetoone.repo.PersonRepo;

@SpringBootTest
class OnetooneApplicationTests {
	@Autowired
	private PersonRepo repo;

	@Test
	void contextLoads() {
	}
	@Test
	void addLicenseToPerson() {
		License license = new License();
		license.setType("Two Wheeler");
		license.setValidFrom(new Date());
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); // Using today's date
		c.add(Calendar.DATE, 5); // Adding 5 days
		license.setValidTo(c.getTime());
		Person person = new Person();
		person.setFirstName("Arun");
		person.setLastName("kumar");
		person.setLicense(license);
		repo.save(person);
	}
	@Test
	@Transactional
	void getLicenseToPerson() {
		Person p = repo.findById(1L).get();
		System.out.println(p);
		System.out.println(p.getLicense());
	}

}
