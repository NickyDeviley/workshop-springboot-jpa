# Workshop Spring Boot & JPA/Hibernate - Aplicação Web RESTful desenvolvida durante o curso de Java do prof. Nélio Alves.

# Descrição:

Esta aplicação foi desenvolvida com propósito estritamente acadêmico para consolidar o aprendizado em ecossistema Spring (Spring Boot, JPA, Hibernate) e criação de APIs RESTful. O projeto resolve o desafio de estruturar uma aplicação web completa aplicando boas práticas de arquitetura, separação clara de responsabilidades em camadas e mapeamento objeto-relacional (ORM). A arquitetura é dividida profissionalmente nas camadas:

    Resource (Controllers): Camada de disponibilização dos endpoints REST.

    Service: Camada contendo as regras de negócio da aplicação.

    Repository: Camada de acesso aos dados e integração com o banco.

Além disso, a aplicação implementa CRUDs completos para gerenciar um domínio de e-commerce/pedidos composto por diversas entidades relacionais (User, Order, OrderItem, Product, Category e Payment), utilizando funções Lambda e Streams API para manipulação e transformação de dados.

# Pré-requisitos:

    Linguagem: Java (JDK 11 ou superior).

    IDE: Eclipse com a extensão Spring Tools Suite (STS) (ou IntelliJ IDEA / VS Code com suporte a Spring Boot).

    Gerenciador de Dependências: Maven.

# Instalação/Uso:

    Clone este repositório em sua máquina local:
    Bash

    git clone https://github.com/NickyDeviley/workshop-springboot-jpa

    Abra o Eclipse (Spring Tool Suite).

    Importe o projeto via File > Import > Maven > Existing Maven Projects.

    Aguarde o download de todas as dependências do Maven.

    Execute a classe principal da aplicação (*Application.java) clicando com o botão direito e selecionando Run As > Spring Boot App.

    O servidor iniciará na porta 8080.

    Acesso ao Banco de Dados (H2):

        Acesse http://localhost:8080/h2-console no seu navegador para visualizar o banco em memória e consultar os dados persistidos.

# Tecnologias:

    Java (Lógica principal, Lambdas e Streams)

    Spring Boot (Framework para desenvolvimento da API REST)

    Spring Data JPA / Hibernate (Mapeamento Objeto-Relacional e persistência)

    H2 Database (Banco de dados em memória para testes e desenvolvimento)

    Maven (Gerenciamento de dependências e build)

    Eclipse / Spring Tool Suite (STS) (IDE de desenvolvimento)

# Licença:

MIT License
