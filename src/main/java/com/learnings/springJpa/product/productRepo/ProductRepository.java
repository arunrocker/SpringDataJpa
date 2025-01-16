package com.learnings.springJpa.product.productRepo;

import org.springframework.data.repository.CrudRepository;

import com.learnings.springJpa.product.entity.Product;
import java.util.List;


public interface ProductRepository extends CrudRepository<Product, Integer>{
	List<Product> findByDesc(String desc);
	List<Product> findByDescAndName(String desc,String name);
	List<Product> findByPriceGreaterThan(Double price);
	List<Product> findByDescContains(String desc);
	List<Product> findByPriceBetween(Double price1,Double price2);
	List<Product> findByNameLike(String name);
	List<Product> findByIdIn(List<Integer> prices);
}
