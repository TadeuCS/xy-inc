# Projeto XY Inc
Este projeto tem como objetivo demonstrar meus conhecimentos.

# Tecnologia
Esta API é baseada em REST e foi desenvolvido em Spring Boot com integração com JUnit e Mockito
para implementação de rotinas de testes unitários.

# URL Acesso a Documentação da API
https://documenter.getpostman.com/view/3817254/S1a7X6QU

# Banco de Dados
Foi utilizado um banco de dados MySQL, que está hospedado gratuítamente em uma 
máquina virtual disponibilizada pelo site https://freemysqlhosting.net então
para testar a execução da aplicação não será necessário fazer nenhum ajuste
na aplicação. 
Obs: como a configuração feita no arquivo application.properties, para o atributo
spring.jpa.hibernate.ddl-auto é "create", isso irá remover todos os dados inseridos
no banco a cada nova execução do projeto. Se necessário que os dados não sejam
mais removidos, basta alterar este atributo para "none".

# Requisitos para Execução
Java JDK (versao 8 ou superior)
Maven
