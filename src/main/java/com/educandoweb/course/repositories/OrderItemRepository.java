package com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.course.entities.OrderItem;

// @ Repository - Poderiamos colocar essa anotação para o Spring entender que essa classe é da camada de repository.
// Porém como essa classe é filha da JpaRepository o Spring já identifica ela como Repository, então essa
// anotação é opcional
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
	/**
		Esta é a camada de data Repository, que se comunica com o banco de dados para recuperar
		informações.
		
		Nós não precisamos criar uma implementação dessa interface, pois o SpringJPA 
		já possui uma implementação para ela.
	*/
	
	
}
