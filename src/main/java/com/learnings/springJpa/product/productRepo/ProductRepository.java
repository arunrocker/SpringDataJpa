package com.learnings.springJpa.product.productRepo;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.learnings.springJpa.product.entity.Product;
import java.util.List;


public interface ProductRepository extends CrudRepository<Product, Integer>,PagingAndSortingRepository<Product, Integer>{
	List<Product> findByDesc(String desc);
	List<Product> findByDescAndName(String desc,String name);
	List<Product> findByPriceGreaterThan(Double price);
	List<Product> findByDescContains(String desc);
	List<Product> findByPriceBetween(Double price1,Double price2);
	List<Product> findByNameLike(String name);
	List<Product> findByIdIn(List<Integer> prices);
	List<Product> findByIdIn(List<Integer> prices,Pageable pageable);
}
