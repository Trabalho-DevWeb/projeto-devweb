<%@page contentType="text/html;charset=UTF-8" language="java" %>

<% System.out.println(request.getContextPath()); %>
<html lang="en">
<head>
    <%@include file="/frontend/src/html/cabeçalho.html" %>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/frontend/src/css/login.css">
    <title>Login</title>
</head>

<body>
    <header>
        <div class="container mt-3 mb-3">
            <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
                <ul class="navbar-nav">
                    <li class="nav-item active"><a class="nav-link" href="frontend/src/html/index.jsp">Página Inicial</a></li>
                    <li class="nav-item active"><a class="nav-link" href="../../../entrada?acao=LoginForm">Login</a></li>
                </ul>
            </nav>
        </div>
    </header>
    <div class="container">
        <div class="formbox">
        <form name="login" id="login" action="/entrada?acao=Login" method="POST">
            <legend> <p>Login</p> </legend>
            <fieldset>
            <label for="cpf" class="form-label">CPF</label>
            <input type="text" id="cpf" name="cpf" class="form-control" required>
            <label for="senha">Senha</label>
            <input type="password" name="senha" class="form-control" required> <br>
            <p>Você é:</p>
            <label for="administrador" class="form-label">Administrador</label>
            <input type="radio" id="administrador" value="administrador" name="user">
            <label for="usuario" class="form-label">Usuario</label>     
            <input type="radio" id="usuario" value="usuario" name="user"> <br>
            <div class="submit">
            <input type="submit"class="btn btn-primary" id="logar" value="Entrar"  >
        </div>
        </fieldset>
        </form>
        </div>
    </div>


    <%@include file="scripts.jsp" %>
 
    <script>
        $(document).ready(function(){
            $('#cpf').mask('000.000.000-00', {reverse: true});
            $('form').submit(function() {
             
            if($('#administrador').is(':checked') || $('#usuario').is(':checked') || $(login).valid) {
            } else {
                alert('Marcar se é usuario ou administrador');
            }  
        })
        })

        
    </script>
</body>
</html>