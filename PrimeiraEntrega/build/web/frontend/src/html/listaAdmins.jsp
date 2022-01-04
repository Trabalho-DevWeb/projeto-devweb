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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="../css/bootstrap.min.css">
        <link rel="stylesheet" href="../css/global.css" />
        <title>Lista de Administradores</title>
    </head>
    <body>
        <table>
          <tr >
          <th><b>Nome</b></th>
          <th><b>Email</b></th>
          <th><b>CPF</b><th>
          </tr>  
        <% 
          List<Administrador>  administradores = (List<Administrador>)request.getAttribute("administradores"); 
          
          for(Administrador administrador : administradores ){
        %>
        <tr>
            <td><%=administrador.getNome()%></td>
            <td><%=administrador.getEmail()%></td>
            <td><%=administrador.getCPF()%></td>
            <td><a href="entrada?acao=MostraAdmin&id=<%=administrador.getId()%>">Alterar</a></td>
            <td><a href="entrada?acao=RemoveAdmin&id=<%=administrador.getId()%>">Remover</a></td>
            <td><a></a>
        </tr>

        
        <%       
        }
        %>
        </table>
        
    </body>
</html>
