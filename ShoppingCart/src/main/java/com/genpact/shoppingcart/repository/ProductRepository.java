package com.genpact.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.genpact.shoppingcart.model.Category;
import com.genpact.shoppingcart.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
