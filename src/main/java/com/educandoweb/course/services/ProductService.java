package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Product;
import com.educandoweb.course.repositories.ProductRepository;

@Service
public class ProductService {
	/**
		Essa classe é onde ocorre as regras de negócio. Essa classe chama os
		repositóries e retorna para a camada de resource.
		
		Para ser possível a injeção de dependência nós utilizamos alguma das
		seguintes anotações:
		
		@ Component - Diz ao Spring que essa classe é um componente para poder ser injetado
		@ Service - Diz ao Spring que essa classe é um service para ser mais específico e poder ser injetado
	*/
	
	@Autowired
	private ProductRepository repository;
	
	public List<Product> findAll() {
		
		return repository.findAll();
		
	}
	
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get();
	}
}
