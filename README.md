# 📚 ForumHub API

API REST desenvolvida em Java com Spring Boot para gerenciamento de tópicos de um fórum.
O projeto permite criar, visualizar, atualizar e remover tópicos, além de implementar autenticação segura utilizando JWT e Spring Security.

Este projeto foi desenvolvido como parte de um desafio backend, com foco em boas práticas de desenvolvimento, arquitetura organizada e segurança de API.

## 🚀 Tecnologias utilizadas

- Java 17

- Spring Boot

- Spring Security

- JWT (JSON Web Token)

- Spring Data JPA

- Hibernate

- Maven

- PostgreSQL

- IntelliJ IDEA

## 📌 Descrição das camadas

- controller → endpoints da API

- domain → entidades e DTOs

- repository → acesso ao banco de dados

- service → regras de negócio

- security → autenticação e configuração do Spring Security

## 🔐 Autenticação

A API utiliza JWT (JSON Web Token) para autenticação.

Fluxo:

1) Usuário realiza login

2) API gera um token JWT

3) O token deve ser enviado no header das requisições protegidas

## 📌 Endpoints da API

### POST /login

Realiza a autenticação do usuário e retorna um token JWT, que deve ser utilizado para acessar os endpoints protegidos da API.

### POST /topicos

Cria um novo tópico no fórum. Caso já exista um tópico com o mesmo título e mensagem, a requisição será rejeitada para evitar duplicidade.

### GET /topicos/{id}

Retorna os dados de um tópico específico.

### PUT /topicos/{id}

Atualiza as informações de um tópico existente.
É possível alterar o título e/ou a mensagem do tópico.

### DELETE /topicos/{id}

Remove um tópico do sistema.
