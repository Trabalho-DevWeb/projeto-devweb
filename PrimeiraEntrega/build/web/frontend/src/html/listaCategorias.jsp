<%-- 
    Document   : listaAdmins
    Created on : 03/01/2022, 05:28:19
    Author     : Ramos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*,aplicacao.Categoria" %>

<!DOCTYPE html>
<html>
    <head>
        <%@include file="/frontend/src/html/cabeçalho.html" %>
        <title>Lista de Categorias</title>
    </head>
    <body>
        <header>
            <%@include file="navbar.jsp" %>
        </header>
        <main class="container mt-3">
            <table class="table">
                <thead class="thead-light">
                    <tr>
                        <th scope="col"><b>Categoria</b></th>
                        <th scope="col"><b> </b></th>
                        <th scope="col"><b> </b></th>
                    </tr>  
                    <% 
                      List<Categoria>  categorias = (List<Categoria>)request.getAttribute("categorias"); 

                      for(Categoria categoria : categorias ){
                    %>
                    <tr>
                        <td><%=categoria.getDescricao()%></td>
                        <td><a href="entrada?acao=MostraCategoria&id=<%=categoria.getId()%>">Alterar</a></td>
                        <td><a href="entrada?acao=RemoveCategoria&id=<%=categoria.getId()%>">Remover</a></td>
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
