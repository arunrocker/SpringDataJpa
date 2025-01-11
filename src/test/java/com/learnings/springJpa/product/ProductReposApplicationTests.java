package com.learnings.springJpa.product;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.learnings.springJpa.product.entity.Product;
import com.learnings.springJpa.product.productRepo.ProductRepository;

@SpringBootTest
class ProductReposApplicationTests {

	@Autowired
	ProductRepository repo;
	@Test
	void contextLoads() {
	}
	@Test
	public void insertRow() {
		Product p1 = new Product();
		p1.setId(1);
		p1.setName("Iphone");
		p1.setDesc("Finest Mobile");
		p1.setPrice(100.01);
		repo.save(p1);
	}
	@Test
	public void updateRow() {
		Optional<Product> optional = repo.findById(1);
		Product p1 = optional.get();
		p1.setPrice(200.01);
		repo.save(p1);
	}
	@Test
	public void deleteRow() {
		if(repo.existsById(1)) {
			repo.deleteById(1);
		}
	}
	@Test
	public void count() {
		System.out.println(repo.count());
	}
	

}
