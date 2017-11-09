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
import com.project.ProductsAndCategories.models.Category;
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
	public String showCategory(Model model, @PathVariable("id") Long id, @ModelAttribute("category") Category category) {
		model.addAttribute("category", item.getOneCategory(id));
		model.addAttribute("products", item.allProducts(id));
		return "showCategory";
	}
	@PostMapping("/categories/{id}")
	public String addCategory(@Valid @ModelAttribute("category") Category category, BindingResult res) {
		if(res.hasErrors()){
			return "showCategory";
		} else {
			item.createCategory(category);
			return "/categories/"+category.getId();
		}
	}
}
