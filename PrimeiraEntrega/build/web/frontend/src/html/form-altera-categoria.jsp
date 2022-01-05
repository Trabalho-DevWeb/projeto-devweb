<%-- 
    Document   : form-altera-categoria
    Created on : 04/01/2022, 01:19:30
    Author     : Ramos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/frontend/src/html/cabeçalho.html" %>
        <title>Alterar Categoria</title>
    </head>
    <body>
        <header>
            <%@include file="navbar.jsp" %>
        </header>

        <main class="container mt-3"> 

            <form action="http://localhost:8084/entrada?acao=AlteraCategoria" method="POST">

                <legend>Alterar Categoria</legend>
                <div class="form-group">
                    <label for="categoria">Categoria</label>
                    <input type="text" name="descricao" value="${categoria.descricao}" class="form-control" id="categoria" required>
                    <input type="hidden" name="id" value="${categoria.id}" class="form-control" id="id" placeholder="Digite a senha do administrador" required>
                    <input type="submit" value="incluir" class="btn btn-primary mt-3" re>

                </div>  
                 

            </form>
        </main>

        <%@include file="scripts.jsp" %>
 
    </body>
</html>
