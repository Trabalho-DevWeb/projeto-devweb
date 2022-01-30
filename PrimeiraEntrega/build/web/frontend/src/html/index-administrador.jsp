<%-- 
    Document   : index-administrador
    Created on : 29/12/2021, 01:25:07
    Author     : Ramos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/frontend/src/html/cabeçalho.html" %>
        <title>Dashboard-Admin </title>
    </head>
    <body>
        <header>
            <div>
                <%@include file="navbar.jsp" %>
            </div>

        </header>
            <main>
            <div class="container mt-3">
                <p>CPF: ${individuoLogado.CPF}</p>
                <p>Nome: ${individuoLogado.nome}</p>

                <a style="color:white" href="entrada?acao=Logout"><button class="btn btn-primary">Sair</button></a>
            </div>
            </main>    
    </body>
</html>
