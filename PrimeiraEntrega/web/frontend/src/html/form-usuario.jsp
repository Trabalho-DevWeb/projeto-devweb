<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="cabeçalho.html" %>
        <title>Index</title>
    </head>
    <body>
        <%@include file="navbar.jsp" %>
        <main class="container"> 
            <form action="">

                <Legend>Cadastro Usuário</Legend>

                <div class="form-group">
                  <label for="nome">Nome</label>
                  <input type="nome" class="form-control" id="nome" placeholder="Digite o nome do usuario" required>
                </div>

                <div class="form-group">
                  <label for="cpf">CPF</label>
                  <input type="text" class="form-control" id="cpf" placeholder="Digite o CPF do usuario" required>
                </div>

                <div class="form-group">
                  <label for="email">E-mail</label>
                  <input type="email" class="form-control" id="email" placeholder="Digite o email do usuario" required>
                </div>

                <label>Suspenso ?</label>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" value="" id="suspenso-s">
                    <label class="form-check-label mr-4" for="suspenso-s">Sim</label>
                    <input class="form-check-input" type="checkbox" value="" id="suspenso-n">
                    <label class="form-check-label" for="suspenso-n">Não</label>
                </div>

                <input type="submit" class="btn btn-primary mt-3" value="Enviar">    

            </form>
        </main>
        <%@include file="scripts.html" %>
        <script>
            $(document).ready(function(){
                $("#cpf").mask('000.000.000-00', {reverse: true});
                $('form').submit(function() {
                    if($('#suspenso-s').is(':checked') || $('#suspenso-n').is(':checked')) {
                        alert('Usuario cadastrado');
                    } else {
                        alert('Marcar se o usuario está suspenso ou não');
                    }
                })
            })
        </script>
    </body>
</html>
