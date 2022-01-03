<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="cabeçalho.html" %>
        <title>Index</title>
    </head>
    <body>
        <%@include file="navbar.jsp" %>
            <div class="container">
                <div class="formbox">
                <form name="login" action="">
                    <legend> <p>Login</p> </legend>
                    <fieldset>
                    <label for="cpf" class="form-label">CPF</label>
                    <input type="text" id="cpf" class="form-control" required>
                    <label for="senha">Senha</label>
                    <input type="password" class="form-control" required> <br>
                    <p>Você é:</p>
                    <label for="administrador" class="form-label">Administrador</label>
                    <input type="radio" id="administrador" value="administrador" name="user" onclick="valida1()">
                    <label for="usuario" class="form-label">Usuario</label>     
                    <input type="radio" id="usuario" value="usuario" name="user"> <br>
                    <div class="submit">
                    <input type="submit"class="btn btn-primary" id="logar" value="Entrar"  >
                </div>
                </fieldset>
                </form>
                </div>
            </div>
        <%@include file="scripts.html" %>
        <script>
            $(document).ready(function(){
                $("#cpf").mask('000.000.000-00', {reverse: true});
            })
        </script>
    </body>
</html>
