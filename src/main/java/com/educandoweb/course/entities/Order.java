package com.educandoweb.course.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "tb_order")
public class Order implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	@Id					// Essa anotação diz ao Spring que a variável "id" é o identificador da entidade dentro do banco de dados.
	@GeneratedValue(strategy = GenerationType.IDENTITY)	// Essa anotação serve para gerar o ID do objeto de forma auto-incremental.
	private Long id;
	private Instant moment;
	/*
	  Antes da versão 8 do java usava-se o Date, mas
	  o Instant é mais preciso.
	*/
	
	@ManyToOne							// Essa anotação do JPA diz que um cliente pode ter vários pedidos, mas que o pedido só pode ter 1 cliente
	@JoinColumn(name = "client_id")		// Essa anotação do JPA diz serve para acessar os pedidos e unir a tebela clients pois cada pedido depende de um cliente 
	private User client;				// Chave estrangeira
	
	// Construtores
	public Order() {}
	public Order(Long id, Instant moment, User client) {
		
		this.id = id;
		this.moment = moment;
		this.client = client;
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(id, other.id);
	}
	
	
	// Getters & Setters
	public Long getid() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}
}
