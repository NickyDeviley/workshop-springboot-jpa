package com.educandoweb.course.resources.exception;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.educandoweb.course.services.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {
	/**
		Essa classe é onde iremos tratar os erros que criamos
		
		Essa anotação "ControllerAdvice" serve para interceptar as exceções que ocorrerem para
		que essa classe possa tratar essa possível exceção.
	*/
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
		/*
			A anotação "ExceptionHandler" diz ao Spring que esse método trata esse tipo de exception, então
			qualquer exception desse tipo será enviada para cá
		*/
		
		String error = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;	// Esse é o número que a página recebe, nesse caso 404
		
		/*
		  	Aqui nós instanciamos um erro:
		  	
		  	O instant que ocorre o erro é enviado;
		  	O Status (número) precisa ser transformado em inteiro;
		  	o error é a mensagem criada acima;
		  	Nós pegamos a mensagem da excessão personalizada que criamos;
		  	O caminho que enviamos usamos o URI do Request recebido como parâmetro
		*/
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		
		/*
			Retornamos uma ResponseEntity que é uma entidade fácil de tratar via HTTP
			enviamos o Status, o número de resposta da ação e o "body" o que aparece na página
			da web é o erro que criamos acima.
		*/
		return ResponseEntity.status(status).body(err);	 
		
	}
}
