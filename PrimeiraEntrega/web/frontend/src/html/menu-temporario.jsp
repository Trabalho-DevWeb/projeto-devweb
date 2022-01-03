<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="cabeçalho.html" %>
        <title>Index</title>
    </head>
    <body>
        <%@include file="navbar.jsp" %>
        <div class="container" id="menu">
            <h1> Menu Temporário </h1> 
            <h2>Links para os Formularios</h2>
            <div id="menu-in" style="margin-top:50px ; font-size:25px ; padding:20px; border-radius:5px; background-color:rgba(170, 192, 226, 0.658)">
                <a href="form-usuario.html" style="background-color: rgba(117, 143, 201, 0.404) ; border-radius:5px; margin:5px; ;padding:5px; color: rgb(48, 3, 245)">Formulario do Usuario</a><br>
                <a href="form-lancamento.html " style="background-color: rgba(117, 143, 201, 0.404) ; border-radius:5px; margin:5px; padding:5px; color: rgb(48, 3, 245)">Formulario do Lançamento</a><br>
                <a href="form-conta.html" style="background-color: rgba(117, 143, 201, 0.404) ; border-radius:5px; margin:5px; padding:5px; color: rgb(48, 3, 245)">Formulario da Conta</a><br>
                <a href="form-categoria.html" style="background-color: rgba(117, 143, 201, 0.404) ; border-radius:5px; margin:5px ; padding:5px; color: rgb(48, 3, 245)">Formulario da Categoria</a><br>
                <a href="form-administrador.html" style="background-color: rgba(117, 143, 201, 0.404) ; border-radius:5px; margin:5px ;padding:5px; color: rgb(48, 3, 245)">Formulario do Admnistrador</a><br>
                <a href="login.html" style="background-color: rgba(117, 143, 201, 0.404) ; border-radius:5px; margin:5px; padding:5px; color: rgb(48, 3, 245)">Login</a><br>
                <a href="index.html" style="background-color: rgba(117, 143, 201, 0.404) ; border-radius:5px; margin:5px ;padding:5px; color: rgb(48, 3, 245)">Página Principal</a><br>
            </div>
        </div>
        <%@include file="scripts.html" %>
    </body>
</html>
