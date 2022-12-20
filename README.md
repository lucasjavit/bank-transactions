
# Rotina de transações

- Modules: 
    - Account
    - Operation
    - Transaction
    


## Appendix

- Java
- Spring Boot
- Maven
- Database H2
- Hibernate JPA
- OpenApi
- Swagger


## Installation

 #### Manual
 - Clone o projeto para sua máquina
```bash
git clone git@github.com:lucasjavit/bank-transactions.git
```
- Acesse a pasta do projeto
```bash
cd bank-transactions
```
- Compilar o projeto
```bash
mvn clean install
```
- Execute o projeto
```bash
mvn spring-boot:run
```

#### Docker
- Inicialize o docker

```bash
git clone git@github.com:lucasjavit/bank-transactions.git

```

- Acesse a pasta do projeto
```bash
cd bank-transactions
```

- Execute o projeto
```bash
docker run -p 8080:8080 bank-transactions:0.0.1-SNAPSHOT 
```



    
## Documentação API


### Account
#### POST


```bash
curl --location --request POST 'http://localhost:8080/accounts' \
--header 'Content-Type: application/json' \
--data-raw '{
    "document_number": "1231546"
}'
```

#### GET
- Execute o projeto
```bash
curl --location --request GET 'http://localhost:8080/accounts/1' \
--header 'Content-Type: application/json' \
--data-raw '{
    "document_number": "12345678900"
}'
```

### TRANSACTION
#### POST

- Execute o projeto
```bash
curl --location --request POST 'http://localhost:8080/transactions/' \
--header 'Content-Type: application/json' \
--data-raw '{
    "account_id": 1,
    "operation_type_id": 4,
    "amount": 123.45
}'
```

## Documentação Swagger

- Para acessar a documentação Swagger

```bash
http://localhost:8080/swagger-ui/index.html
```
