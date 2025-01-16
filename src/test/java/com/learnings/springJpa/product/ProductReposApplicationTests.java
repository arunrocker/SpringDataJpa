package com.learnings.springJpa.product;

import java.util.Arrays;
import java.util.List;
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
	@Test
	public void findByDesc() {
		List<Product> products = repo.findByDesc("flagship");
		products.forEach(product->System.out.println(product.getName()));
	}
	@Test
	public void findByDescAndName() {
		List<Product> products = repo.findByDescAndName("flagship","vivo");
		products.forEach(product->System.out.println(product.getName()));
	}
	@Test
	public void findByPriceGreaterThan() {
		List<Product> products = repo.findByPriceGreaterThan(50d);
		products.forEach(product->System.out.println(product.getName()));
	}
	@Test
	public void findByDescContains() {
		List<Product> products = repo.findByDescContains("phone");
		products.forEach(product->System.out.println(product.getName()));
	}
	@Test
	public void findByPriceBetween() {
		List<Product> products = repo.findByPriceBetween(50d,100d);
		products.forEach(product->System.out.println(product.getName()));
	}
	@Test
	public void findByNameLike() {
		List<Product> products = repo.findByNameLike("%mobile%");
		products.forEach(product->System.out.println(product.getName()));
	}
	@Test
	public void findByIdIn() {
		List<Product> products = repo.findByIdIn(Arrays.asList(1,2,3));
		products.forEach(product->System.out.println(product.getName()));
	}
	

}
