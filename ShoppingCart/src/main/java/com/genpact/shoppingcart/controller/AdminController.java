package com.genpact.shoppingcart.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.genpact.shoppingcart.dto.ProductDTO;
import com.genpact.shoppingcart.model.Category;
import com.genpact.shoppingcart.service.CategoryService;
import com.genpact.shoppingcart.service.ProductService;

@Controller
@RequestMapping("shopping-cart/admin/")
public class AdminController {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ProductService productService;
	
	// http://localhost:8080/shopping-cart/admin/admin-dashboard
	@GetMapping("/admin-dashboard")
	public String adminDashboard() {
		return "adminDashboard";
	}

	// handler to display category
	// http://localhost:8080/shopping-cart/admin/admin-dashboard/categories
	@GetMapping("/admin-dashboard/categories")
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

	// handler to delete category by id
	@GetMapping("/admin-dashboard/categories/delete/{categoryId}")
	public String deleteCategories(@PathVariable int categoryId) {
		this.categoryService.deleteCategoryById(categoryId);
		return "redirect:/shopping-cart/admin/admin-dashboard/all-categories";
	}

	// handler to update category by id
	@GetMapping("/admin-dashboard/categories/update/{categoryId}")
	public String updateCategories(@PathVariable int categoryId, Model model) {
		Optional<Category> categoryById = this.categoryService.getCategoryById(categoryId);
		if (categoryById.isPresent()) {
			model.addAttribute("category", categoryById.get());
			return "addCategories";
		} else {
			return "404";
		}

	}

	// PRODUCT SECTION

	// handler to display product
	// http://localhost:8080/shopping-cart/admin/admin-dashboard/products
	@GetMapping("/admin-dashboard/products")
	public String getProductsPage(Model model) {
		model.addAttribute("products",productService.getAllProduct());
		return "displayProduct";
	}

	// handler to open the add-product form
	// http://localhost:8080/shopping-cart/admin/admin-dashboard/products/add-product
	@GetMapping("/admin-dashboard/products/add-product")
	public String getProductsAdd(Model model) {
		model.addAttribute("productDTOP",new ProductDTO());
		model.addAttribute("categories",categoryService.getAllCategory());
	 	return "addProduct";
	}

}