<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/frontend/src/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/frontend/src/css/global.css">
    <title>Cadastrar Usu�rio</title>
</head>
<body >

    <header class="header">
        <div class="container mt-3 mb-3">
            <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
                <ul class="navbar-nav">
                    <li class="nav-item"><a class="nav-link" href="index.html">P�gina Inicial</a></li>
                    <li class="nav-item"><a class="nav-link" href="login.html">Login</a></li>
                    <li class="nav-item"><a class="nav-link" href="form-categoria.html">form-categoria</a></li>
                    <li class="nav-item"><a class="nav-link" href="form-conta.html">form-conta</a></li>
                    <li class="nav-item active"><a class="nav-link" href="form-usuario.html">form-usuario</a></li>
                    <li class="nav-item"><a class="nav-link" href="form-lancamento.html">form-lancamento</a></li>
                    <li class="nav-item"><a class="nav-link" href="form-administrador.html">form-administrador</a></li>
                    <li class="nav-item"><a class="nav-link" href="menu-temporario.html">menu-temporario</a></li>
                </ul>
            </nav>
        </div>
    </header>
    <main class="container"> 

        <form action="http://localhost:8084/PrimeiraEntrega/entrada?acao=CadastroUsuario" method="POST">

            <Legend>Cadastro Usu�rio</Legend>

            <div class="form-group">
              <label for="nome">Nome</label>
              <input type="nome" name="nome" class="form-control" id="nome" placeholder="Digite o nome do usuario" required>
            </div>

            <div class="form-group">
              <label for="cpf">CPF</label>
              <input type="text" name="cpf" class="form-control" id="cpf" placeholder="Digite o CPF do usuario" required>
            </div>

            <div class="form-group">
              <label for="email">E-mail</label>
              <input type="email" name="email" class="form-control" id="email" placeholder="Digite o email do usuario" required>
            </div>
            
            <div class="form-group">
              <label for="senha">Senha</label>
              <input type="senha" name="senha" class="form-control" id="senha" placeholder="Digite a senha do usuario" required>
            </div>

            <label>Suspenso ?</label>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" value="" id="suspenso-s">
                <label class="form-check-label mr-4" for="suspenso-s">Sim</label>
                <input class="form-check-input" type="checkbox" value="" id="suspenso-n">
                <label class="form-check-label" for="suspenso-n">N�o</label>
            </div>

            <input type="submit" class="btn btn-primary mt-3" value="Enviar">    

        </form>
    </main>

    <script src="<%=request.getContextPath()%>/frontend/src/scripts/jquery-3.4.1.min.js"></script>
    <script src="<%=request.getContextPath()%>/frontend/src/scripts/popper.min.js"></script>
    <script src="<%=request.getContextPath()%>/frontend/src/scripts/bootstrap.min.js"></script>
    <script src="<%=request.getContextPath()%>/frontend/src/scripts/jquery.mask.min.js"></script>
    <script>
        $(document).ready(function(){
            $("#cpf").mask('000.000.000-00', {reverse: true});
            $('form').submit(function() {
            if($('#suspenso-s').is(':checked') || $('#suspenso-n').is(':checked')) {
                alert('Usuario cadastrado');
            } else {
                alert('Marcar se o usuario est� suspenso ou n�o');
            }
        })
        })

    </script>
</body>
</html>