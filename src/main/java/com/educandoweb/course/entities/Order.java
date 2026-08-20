package com.educandoweb.course.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.educandoweb.course.entities.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "tb_order")
public class Order implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	@Id					// Essa anotação diz ao Spring que a variável "id" é o identificador da entidade dentro do banco de dados.
	@GeneratedValue(strategy = GenerationType.IDENTITY)	// Essa anotação serve para gerar o ID do objeto de forma auto-incremental.
	private Long id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant moment;				//  Antes da versão 8 do java usava-se o Date, mas o Instant é mais preciso.
	
	private Integer orderStatus;
	
	@ManyToOne							// Essa anotação do JPA diz que um cliente pode ter vários pedidos, mas que o pedido só pode ter 1 cliente
	@JoinColumn(name = "client_id")		// Essa anotação do JPA diz serve para acessar os pedidos e unir a tebela clients pois cada pedido depende de um cliente 
	private User client;				// Chave estrangeira
	
	
	@OneToMany(mappedBy = "id.order")
	private Set<OrderItem> items = new HashSet<>();
	
	// Construtores
	public Order() {}
	public Order(Long id, Instant moment, OrderStatus orderStatus, User client) {
		
		this.id = id;
		this.moment = moment;
		setOrderStatus(orderStatus);
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
	public Long getId() {
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
	
	public OrderStatus getOrderStatus() {
		return OrderStatus.valueOf(orderStatus);
	}
	public void setOrderStatus(OrderStatus orderStatus) {
		if (orderStatus != null) {
			this.orderStatus = orderStatus.getCode();
		}
	}
	
	public User getClient() {
		return client;
	}
	public void setClient(User client) {
		this.client = client;
	}
	
	public Set<OrderItem> getItems() {
		return items;
	}
	public void setItems(Set<OrderItem> items) {
		this.items = items;
	}	

	
	
}
