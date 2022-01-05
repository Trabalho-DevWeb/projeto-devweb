<%-- 
    Document   : sucessoCadastro
    Created on : 03/01/2022, 05:11:13
    Author     : Ramos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/frontend/src/html/cabeçalho.html" %>
        <title>Sucesso</title>
    </head>
    <body>
        <header>
            <%@include file="navbar.jsp" %>
        </header>
        <div class="container mt-3 mb-3"> 
            <p> Administrador ${nomeAdm} foi cadastrado com sucesso ! </p>
            <button class="btn btn-primary mt-3"><a href="entrada?acao=IndexAdm">Voltar</a></button>
        </div>
    <%@include file="scripts.jsp" %>    
    </body>
</html>
