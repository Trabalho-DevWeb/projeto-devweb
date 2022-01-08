<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@include file="/frontend/src/html/cabeçalho.html" %>
    <title>Cadastrar Categoria</title>
</head>
<body>
<header>
        <%@include file="navbar.jsp" %>
</header>
    <div class="container mt-3">

        <form action="/entrada?acao=CadastroCategoria" method="POST">
            <legend>Registrar Categoria</legend>
            <div class="form-group">
                <label for="categoria">Categoria</label>
                <input type="text" name="descricao" class="form-control" id="categoria" required>
                <input type="submit" value="incluir" class="btn btn-primary mt-3" re>

            </div>          
          

        </form>

    </div>

    <%@include file="scripts.jsp" %>

</body>
</html>