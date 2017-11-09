package com.project.ProductsAndCategories.controllers;

import java.security.Principal;
import java.util.Date;

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
import com.project.ProductsAndCategories.models.Product;
import com.project.ProductsAndCategories.services.ItemsService;

@Controller
public class Products{
	//Member variables go here
	private final ItemsService item;
	public Products(ItemsService item){
		this.item = item;
	}
	
	@RequestMapping("/products/new")
	public String newProduct(@ModelAttribute("product") Product product) {
		return "newProduct";
	}
	@PostMapping("/products/new")
	public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult res) {
		if(res.hasErrors()) {
			return "newProduct";
		} else {
			item.createProduct(product);
			return "redirect:/products/new";
		}
	}
}
