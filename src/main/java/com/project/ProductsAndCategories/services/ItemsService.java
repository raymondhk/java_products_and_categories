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
	public Category createCategory(Category category) {
		return categoryRepo.save(category);
	}
	public Category getOneCategory(Long id) {
		return categoryRepo.findOne(id);
	}
	public List<Product> allProducts(Long id){
		return productRepo.findAll();
	}
	// Crud methods to act on services go here.
}
