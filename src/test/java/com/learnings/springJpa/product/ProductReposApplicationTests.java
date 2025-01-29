package com.learnings.springJpa.product;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.learnings.springJpa.product.entity.Product;
import com.learnings.springJpa.product.productRepo.ProductRepository;

import jakarta.persistence.EntityManager;

import org.springframework.data.domain.Sort.Order;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class ProductReposApplicationTests {

	@Autowired
	ProductRepository repo;
	@Autowired
	EntityManager entityManger;
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
	@Test
	public void findAllPaging() {
		System.out.println("Paging");
		Pageable pageable = PageRequest.of(1, 1);
		Page<Product> results = repo.findAll(pageable);
		results.forEach(product->System.out.println(product.getName()));
	}
	@Test
	public void sortBySingleProperty() {
		System.out.println("sortBySingleProperty");
		Iterable<Product> results = repo.findAll(Sort.by(Direction.DESC,"name"));
		results.forEach(product->System.out.println(product.getName()));
	}
	@Test
	public void sortByMutlipleProperty() {
		System.out.println("sortByMutlipleProperty");
		Iterable<Product> results = repo.findAll(Sort.by(Direction.DESC,"name","price"));
		results.forEach(product->System.out.println(product.getName()));
	}
	@Test
	public void multipleSortByMutlipleProperty() {
		System.out.println("multipleSortByMutlipleProperty");
		Iterable<Product> results = repo.findAll(Sort.by(Order.desc("name"),Order.by("price")));
		results.forEach(product->System.out.println(product.getName()));
	}
	@Test
	public void pagingAndSorting() {
		System.out.println("pagingAndSorting");
		Pageable pageable = PageRequest.of(1, 1,Direction.DESC,"name");
		Page<Product> results = repo.findAll(pageable);
		results.forEach(product->System.out.println(product.getName()));
	}
	@Test
	public void findByIdInWithPageable() {
		Pageable pageable = PageRequest.of(1, 1,Direction.DESC,"name");
		List<Product> products = repo.findByIdIn(Arrays.asList(1,2,3),pageable);
		products.forEach(product->System.out.println(product.getName()));
	}
	
	@Test
	@Transactional
	public void firstLvlCache() {
		Session session = entityManger.unwrap(Session.class);
		Product product = repo.findById(1).get();
		repo.findById(1).get();
		session.evict(product);
		repo.findById(1).get();
	}
	

}
