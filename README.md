<h1>API-tarefas</h1>
<p>Nesse exercício de Spring Framework foi desenvolvido uma API onde o usuário pode buscar/criar/editar/deletar tarefas.</p>

Documentação: http://localhost:8080/swagger-ui.html

## Componentes

- JDK 11
- MySQL
- Postman
- Eclipse IDE
- Maven

## Instruções

1. Crie o banco de dados *"tarefas"*.
2. Nas configurações de execução adicione as variveis de ambiente e seus valores ou modifique o arquivo application.properties:

    `spring.datasource.url=${DATABASE_URL}`<br>
    `spring.datasource.username=${DATABASE_USERNAME}`<br>
    `spring.datasource.password=${DATABASE_PASSWORD}`<br>
    `tarefas.jwt.secret=${DATABASE_SECRET}`
    
3. Execute o projeto e no banco de dados na tabela usuarios, adicione um usuário para usar na autenticação.
    ~~~sql
    INSERT INTO usuarios (email, nome, senha) VALUES ('usuario@teste.com', 'Teste', '$2a$10$Z3U/0xhau3hnejQCdJpCgOs2Ewy2rZJ79o1uC7DZm3J3TLOSB45gm');
4. Utilize as credenciais para autenticar e gerar o token para acessar os demais endpoints:
    ~~~json
    {
      "email" : "usuario@teste.com",
      "senha" : "Teste123"
    }
    
