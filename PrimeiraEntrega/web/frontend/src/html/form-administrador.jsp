<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/frontend/src/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/frontend/src/css/global.css">
    <title>Administrador</title>
</head>
<body class="container">
<header>
    <div class="container mt-3">
        <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
            <ul class="navbar-nav">
                <li class="nav-item"><a class="nav-link" href="index.html">Página Inicial</a></li>
                <li class="nav-item"><a class="nav-link" href="login.html">Login</a></li>
                <li class="nav-item"><a class="nav-link" href="form-categoria.html">form-categoria</a></li>
                <li class="nav-item"><a class="nav-link" href="form-conta.html">form-conta</a></li>
                <li class="nav-item"><a class="nav-link" href="form-usuario.html">form-usuario</a></li>
                <li class="nav-item"><a class="nav-link" href="form-lancamento.html">form-lancamento</a></li>
                <li class="nav-item active"><a class="nav-link" href="form-administrador.html">form-administrador</a></li>
                <li class="nav-item"><a class="nav-link" href="menu-temporario.html">menu-temporario</a></li>
            </ul>
        </nav>
    </div>
</header>
  
    <main class="container"> 

        <form action="http://localhost:8084/PrimeiraEntrega/entrada?acao=CadastroAdmin" method="POST">

            <Legend>Cadastro Administrador</Legend>

            <div class="form-group">
              <label for="nome">Nome</label>
              <input type="text" name="nomeAdm" class="form-control" id="nome" placeholder="Digite o nome do administrador" required>
            </div>

            <div class="form-group">
              <label for="cpf">CPF</label>
              <input type="text" name="cpfAdm" class="form-control" id="cpf" placeholder="Digite o CPF do administrador" required>
            </div>

            <div class="form-group">
              <label for="email">E-mail</label>
              <input type="email" name="emailAdm" class="form-control" id="email" placeholder="Digite o email do administrador" required>
            </div>

            <div class="form-group">
              <label for="senha">senha</label>
              <input type="text" name="senhaAdm" class="form-control" id="senha" placeholder="Digite a senha do administrador" required>
            </div>

            <input type="submit" class="btn btn-primary mt-3" value="Enviar">    

        </form>
    </main>
    <script src="<%=request.getContextPath()%>/frontend/src/scripts/jquery-3.4.1.min.js"></script>
    <script src="<%=request.getContextPath()%>/frontend/src/scripts/popper.min.js"></script>
    <script src="<%=request.getContextPath()%>/frontend/src/scripts/bootstrap.min.js"></script>  
</body>
</html>