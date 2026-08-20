package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

@Service
public class UserService {
	/**
		Essa classe é onde ocorre as regras de negócio. Essa classe chama os
		repositóries e retorna para a camada de resource.
		
		Para ser possível a injeção de dependência nós utilizamos alguma das
		seguintes anotações:
		
		@ Component - Diz ao Spring que essa classe é um componente para poder ser injetado
		@ Service - Diz ao Spring que essa classe é um service para ser mais específico e poder ser injetado
	*/
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll() {
		
		return repository.findAll();
		
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
	
	public User insert(User obj) {
		
		return repository.save(obj);
		
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
