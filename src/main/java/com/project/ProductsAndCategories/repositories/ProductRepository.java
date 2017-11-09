package com.project.ProductsAndCategories.repositories;

import com.project.ProductsAndCategories.models.Product;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository 												
public interface ProductRepository extends CrudRepository<Product,Long>{
	// Query methods go here.
	List<Product> findAll();
	
	// Example:
	// public YourModelHere findByName(String name);
}
