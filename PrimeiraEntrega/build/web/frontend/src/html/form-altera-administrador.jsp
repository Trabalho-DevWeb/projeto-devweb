<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/frontend/src/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/frontend/src/css/global.css">
    <title>Alterar Administrador</title>
</head>
<body>
    <header>
            <%@include file="navbar.jsp" %>
    </header>
  
    <main class="container mt-3"> 

        <form action="/entrada?acao=AlteraAdministrador" method="POST">

            <Legend>Alterar cadastro do Administrador</Legend>

            <div class="form-group">
              <label for="nome">Nome</label>
              <input type="text" name="nomeAdm" value="${admin.nome}" class="form-control" id="nome" placeholder="Digite o nome do administrador" required>
            </div>

            <div class="form-group">
              <label for="cpf">CPF</label>
              <input type="text" name="cpfAdm" value="${admin.CPF}" class="form-control" id="cpf" placeholder="Digite o CPF do administrador" required>
            </div>



            <div class="form-group">
              <label for="senha">senha</label>
              <input type="text" name="senhaAdm" value="${admin.senha}" class="form-control" id="senha" placeholder="Digite a senha do administrador" required>
            </div>
            
           
            <input type="hidden" name="idAdm" value="${admin.id}" class="form-control" id="id" placeholder="Digite a senha do administrador" required>
            
            
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