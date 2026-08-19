package com.educandoweb.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.User;
import com.educandoweb.course.entities.enums.OrderStatus;
import com.educandoweb.course.repositories.OrderRepository;
import com.educandoweb.course.repositories.UserRepository;

@Configuration			// Diz ao Spring que essa classe é de configuração
@Profile("test")		// Diz ao Spring que ela só será utilizada quando entrarmos com o perfil de teste
public class TestConfig implements CommandLineRunner {
	/**
		Essa classe não pertence a nenhuma camada específica,
		na realidade ela é uma classe auxiliar para configurar
		a nossa aplicação.
		
		Para que o código da classe seja executado assim que a aplicação
		começar a funcionar, nós implementamos a interface "CommandLineRunner"
		e tudo o que estiver no método run será executado. Nós vamos
		usar isso para criar objetos e armazenar no banco de dados como
		forma de teste.
	*/
	
	// Aqui nós estamos fazendo uma injeção de dependência na classe
	// A anotação "Autowired" cria essa conexão de objetos de forma
	// Automática sem a necessidade de utilizar um construtor.
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public void run(String... args) throws Exception {

		// Criando os usuários que vão ser salvos no banco de dados
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "97777777", "123456");
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);	// Aqui nós criamos um pedido e associamos um usuário à ele
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);
		
		
		/*
			Para armazenar os objetos no banco de dados utilizando JPA e Spring
			nós usamos o UserRepository, como exemplificado abaixo:
			
			O método saveAll serve para salvar dados no banco sem utilizar
			comandos SQL diretamente, ao invés de utilizar JDBC e escrever
			os comandos na mão, basta utilizar esse comando do JPA.
		*/
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
		
	}
	
}
