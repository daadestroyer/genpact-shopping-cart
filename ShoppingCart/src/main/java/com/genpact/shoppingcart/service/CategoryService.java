package com.genpact.shoppingcart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genpact.shoppingcart.model.Category;
import com.genpact.shoppingcart.repository.CategoryRepository;

import java.util.List;

// Here all the services we are providing
@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	// service to add category
	public void addCategory(Category category) {
		this.categoryRepository.save(category);
	}

	// service to fetch all the category
	public List<Category> getAllCategory() {
		return this.categoryRepository.findAll();
	}
}
