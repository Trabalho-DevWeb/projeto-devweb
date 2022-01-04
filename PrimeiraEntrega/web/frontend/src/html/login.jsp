<%@page contentType="text/html;charset=UTF-8" language="java" %>

<% System.out.println(request.getContextPath()); %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/frontend/src/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/frontend/src/css/login.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/frontend/src/css/global.css">
    <title>Login</title>
</head>



<body>
    <header>
        <div class=" container mt-3 mb-3">
            <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
                <ul class="navbar-nav">
                    <li class="nav-item"><a class="nav-link" href="index.html">Página Inicial</a></li>
                    <li class="nav-item active"><a class="nav-link" href="login.html">Login</a></li>
                    <li class="nav-item"><a class="nav-link" href="form-categoria.html">form-categoria</a></li>
                    <li class="nav-item"><a class="nav-link" href="form-conta.html">form-conta</a></li>
                    <li class="nav-item"><a class="nav-link" href="form-usuario.html">form-usuario</a></li>
                    <li class="nav-item"><a class="nav-link" href="form-lancamento.html">form-lancamento</a></li>
                    <li class="nav-item"><a class="nav-link" href="form-administrador.html">form-administrador</a></li>
                    <li class="nav-item"><a class="nav-link" href="menu-temporario.html">menu-temporario</a></li>
                </ul>
            </nav>
        </div>
    </header>
    <div class="container">
        <div class="formbox">
        <form name="login" id="login" action="http://localhost:8084/PrimeiraEntrega/entrada?acao=Login" method="POST">
            <legend> <p>Login</p> </legend>
            <fieldset>
            <label for="cpf" class="form-label">CPF</label>
            <input type="text" id="cpf" name="cpf" class="form-control" required>
            <label for="senha">Senha</label>
            <input type="password" name="senha" class="form-control" required> <br>
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

    <script src="<%=request.getContextPath()%>/frontend/src/scripts/jquery-3.4.1.min.js"></script>
    <script src="<%=request.getContextPath()%>/frontend/src/scripts/popper.min.js"></script>
    <script src="<%=request.getContextPath()%>/frontend/src/scripts/bootstrap.min.js"></script>
    <script src="<%=request.getContextPath()%>/frontend/src/scripts/jquery.mask.min.js"></script>
    <script>
        $(document).ready(function(){
            $('#cpf').mask('000.000.000-00', {reverse: true});
            $('form').submit(function() {
             
            if($('#administrador').is(':checked') || $('#usuario').is(':checked') || $(#login).valid}) {
                alert('Login Aceito');
            } else {
                alert('Marcar se é usuario ou administrador');
            }  
        })
        })

        
    </script>
</body>
</html>