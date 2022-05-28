package com.genpact.shoppingcart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genpact.shoppingcart.model.User;
import com.genpact.shoppingcart.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	// service to fetch all the authorized users
	public List<User> getAllAuthorizedUser(){
		return this.userRepository.findAll();
	}
}
