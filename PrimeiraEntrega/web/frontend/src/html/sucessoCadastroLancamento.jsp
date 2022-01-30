<%-- 
    Document   : SucessoCadastroLancamento
    Created on : 25/01/2022, 03:23:04
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
            <p> Lançamento com categoria ${lancamento} e valor ${valor} feito com sucesso ! </p>
            <a style="color:white" href="entrada?acao=IndexUsuario"><button class="btn btn-primary mt-3">Voltar</button></a>
        </div>
    <%@include file="scripts.jsp" %>    
    </body>
</html>