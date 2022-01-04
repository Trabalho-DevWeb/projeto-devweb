<%-- 
    Document   : index-administrador
    Created on : 29/12/2021, 01:25:07
    Author     : Ramos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dashboard-Admin </title>
    </head>
    <body>
        <header>
            <div>
                <p>CPF: ${adminLogado.CPF}</p>
                <p>Nome:${adminLogado.nome}</p>
            </div>
            <div>
                <button><a href="entrada?acao=Logout">Sair</a></button>
            </di>
        </header>
            <main>
                <section>
                    <div>
                        <a href="entrada?acao=FormAdmin"> Cadastrar Administrador </a>
                        <a href="entrada?acao=FormCategoria"> Cadastrar Categoria </a>
                        <a href="entrada?acao=FormUsuario"> Cadastrar Usuário </a>
                        <a href="entrada?acao=ListaAdmins">Listar Administradores</a>
                        <a href="entrada?acao=ListaCategorias">Listar Categorias</a>
                        <a href="entrada?acao=ListaUsuarios">Listar Usuarios</a>
                    </div>
                </section>
            </main>    
    </body>
</html>
