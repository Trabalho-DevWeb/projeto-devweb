<%-- 
    Document   : sucessoCadastroConta
    Created on : 23/01/2022, 02:30:21
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
            <%@include file="navbar-2nd.jsp" %>
        </header>
        <div class="container mt-3 mb-3"> 
            <p> Conta ${numeroConta} cadastrada com sucesso ! </p>
            <a style="color:white" href="entrada?acao=IndexUsuario"><button class="btn btn-primary mt-3">Voltar</button></a>
        </div>
    <%@include file="scripts.jsp" %>    
    </body>
</html>
