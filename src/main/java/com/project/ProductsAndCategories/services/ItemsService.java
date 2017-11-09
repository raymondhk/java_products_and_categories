package com.project.ProductsAndCategories.services;

import java.util.ArrayList;
import java.util.List;

// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.project.ProductsAndCategories.models.Category;
import com.project.ProductsAndCategories.models.Product;
import com.project.ProductsAndCategories.repositories.CategoryRepository;
import com.project.ProductsAndCategories.repositories.ProductRepository;

@Service
public class ItemsService {
	// Member variables / service initializations go here
	private CategoryRepository categoryRepo;
	private ProductRepository productRepo;	
	public ItemsService(CategoryRepository categoryRepo, ProductRepository productRepo){
		this.categoryRepo = categoryRepo;
		this.productRepo = productRepo;
	}
	public Product createProduct(Product product) {
		return productRepo.save(product);
	}
	public Product updateProduct(Product product) {
		return productRepo.save(product);
	}
	public Product getOneProduct(Long id) {
		return productRepo.findOne(id);
	}
	public Category createCategory(Category category) {
		return categoryRepo.save(category);
	}
	public Category updateCategory(Category category) {
		return categoryRepo.save(category);
	}
	public Category getOneCategory(Long id) {
		return categoryRepo.findOne(id);
	}
	
	public List<Product> allProducts(Long id){
		return productRepo.findAll();
	}

	public List<Product> availableProducts(Category category) {
		// As of right now, we do not know how to query single columns 
		// using the spring-data-jpa. I will create a list of name from the 
		// products and execute a not in query with the list in the CrudRepository
		List<String> names = new ArrayList<String>();
		List<Product> currentProds = category.getProducts();
		
		if(currentProds.isEmpty()) {
			// add empty string if there are not categories. Since an empty array does not have
			// a list of strings, we do not get any categories back;
			names.add("");	
		} else {
			for(Product p : currentProds) {
				names.add(p.getName());
			}	
		}
			
		List<Product> prods = productRepo.findByNameNotIn(names);
		return prods;
	}
	
	// Crud methods to act on services go here.
}
