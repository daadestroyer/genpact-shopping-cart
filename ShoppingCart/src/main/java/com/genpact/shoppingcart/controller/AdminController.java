package com.genpact.shoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.genpact.shoppingcart.model.Category;
import com.genpact.shoppingcart.service.CategoryService;

@Controller()
@RequestMapping("shopping-cart/admin/")
public class AdminController {

	@Autowired
	private CategoryService categoryService;

	// http://localhost:8080/shopping-cart/admin/admin-dashboard
	@GetMapping("/admin-dashboard")
	public String adminDashboard() {
		return "adminDashboard";
	}

	// handler to display category
	// http://localhost:8080/shopping-cart/admin/admin-dashboard/all-categories
	@GetMapping("/admin-dashboard/all-categories")
	public String getCategoriesPage(Model model) {
		model.addAttribute("categories", categoryService.getAllCategory());
		return "displayCategories";
	}

	// handler to open the add-category form
	// http://localhost:8080/shopping-cart/admin/admin-dashboard/categories/add-category
	@GetMapping("/admin-dashboard/categories/add-category")
	public String getCategoriesAdd(Model model) {
		model.addAttribute("category", new Category());
		return "addCategories";
	}

	// handler to add the category in DB
	@PostMapping("/admin-dashboard/categories/add-category")
	public String postCategoriesAdd(@ModelAttribute Category category) {
		System.out.println(category);
		this.categoryService.addCategory(category);
		return "redirect:/shopping-cart/admin/admin-dashboard/all-categories";
	}

	// handler to display product
	// http://localhost:8080/shopping-cart/admin/admin-dashboard/products
	@GetMapping("/admin-dashboard/products")
	public String getProductsPage(Model model) {
		// model.addAttribute("categories",categoryService.getAllCategory());
		return "displayProduct";
	}

}