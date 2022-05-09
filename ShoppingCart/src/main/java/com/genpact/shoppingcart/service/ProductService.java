package com.genpact.shoppingcart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genpact.shoppingcart.model.Product;
import com.genpact.shoppingcart.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	// service to get all products
	public List<Product> getAllProduct() {
		return this.productRepository.findAll();
	}
}
