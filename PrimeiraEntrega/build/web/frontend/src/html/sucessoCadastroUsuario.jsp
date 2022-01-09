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
            <p> Usuario ${nomeUser} foi cadastrado com sucesso ! </p>
            <a style="color:white" href="entrada?acao=IndexAdm"><button class="btn btn-primary mt-3">Voltar</button></a>
        </div>
    <%@include file="scripts.jsp" %>    
    </body>
</html>
