<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@include file="/frontend/src/html/cabeçalho.html" %>
    <title>Cadastrar Usuário</title>
</head>
<body>

    <header>
        <%@include file="navbar.jsp" %>
    </header>
    <main class="container mt-3"> 

        <form action="/entrada?acao=AlteraUsuario" method="POST">

            <Legend>Cadastro Usuário</Legend>

            <div class="form-group">
              <label for="nome">Nome</label>
              <input type="nome" name="nome" class="form-control" value="${usuario.nome}"id="nome" placeholder="Digite o nome do usuario" required>
            </div>

            <div class="form-group">
              <label for="cpf">CPF</label>
              <input type="text" name="cpf" class="form-control" value="${usuario.CPF}" id="cpf" placeholder="Digite o CPF do usuario" required>
            </div>
            
            
            <div class="form-group">
              <label for="senha">Senha</label>
              <input type="senha" name="senha" class="form-control" value="${usuario.senha}" id="senha" placeholder="Digite a senha do usuario" required>
            </div>

            <label>Suspenso ?</label>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" name="suspenso" value="S" id="suspenso-s">
                <label class="form-check-label mr-4" for="suspenso-s">Sim</label>
                <input class="form-check-input" type="checkbox" name="suspenso" value="N" id="suspenso-n">
                <label class="form-check-label" for="suspenso-n">Não</label>
            </div>
            
            <input type="hidden" name="id" value="${usuario.id}" class="form-control" id="id" placeholder="Digite a senha do administrador" required>
            
            <input type="submit" class="btn btn-primary mt-3" value="Enviar">    

        </form>
    </main>

    <%@include file="scripts.jsp" %>
    
    <script>
        $(document).ready(function(){
            $("#cpf").mask('000.000.000-00', {reverse: true});
           
        });

    </script>
</body>
</html>