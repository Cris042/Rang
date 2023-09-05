# Rang

## Atores

Os atores são os usuários ou sistemas externos que interagem com o sistema. Identificamos os seguintes atores principais:

1. **Usuários**: 
2. **Administradores**: 
3. **Médicos**:

## Casos de Uso

Aqui estão alguns dos principais casos de uso do sistema:

1. **Autenticação de Usuário**:
   - **Atores**: Usuários
   - **Descrição**: Os usuários podem se autenticar no sistema usando nome de usuário e senha.

2. **Registro de Usuário**:
   - **Atores**: Usuários
   - **Descrição**: Os usuários podem se registrar no sistema fornecendo informações pessoais, como nome, CPF, etc.

3. **Agendamento de Consultas**:
   - **Atores**: Usuários
   - **Descrição**: Os usuários podem agendar consultas com médicos em unidades de saúde específicas.

4. **Gerenciamento de Unidades de Saúde**:
   - **Atores**: Administradores
   - **Descrição**: Os administradores podem adicionar, atualizar e excluir unidades de saúde no sistema.

5. **Gerenciamento de Médicos**:
   - **Atores**: Administradores
   - **Descrição**: Os administradores podem adicionar, atualizar e excluir informações sobre médicos no sistema.


## Requisitos Funcionais

### Autenticação de Usuário

- **RF01**: O sistema deve permitir que os usuários se autentiquem fornecendo nome de usuário e senha.
- **RF02**: O sistema deve gerar um cokie JWT após a autenticação bem-sucedida.

### Registro de Usuário

- **RF03**: O sistema deve permitir que os usuários se registrem fornecendo informações pessoais.
- **RF04**: O sistema deve verificar se o nome de usuário e o CPF não estão em uso antes de permitir o registro.

### Agendamento de Consultas

- **RF05**: Os usuários devem poder agendar consultas com médicos.
- **RF06**: O sistema deve verificar a disponibilidade da consulta antes de agendá-la.

## Requisitos Não Funcionais

- **RNF01**: O sistema deve ser seguro, protegendo as informações dos usuários e a integridade dos dados.
- **RNF02**: O sistema deve ser escalável para lidar com um grande número de usuários e consultas.
- **RNF03**: O sistema deve ser de fácil uso e ter uma interface amigável.
- **RNF04**: O sistema deve ser altamente disponível, minimizando o tempo de inatividade.

## Testes Unitários com Mockito

O sistema utiliza o framework Mockito para realizar testes unitários. O Mockito permite simular comportamentos e verificar interações com objetos de forma fácil e eficaz.

## Banco de Dados MySQL com Flyway

O sistema utiliza o banco de dados MySQL para armazenar dados. O Flyway é utilizado para gerenciar migrações de banco de dados, garantindo que o esquema do banco de dados seja mantido e atualizado conforme as alterações no código.

Este documento fornece uma visão geral dos atores, casos de uso, requisitos funcionais e não funcionais, testes unitários e informações sobre o banco de dados do sistema, incluindo a adição do ator "Médico". Essas informações são essenciais para o desenvolvimento, teste e manutenção do sistema.
