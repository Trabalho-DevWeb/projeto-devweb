<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <%@include file="/frontend/src/html/cabeçalho.html" %>
    <title>Conta</title>
  </head>
  <body>
    <div class="container mt-3">
        <%@include file="navbar.jsp" %>
    </div>
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

    <%@include file="scripts.jsp" %>
 
  </body>
</html>
