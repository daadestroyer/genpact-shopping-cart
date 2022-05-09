package com.genpact.shoppingcart.dto;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.genpact.shoppingcart.model.Category;

import lombok.Data;

@Data
public class ProductDTO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private int categoryId;
	private double price;
	private double weight;
	private String description;
	private String image;

}
