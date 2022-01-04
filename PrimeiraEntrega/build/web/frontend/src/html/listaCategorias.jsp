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
            <th><b>Descrição</b></th>
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
        </table>
        
    </body>
</html>
