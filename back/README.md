# Documentação da API

Esta documentação fornece uma visão geral dos endpoints e funcionalidades da API REST para um sistema de agendamento de consultas. O codigo foi pensado no padrão de projeto SOLID.

## Autorização

Este controlador requer autenticação para algumas operações. Os cokies JWT são usados para autenticação e autorização. 

## Autenticar Usuário

- **URL**: `/api/auth/signin`
- **Método**: `POST`
- **Descrição**: Autentica um usuário e gera um cokie JWT.
- **Parâmetros**:
  {
  
	  "password" : "123456a",
	  "username" : "root"
  }
- **Resposta**:
  - Sucesso: 200 OK com o cokie JWT.
  - Falha: 400 Bad Request com uma mensagem de erro se as credenciais forem inválidas.

## Registrar Usuário

- **URL**: `/api/auth/signup`
- **Método**: `POST`
- **Descrição**: Registra um novo usuário no sistema.
- **Parâmetros**:
  {
	
	  "password" : "",
	  "username" : "",
	  "cpf": "",
	  "role" : ""
  }   
- **Resposta**:
  - Sucesso: 200 OK com uma mensagem de confirmação.
  - Falha: 400 Bad Request com uma mensagem de erro se o nome de usuário (username) ou CPF já estiverem em uso.

## Encerrar Sessão

- **URL**: `/api/auth/signout`
- **Método**: `POST`
- **Descrição**: Encerra a sessão do usuário e limpa o token JWT.
- **Resposta**:
  - Sucesso: 200 OK com uma mensagem de confirmação.

## Controlador de Unidade de Saúde

### Adicionar Unidade de Saúde

- **URL**: `/api/unit/add`
- **Método**: `POST`
- **Descrição**: Adiciona uma nova unidade de saúde ao sistema.
- **Parâmetros**:
  {
  
	  "name" : "teste",
	  "city" : "teste",
	  "street" : "rua teste",
	  "neighborhood" : "centro"
  } 
- **Autorização**: Requer que o usuário tenha a função 'ADM'.
- **Resposta**:
  - Sucesso: 200 OK com uma mensagem de sucesso.
  - Falha: 400 Bad Request com uma mensagem de erro se o nome já estiver em uso.

### Listar Unidades de Saúde

- **URL**: `/api/unit/list`
- **Método**: `GET`
- **Descrição**: Recupera uma lista de unidades de saúde.
- **Resposta**:
  - Sucesso: 200 OK com uma lista de unidades de saúde.
  
### Listar Unidades de Saúde por Cidade

- **URL**: `/api/unit/list/{city}`
- **Método**: `GET`
- **Descrição**: Recupera uma lista de unidades de saúde em uma cidade específica com suporte à paginação.
- **Parâmetros**:
  - `city`  - A cidade a ser filtrada.
- **Resposta**:
  - Sucesso: 200 OK com uma lista de unidades de saúde na cidade especificada.

## Controlador de Médicos

### Adicionar Médico

- **URL**: `/api/doctor/add`
- **Método**: `POST`
- **Descrição**: Adiciona um novo médico ao sistema.
- **Parâmetros**:
  {
  
    	"crm" : "",
    	"specialty" : "",
    	"username" : "",
    	"password" : "",
    	"healthUnit" : 1
  } 
- **Autorização**: Requer que o usuário tenha a função 'ADM'.
- **Resposta**:
  - Sucesso: 200 OK com uma mensagem de sucesso.
  - Falha: 400 Bad Request com uma mensagem de erro se o CRM (Certificado de Enfermeira Registrada) já estiver em uso.

### Listar Médicos

- **URL**: `/api/doctor/list`
- **Método**: `GET`
- **Descrição**: Recupera uma lista de médicos.
- **Resposta**:
  - Sucesso: 200 OK com uma lista de médicos.

### Listar Médico por ID

- **URL**: `/api/doctor/list/{id}`
- **Método**: `GET`
- **Descrição**: Recupera um médico pelo seu ID único.
- **Parâmetros**:
  - `id`  - O id do medico a ser filtrada.
- **Resposta**:
  - Sucesso: 200 OK com os detalhes do médico.
  - Falha: 400 Bad Request com uma mensagem de erro se o médico não for encontrado.

## Controlador de Consultas

### Adicionar Consulta

- **URL**: `/api/consult/add`
- **Método**: `POST`
- **Descrição**: Adiciona um novo agendamento de consulta ao sistema.
- **Parâmetros**:
  {
  
     	"state" : "",
         "crm" : "",
     	"cpf" : "",
     	"date" : "",
     	"time" : "",
  }
- **Resposta**:
  - Sucesso: 200 OK com uma mensagem de sucesso.
  - Falha: 400 Bad Request com uma mensagem de erro se a data já estiver agendada para o médico e paciente especificados.

### Listar Consultas

- **URL**: `/api/consult/list`
- **Método**: `GET`
- **Descrição**: Recupera uma lista de todas as consultas.
- **Resposta**:
  - Sucesso: 200 OK com a listagem das consultas.
  - Falha: 400 Bad Request com uma mensagem de erro.

### Listar Consultas Por Doutor

- **URL**: `/api/consult/list/doc/{crm}`
- **Método**: `GET`
- **Descrição**: Recupera uma lista de todas as consultas com base no doutor.
- **Parâmetros**:
  - `crm` - O crm do medico a ser filtrada.
- **Resposta**:
  - Sucesso: 200 OK com a listagem das consultas.
  - Falha: 400 Bad Request com uma mensagem de erro.

### Listar Consultas Por Paciente

- **URL**: `/api/consult/list/{cpf}`
- **Método**: `GET`
- **Descrição**: Recupera uma lista de todas as consultas com base no paciente.
- **Parâmetros**:
  - `cpf`  - O cpf do medico a ser filtrada.
- **Resposta**:
  - Sucesso: 200 OK com a listagem das consultas.
  - Falha: 400 Bad Request com uma mensagem de erro.


## Depedencias globais necessarias 💻

- [x] Maven

## Inicializar projeto

1. Run `mvn clean install `.<br />
2. Run `mvn spring-boot:run`.<br />

## Documentação da Api 
  -> [ http://localhost:8080/swagger-ui.html ]
  -> O arquivo que lista todas as requisições e o : requests.json
