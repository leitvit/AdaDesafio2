# Desafio Bootcamp Fullstack - Ada e Cielo

Este projeto foi desenvolvido como parte do Bootcamp Fullstack da Ada em parceria com a Cielo.

# Requisitos

Para compilar a aplicação, é necessário:
* [JDK 17](https://www.oracle.com/java/technologies/downloads/#java17)

# Objetivo

O objetivo do desafio é criar um sistema para pré-cadastro de clientes prospects fictícios dos tipos pessoa física e
pessoa jurídica.

A primeira etapa é relacionada a criar um sistema backend para pré-cadastro de clientes.
Nos foi solicitado criar uma API Rest com operações de criação, alteração, exclusão e consulta de pré-cadastro de
clientes, o entregável sendo a documentação Swagger dos endpoints.

O projeto foi inicializado utilizando o SpringBoot Initializr. A base de dados utilizada é H2 em memória,
sem persistência de dados. Criamos nas classes `models.ProspectPessoaFisica` e
`models.ProspectPessoaJuridica` a estrutura para armazenarmos prospects do tipo pessoa física e jurídica,
implementando suas respectivas regras de validação e unicidade solicitadas.



Foram também solicitadas regras de consistência nas operações de cadastro, consulta e alteração destes clientes.
As regras foram implementadas nas classes `services.ProspectPessoaFisicaService` e 
`services.ProspectPessoaJuridicaService` e utilizadas pelos seus respectivos controllers.

# Executando a aplicação

Para executar a aplicação, utilize os seguintes comandos:

````cmd
cd backend
gradlew bootRun
````

# Documentação Swagger

A documentação swagger dos endpoints criados está disponível em http://localhost:8080/swagger-ui/index.html.


# Testes Unitários

Um dos requisitos do desafio era criar testes unitários validando as regras de validação que nos requisitaram.
Implementamos os testes em JUnit. Para executá-los, pode-se utilizar os comandos abaixo:

````cmd
cd backend
gradlew test
````

Após executados, um relatório com os resultados é gerado no caminho `backend/build/reports/tests/test/index.html`.

