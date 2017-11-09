package com.project.ProductsAndCategories.controllers;

import java.security.Principal;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.project.ProductsAndCategories.models.Category;
import com.project.ProductsAndCategories.models.Product;
import com.project.ProductsAndCategories.services.ItemsService;

@Controller
public class Categories{
	//Member variables go here
	private final ItemsService item;
	public Categories(ItemsService item){
		this.item = item;
	}
	
	@RequestMapping("/categories/new")
	public String newCategory(@ModelAttribute("category") Category category){
		return "newCategory";
	}
	@PostMapping("/categories/new")
	public String createCategory(@Valid @ModelAttribute("category") Category category,BindingResult res) {
		if(res.hasErrors()) {
			return "newCategory";
		} else {
			Category cat = item.createCategory(category);
			return "redirect:/categories/".concat(Long.toString(cat.getId()));
		}
	}
	@RequestMapping("/categories/{id}")
	public String showCategory(Model model, @PathVariable("id") Long id) {
		Category cat = item.getOneCategory(id);
		model.addAttribute("category", cat);
		model.addAttribute("products", item.availableProducts(cat));
		return "showCategory";
	}
	@PostMapping("/categories/{id}")
	public String addCategory(@RequestParam(value="products") Long product_id, @PathVariable("id") Long id) {
		List<Product> current_products = item.getOneCategory(id).getProducts();
		current_products.add(item.getOneProduct(product_id));
		item.updateCategory(item.getOneCategory(id));
		return "redirect:/categories/"+id;
	}
}
