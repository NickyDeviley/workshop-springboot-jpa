package com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	/**
		Esta é a camada de data Repository, que se comunica com o banco de dados para recuperar
		informações.
		
		Nós não precisamos criar uma implementação dessa interface, pois o SpringJPA 
		já possui uma implementação para ela.
	*/
	
	
}
