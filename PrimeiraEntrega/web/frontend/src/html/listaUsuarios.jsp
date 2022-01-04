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
            <th><b>CPF</b></th>
            <th><b>Email</b></th>
          </tr>  
        <% 
          List<Usuario>  usuarios = (List<Usuario>)request.getAttribute("usuarios"); 
          
          for(Usuario usuario : usuarios ){
        %>
        <tr>
            <td><%=usuario.getNome()%></td>
            <td><%=usuario.getCPF()%></td>
            <td><%=usuario.getEmail()%></td>
            <td><a href="entrada?acao=MostraUsuario&id=<%=usuario.getId()%>">Alterar</a></td>
            <td><a href="entrada?acao=RemoveUsuario&id=<%=usuario.getId()%>">Remover</a></td>
        </tr>

        
        <%       
        }
        %>
        </table>
        
    </body>
</html>
