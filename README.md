# CRUD SPRING BOOT

-Esse projeto cria 1 empresa e 1 usuario, os usuarios podendo depositar e sacar os valores dessas empresas, as empresas tem uma taxa para cada ação, deposito e saque.

# Pré-requisitos
Certifique-se de ter o seguinte instalado em sua máquina:

-JDK 8 ou superior 

-Maven 

-Git 

# Configuração do Projeto
1 - Clone este repositório:
```
git clone https://github.com/Isaachbt/movimentacao.git
```

2 - Navegue ate o diretorio:
```
 cd movimentacao
```
3 - Execute o aplicativo Spring Boot:
```
mvn spring-boot:run
```

O aplicativo estará disponível em http://localhost:8080.

## Necessario ter

- Postman ou Insomnia
- Recomendo Intellij
- Recomendo utilizar: http://localhost:8080/h2-console para melhor visualização

# Funcionalidades
Este aplicativo Spring CRUD oferece as seguintes funcionalidades:

Create(POST): Cadastrar usuairo e Empresas.

Create(POST): Saques e depositos.

# URL para usar
-http://localhost:8080/user/Registering ( para registrar usuarios, login,cpf)

-http://localhost:8080/empresa/Registering (para registrar uma nova empresa, nome,cpf e saldo)

-http://localhost:8080/transacao/{cnpj}/{tipoTransacao}/{valor} (Para realizar saque ou deposito)

-Exemplo: http://localhost:8080/transacao/49841400000119/DEPOSITO/1000

# Respostas de erro
- Empresa não encontrada: 403
- Empresa ja tem uma conta: 409
- Dados invalidos: 409
- Paramentros passo invalido: 409
- Saldo invalido: 409
- valor menor ou 0: 409
- Usuario ja tem conta: 409

# Tecnologias Utilizadas
- Spring Boot
- Spring Data JPA
- Hateos
- Lombok
- Databse h2
- validation
- mockito
- JUnit5
- Webhook

# Contribuição
Sinta-se à vontade para contribuir com novos recursos, correções de bugs ou melhorias de desempenho. Basta enviar um pull request!

# Licença
Este projeto é licenciado sob a [MIT License](LICENSE).
