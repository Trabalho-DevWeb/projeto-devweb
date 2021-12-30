<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/global.css" />
    <title>Conta</title>
  </head>
  <body>
    <div class="container mt-3">
        <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
            <ul class="navbar-nav">
                <li class="nav-item"><a class="nav-link" href="index.html">Página Inicial</a></li>
                <li class="nav-item"><a class="nav-link" href="login.html">Login</a></li>
                <li class="nav-item"><a class="nav-link" href="form-categoria.html">form-categoria</a></li>
                <li class="nav-item active"><a class="nav-link" href="form-conta.html">form-conta</a></li>
                <li class="nav-item"><a class="nav-link" href="form-usuario.html">form-usuario</a></li>
                <li class="nav-item"><a class="nav-link" href="form-lancamento.html">form-lancamento</a></li>
                <li class="nav-item"><a class="nav-link" href="form-administrador.html">form-administrador</a></li>
                <li class="nav-item"><a class="nav-link" href="menu-temporario.html">menu-temporario</a></li>
            </ul>
        </nav>
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
    <script src="../scripts/jquery-3.4.1.min.js"></script>
    <script src="../scripts/popper.min.js"></script>
    <script src="../scripts/bootstrap.min.js"></script>
  </body>
</html>
