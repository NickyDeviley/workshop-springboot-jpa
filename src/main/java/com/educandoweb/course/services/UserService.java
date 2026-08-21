package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import com.educandoweb.course.services.exceptions.DatabaseException;
import com.educandoweb.course.services.exceptions.ResourceNotFoundException;

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
		
		/*
		  	Antes nós usávamos o método GET que stopava a aplicação caso o objeto não fosse encontrado
		  	agora esse novo método "orElseThrow" tenta pegar o objeto, porém se ele não encontra ele
		  	ativa a exceção personalizada. Nesse caso nós utilizamos uma expressão lambda para instanciar
		  	a classe de forma diminuta e enviar um parâmetro para seu método.
		*/
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));	
	}
	
	public User insert(User obj) {
		
		return repository.save(obj);
		
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}
		catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
		
	}
	
	public User update(Long id, User obj) {
		/*
			Estou pegando um objeto monitorado, ou seja, o método "getReferenceById"
			retorna um objeto do banco de dados que é monitorado pelo JPA, assim podemos
			alterá-lo a vontade e só depois retorná-lo para o banco de dados.
		*/
		User entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
		
	}
	
	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
	
}