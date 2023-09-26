# Desafio Bootcamp Fullstack - Ada e Cielo

Este projeto foi desenvolvido como parte do Bootcamp Fullstack da Ada em parceria com a Cielo.

# Objetivo

O desafio foi separado em três etapas. 

## Etapa 1

A primeira etapa é relacionada ao pré-cadastro de clientes. Nos foi solicitado criar uma API Rest com operações de
criação, alteração, exclusão e consulta de pré-cadastro de clientes, o entregável sendo a documentação Swagger dos
endpoints.

Criamos nas classes `models.ProspectPessoaFisica` e `models.ProspectPessoaJuridica` a estrutura para armazenarmos
prospects do tipo pessoa física e jurídica, implementando suas respectivas regras de validação solicitadas.

Foram também solicitadas regras de consistência nas operações de cadastro, consulta e alteração destes clientes.
As regras foram implementadas na classe `services.ProspectService`. 

Os testes unitários estão localizados em 

