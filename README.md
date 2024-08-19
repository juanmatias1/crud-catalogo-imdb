# Java-IMBD

Este projeto é um sistema de catálogo de filmes desenvolvido com Spring Boot. O objetivo é criar uma aplicação que permita gerenciar um catálogo de filmes, incluindo a adição, atualização, remoção e busca de filmes, atores e diretores.

## Funcionalidades

- **CRUD de Filmes**: Adicione, liste, atualize e exclua filmes. Busque filmes por nome e por nome do diretor.
- **CRUD de Atores**: Adicione, liste, atualize e exclua atores. 
- **CRUD de Diretores**: Adicione, liste, atualize e exclua diretores.
- **Associação**: Associe atores e diretores a filmes.

## Tecnologias Utilizadas

- **Spring Boot**: Framework para desenvolvimento de aplicações Java.
- **JPA/Hibernate**: Para persistência e gerenciamento de dados.
- **H2**: Banco de dados em memória para desenvolvimento e testes.
- **Insomnia/Postman**: Para testar as APIs.

## Configuração do Banco de Dados

O projeto utiliza o H2 como banco de dados em memória. O arquivo `application.properties` está configurado para usar o H2 por padrão. Caso deseje configurar um banco de dados diferente, ajuste as propriedades conforme necessário.

O arquivo `application.properties` deve conter:

```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
```
## Construir e Rodar o Projeto

Use o Maven para compilar e rodar a aplicação:

```bash
./mvnw clean install
./mvnw spring-boot:run
```

A aplicação estará disponível em http://localhost:8080.

## Endpoints

### Filmes
 - Criar Filme: POST /filmes

Corpo da Requisição:

```json
{
  "nome": "Nome do Filme",
  "dataLancamento": "YYYY-MM-DD",
  "orcamento": 1000000,
  "descricao": "Descrição do Filme",
  "diretorId": 1,
  "atoresIds": [1, 2]
}
```

- Listar Filmes: GET /filmes

- Buscar Filme por ID: GET /filmes/{id}

- Buscar Filmes por Nome: GET /filmes/buscar?nome={nome}

- Buscar Filmes por Nome do Diretor: GET /filmes/buscar-por-diretor?nomeDiretor={nomeDiretor}

- Atualizar Filme: PUT /filmes/{id}

Corpo da Requisição:

```json
{
  "nome": "Nome Atualizado do Filme",
  "dataLancamento": "YYYY-MM-DD",
  "orcamento": 1500000,
  "descricao": "Descrição Atualizada do Filme",
  "diretorId": 2,
  "atoresIds": [2, 3]
}
```
- Deletar Filme: DELETE /filmes/{id}

### Atores
- Criar Ator: POST /atores

Corpo da Requisição:

```json
{
  "nome": "Nome do Ator"
}
```

- Listar Atores: GET /atores

- Buscar Ator por ID: GET /atores/{id}

- Atualizar Ator: PUT /atores/update/{id}

Corpo da Requisição:

```json
{
  "nome": "Nome Atualizado do Ator"
}
```

- Deletar Ator: DELETE /atores/delete/{id}

### Diretores
- Criar Diretor: POST /diretores

Corpo da Requisição:

```json
{
  "nome": "Nome do Diretor"
}
```

- Listar Diretores: GET /diretores

- Buscar Diretor por ID: GET /diretores/{id}

- Atualizar Diretor: PUT /diretores/update/{id}

Corpo da Requisição:

```json
{
  "nome": "Nome Atualizado do Diretor"
}
```

- Deletar Diretor: DELETE /diretores/delete/{id}

## Testando a Aplicação
Use ferramentas como Insomnia ou Postman para testar os endpoints da API.
