package com.mikseros.springjwtauth.product.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductApi {

	@Autowired
	ProductRepository repo;
	
	@GetMapping
	public List<Product> list() {
		return repo.findAll();
	}
}
