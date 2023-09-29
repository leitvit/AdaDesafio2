# Desafio Bootcamp Fullstack - Ada e Cielo

Este projeto foi desenvolvido como parte do Bootcamp Fullstack da Ada em parceria com a Cielo.

# Objetivo

O objetivo do desafio é criar um sistema para pré-cadastro de clientes prospects fictícios, incluindo backend e frontend.

## 1. Backend

### 1.1 Desenvolvimento

A primeira etapa é relacionada a criar um sistema backend para pré-cadastro de clientes.
Nos foi solicitado criar uma API Rest com operações de criação, alteração, exclusão e consulta de pré-cadastro de
clientes, o entregável sendo a documentação Swagger dos endpoints.

Criamos nas classes `models.ProspectPessoaFisica` e `models.ProspectPessoaJuridica` a estrutura para armazenarmos
prospects do tipo pessoa física e jurídica, implementando suas respectivas regras de validação e unicidade solicitadas.

Foram também solicitadas regras de consistência nas operações de cadastro, consulta e alteração destes clientes.
As regras foram implementadas nas classes `services.ProspectPessoaFisicaService` e 
`services.ProspectPessoaJuridicaService` e utilizadas pelos seus respectivos controllers.

### 1.2

A documentação swagger dos endpoints criados está disponível em `http://localhost:8080/swagger-ui/index.html`.
Para acessá-la, é necessário subir a aplicação desenvolvida, 

### 1.3 Testes Unitários

Um dos requisitos do desafio era criar testes unitários validando as regras de validação que nos requisitaram.
Implementamos os testes em JUnit. Para executá-los, pode-se utilizar os comandos abaixo:

````cmd
cd backend
gradlew test
````

Após executados, um relatório com os resultados é gerado no caminho
`backend/build/reports/tests/test/index.html`.
