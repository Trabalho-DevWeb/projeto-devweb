<%-- 
    Document   : listaContas
    Created on : 28/01/2022, 02:05:50
    Author     : Ramos
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*,aplicacao.Conta" %>

<!DOCTYPE html>
<html>
    <head>
        <%@include file="/frontend/src/html/cabeçalho.html" %>
        <title>Lista de Contas</title>
    </head>
    <body>
        <header>
            <%@include file="navbar-2nd.jsp" %>
        </header>
        <main class="container mt-3">
            <table class="table">
                <thead class="thead-light">
                    <tr>
                        <th scope="col"><b>Conta</b></th>
                        <th scope="col"><b> </b></th>
                        <th scope="col"><b> </b></th>
                        <th scope="col"><b> </b></th>
                    </tr>  
                    <% 
                      List<Conta>  contas = (List<Conta>)request.getAttribute("contas"); 

                      for(Conta conta : contas ){
                    %>
                    <tr>
                        <td><%=conta.getConta_corrente()%></td>
                        <td><a href="entrada?acao=ListaLancamentos&id=<%=conta.getId()%>">Lancamentos</a></td>
                        <td><a href="entrada?acao=MostraConta&id=<%=conta.getId()%>">Alterar</a></td>
                        <td><a href="entrada?acao=RemoveConta&id=<%=conta.getId()%>">Remover</a></td>
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

