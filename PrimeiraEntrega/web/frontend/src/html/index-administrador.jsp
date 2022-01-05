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
                <p>CPF: ${adminLogado.CPF}</p>
                <p>Nome: ${adminLogado.nome}</p>

                <button class="btn btn-outline-dark"><a href="entrada?acao=Logout">Sair</a></button>
            </div>
            </main>    
    </body>
</html>
