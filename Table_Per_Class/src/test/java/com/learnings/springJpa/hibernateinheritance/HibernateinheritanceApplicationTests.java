package com.learnings.springJpa.hibernateinheritance;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.learnings.springJpa.hibernateinheritance.entity.Check;
import com.learnings.springJpa.hibernateinheritance.entity.CreditCard;
import com.learnings.springJpa.hibernateinheritance.repo.PaymentRepository;

@SpringBootTest
class HibernateinheritanceApplicationTests {

	@Autowired
	private PaymentRepository repo;
	@Test
	void contextLoads() {
	}
	@Test
	void save() {
		CreditCard card = new CreditCard();
		card.setId(1);
		card.setAmount("1000");
		card.setCreditnumber("123456");
		Check check = new Check();
		check.setId(2);
		check.setAmount("2000");
		check.setChecknumber("56789");
		repo.save(card);
		repo.save(check);
	}
}
