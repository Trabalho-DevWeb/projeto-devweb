<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@include file="/frontend/src/html/cabeçalho.html" %>
    <title>Index</title>
</head>
<body>
<header class="header">
    <div class="container mt-3 mb-3">
        <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
            <ul class="navbar-nav">
                <li class="nav-item active"><a class="nav-link" href="index.jsp">Página Inicial</a></li>
                <li class="nav-item"><a class="nav-link" href="../../../entrada?acao=LoginForm">Login</a></li>
            </ul>
        </nav>
    </div>
</header>
<main class="container">
    <h1>Bem Vindo à plataforma de gerencimanto do seu Banco !</h1>
   
</main>
<footer class="container">
    <span>Essa aplicação utiliza JDBC, JSP, Servlet, Bootstrap</span>
    <br>
    <span>12/11/2021</span>   
</footer>

    <%@include file="scripts.jsp" %>

</body>
</html>