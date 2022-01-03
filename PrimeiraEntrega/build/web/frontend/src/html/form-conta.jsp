<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="cabeçalho.html" %>
        <title>Index</title>
    </head>
    <body>
        <%@include file="navbar.jsp" %>
            <div class="container mt-3">
                <form action="">

                  <Legend>Cadastro Conta</Legend>

                  <div class="form-group">
                    <label for="nome">Nome</label>
                    <input type="nome" class="form-control" id="nome" placeholder="Nome de usuario" required>
                  </div>

                  <div class="form-group">
                    <label for="banco">Banco</label>
                    <input type="text" class="form-control" id="banco" list="bancos" placeholder="Nº do Banco" required>
                    <datalist id="bancos">
                      <option value="0001"></option>
                      <option value="0002"></option>
                      <option value="0003"></option>
                      <option value="0004"></option>
                    </datalist>
                    <input class="btn btn-primary mt-3" type="submit" value="Enviar">
                  </div>
                </form>
              </div>
        <%@include file="scripts.html" %>
        </script>
    </body>
</html>
