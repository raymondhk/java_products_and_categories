package com.project.ProductsAndCategories.repositories;

import com.project.ProductsAndCategories.models.Category;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository 												
public interface CategoryRepository extends CrudRepository<Category,Long>{
	// Query methods go here.
	
	// Example:
	// public YourModelHere findByName(String name);
}
