<%-- 
    Document   : form-altera-categoria
    Created on : 04/01/2022, 01:19:30
    Author     : Ramos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/frontend/src/css/bootstrap.min.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/frontend/src/css/global.css">
        <title>Alterar Categoria</title>
    </head>
    <body class="container">
        <header>
            <div class="container mt-3">
                <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
                    <ul class="navbar-nav">
                        <li class="nav-item"><a class="nav-link" href="index.html">Página Inicial</a></li>
                        <li class="nav-item"><a class="nav-link" href="login.html">Login</a></li>
                        <li class="nav-item"><a class="nav-link" href="form-categoria.html">form-categoria</a></li>
                        <li class="nav-item"><a class="nav-link" href="form-conta.html">form-conta</a></li>
                        <li class="nav-item"><a class="nav-link" href="form-usuario.html">form-usuario</a></li>
                        <li class="nav-item"><a class="nav-link" href="form-lancamento.html">form-lancamento</a></li>
                        <li class="nav-item active"><a class="nav-link" href="form-administrador.html">form-administrador</a></li>
                        <li class="nav-item"><a class="nav-link" href="menu-temporario.html">menu-temporario</a></li>
                    </ul>
                </nav>
            </div>
        </header>

        <main class="container"> 

            <form action="http://localhost:8084/PrimeiraEntrega/entrada?acao=AlteraCategoria" method="POST">

                <legend>Alterar Categoria</legend>
                <div class="form-group">
                    <label for="categoria">Categoria</label>
                    <input type="text" name="descricao" value="${categoria.descricao}" class="form-control" id="categoria" required>
                    <input type="hidden" name="id" value="${categoria.id}" class="form-control" id="id" placeholder="Digite a senha do administrador" required>
                    <input type="submit" value="incluir" class="btn btn-primary mt-3" re>

                </div>  
                 

            </form>
        </main>
        <script src="<%=request.getContextPath()%>/frontend/src/scripts/jquery-3.4.1.min.js"></script>
        <script src="<%=request.getContextPath()%>/frontend/src/scripts/popper.min.js"></script>
        <script src="<%=request.getContextPath()%>/frontend/src/scripts/bootstrap.min.js"></script>  
    </body>
</html>
