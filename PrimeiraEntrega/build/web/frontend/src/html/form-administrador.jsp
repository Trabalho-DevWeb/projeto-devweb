<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@include file="cabeçalho.html" %>
    <title>Administrador</title>
</head>
<body>
<header>
        <%@include file="navbar.jsp" %>
</header>
  
    <main class="container mt-3"> 

        <form action="http://localhost:8084/entrada?acao=CadastroAdmin" method="POST">

            <Legend>Cadastro Administrador</Legend>

            <div class="form-group">
              <label for="nome">Nome</label>
              <input type="text" name="nomeAdm" class="form-control" id="nome" placeholder="Digite o nome do administrador" required>
            </div>

            <div class="form-group">
              <label for="cpf">CPF</label>
              <input type="text" name="cpfAdm" class="form-control" id="cpf" placeholder="Digite o CPF do administrador" required>
            </div>

            <div class="form-group">
              <label for="email">E-mail</label>
              <input type="email" name="emailAdm" class="form-control" id="email" placeholder="Digite o email do administrador" required>
            </div>

            <div class="form-group">
              <label for="senha">senha</label>
              <input type="text" name="senhaAdm" class="form-control" id="senha" placeholder="Digite a senha do administrador" required>
            </div>

            <input type="submit" class="btn btn-primary mt-3" value="Enviar">    

        </form>
    </main>

    <%@include file="scripts.jsp" %>
 
</body>
</html>