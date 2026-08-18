package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.repositories.OrderRepository;

@Service
public class OrderService {
	/**
		Essa classe é onde ocorre as regras de negócio. Essa classe chama os
		repositóries e retorna para a camada de resource.
		
		Para ser possível a injeção de dependência nós utilizamos alguma das
		seguintes anotações:
		
		@ Component - Diz ao Spring que essa classe é um componente para poder ser injetado
		@ Service - Diz ao Spring que essa classe é um service para ser mais específico e poder ser injetado
	*/
	
	@Autowired
	private OrderRepository repository;
	
	public List<Order> findAll() {
		
		return repository.findAll();
		
	}
	
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}
}
