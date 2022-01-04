<%-- 
    Document   : sucessoCadastro
    Created on : 03/01/2022, 05:11:13
    Author     : Ramos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="../css/bootstrap.min.css">
        <link rel="stylesheet" href="../css/global.css" />
        <title>Sucesso</title>
    </head>
    <body>
        <div class="container mt-3 mb-3"> 
            <p> Categoria ${descricao} foi cadastrada com sucesso ! </p>
            <button class="btn btn-primary mt-3"><a href="entrada?acao=IndexAdm">Voltar</a></button>
        </div>
        
    </body>
</html>
