<%-- 
    Document   : listaAdmins
    Created on : 03/01/2022, 05:28:19
    Author     : Ramos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*,aplicacao.Usuario" %>

<!DOCTYPE html>
<html>
    <head>
        <%@include file="/frontend/src/html/cabeçalho.html" %>
        <title>Lista de Usuarios</title>
    </head>
    <body>
        <header>
            <%@include file="navbar.jsp" %>
        </header>
        <main class="container mt-3">
            <table class="table">
                <thead class="thead-light">
                    <tr>
                        <th scope="col"><b>Nome</b></th>
                        <th scope="col"><b>CPF</b></th>
                        <th scope="col">Suspenso</th>
                        <th scope="col"><b> </b></th>
                        <th scope="col"><b> </b></th>

                    </tr>  
                    <% 
                      List<Usuario>  usuarios = (List<Usuario>)request.getAttribute("usuarios"); 

                      for(Usuario usuario : usuarios ){
                    %>
                    <tr>
                        <td><%=usuario.getNome()%></td>
                        <td><%=usuario.getCPF()%></td>
                        <td><%=usuario.isBloqueado()%></td>
                        <td><a href="entrada?acao=MostraUsuario&id=<%=usuario.getId()%>">Alterar</a></td>
                        <td><a href="entrada?acao=RemoveUsuario&id=<%=usuario.getId()%>">Remover</a></td>
                    </tr>

                    <%       
                    }
                    %>
                </thead>
            </table>
        </main>
        <%@include file="scripts.jsp" %>
    </body>
</html>
