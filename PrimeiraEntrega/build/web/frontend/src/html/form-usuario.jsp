<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@include file="/frontend/src/html/cabeçalho.html" %>
    <title>Cadastrar Usuário</title>
</head>
<body >

    <header class="header">
        <div>
            <%@include file="navbar.jsp" %>
        </div>
    </header>
    <main class="container mt-3"> 

        <form action="/entrada?acao=CadastroUsuario" method="POST">

            <Legend>Cadastro Usuário</Legend>

            <div class="form-group">
              <label for="nome">Nome</label>
              <input type="nome" name="nome" class="form-control" id="nome" placeholder="Digite o nome do usuario" required>
            </div>

            <div class="form-group">
              <label for="cpf">CPF</label>
              <input type="text" name="cpf" class="form-control" id="cpf" placeholder="Digite o CPF do usuario" required>
            </div>
        
            <div class="form-group">
              <label for="senha">Senha</label>
              <input type="senha" name="senha" class="form-control" id="senha" placeholder="Digite a senha do usuario" required>
            </div>


            <input type="submit" class="btn btn-primary mt-3" value="Enviar">    

        </form>
    </main>

    <%@include file="scripts.jsp" %>

    <script>
        $(document).ready(function(){
            $("#cpf").mask('000.000.000-00', {reverse: true});
        })

    </script>
</body>
</html>