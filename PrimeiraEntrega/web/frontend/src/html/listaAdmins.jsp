<%-- 
    Document   : listaAdmins
    Created on : 03/01/2022, 05:28:19
    Author     : Ramos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*,aplicacao.Administrador" %>

<!DOCTYPE html>
<html>
    <head>
        <%@include file="/frontend/src/html/cabeçalho.html" %>
        <title>Lista de Administradores</title>
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
                        <th scope="col"><b>CPF</b><th>
                        <th scope="col"><b> </b><th>
                        <th scope="col"><b> </b><th>
                    </tr>  
                    <% 
                      List<Administrador>  administradores = (List<Administrador>)request.getAttribute("administradores"); 

                      for(Administrador administrador : administradores ){
                    %>
                    <tr>
                        <td><%=administrador.getNome()%></td>
                        <td><%=administrador.getCPF()%></td>
                        <td><a href="entrada?acao=MostraAdmin&id=<%=administrador.getId()%>">Alterar</a></td>
                        <td><a href="entrada?acao=RemoveAdmin&id=<%=administrador.getId()%>">Remover</a></td>
                        <td><a></a>
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
