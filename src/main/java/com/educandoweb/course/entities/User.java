package com.educandoweb.course.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity										// Diz ao Spring que essa classe representa uma entidade
@Table(name = "tb_user")					// Determina o nome da tabela dentro do banco de dados
public class User implements Serializable {
	/**
		No java existe uma interface chamada Serializable que
		precisa ser implementada pela classe para transformar
		os dados em cadeias de bytes.
		
		Isso serve para permitir que os objetos trafegue na rede,
		para que seja gravado em arquivos, etc.
		
		As anotações dizem ao Spring que os objetos dessa classe
		são entidades e define o nome que a tabela de usuários
		deve ter no banco de dados.
		
		É importante ressaltar que nós chamamos as interfaces
		do JPA e não a implementação (hibernate) pois é melhor
		dependendo da interface do que da implementação, assim
		caso o projeto mude para outra implementação do JPA ele
		continuará funcionando.
	*/
	
	
	private static final long serialVersionUID = 1L;	// Serial para transformar as informações em requisições HTTP
	
	@Id					// Essa anotação diz ao Spring que a variável "id" é o identificador da entidade dentro do banco de dados.
	@GeneratedValue(strategy = GenerationType.IDENTITY)	// Essa anotação serve para gerar o ID do objeto de forma auto-incremental.
	private Long id;
	private String name;
	private String email;
	private String phone;
	private String password;
	
	@JsonIgnore										// Serve para evitar loop infinito de informações
	@OneToMany(mappedBy = "client")					// Especifica o tipo de relacionamento 1 para muitos, um cliente tem muitos pedidos e um pedido só tem um cliente
	private List<Order> orders = new ArrayList<>();	// Um usuário contém vários pedidos
	
	// Ao utilizar o framework spring é obrigatório colocar
	// o construtor padrão
	public User() {}

	// Contrutor com os fields
	public User(Long id, String name, String email, String phone, String password) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
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
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}

	
	// GETTERS & SETTERS
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// Get da lista de pedidos
	public List<Order> getOrders() {
		return orders;
	}
	
	
}
