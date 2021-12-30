<%-- 
    Document   : index-administrador
    Created on : 29/12/2021, 01:25:07
    Author     : Ramos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dashboard-Admin </title>
    </head>
    <body>
        <header>
            <div>
                <p>CPF: ${adminLogado.CPF}</p>
                <p>Nome:${adminLogado.nome}</p>
            </div>
        </header>
    </body>
</html>
