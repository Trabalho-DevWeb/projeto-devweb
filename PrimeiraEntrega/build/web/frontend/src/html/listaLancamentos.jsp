<%-- 
    Document   : listaLancamentos
    Created on : 28/01/2022, 03:32:30
    Author     : Ramos
--%>

<%@page import="java.text.DecimalFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*,aplicacao.Lancamento" %>

<!DOCTYPE html>
<html>
    <head>
        <%@include file="/frontend/src/html/cabeçalho.html" %>
        <title>Lista de Lançamentos</title>
    </head>
    <body>
        <header>
            <%@include file="navbar-2nd.jsp" %>
        </header>
        <main class="container mt-3">
            
            
            
            <table class="table">
                <thead class="thead-light">
                    <tr>
                        <th scope="col"><b>Lançamentos</b></th>
                        <th scope="col"><b>Data de Lançamento</b></th>
                        <th scope="col"><b>Valor</b></th>
                        <th scope="col"><b>Operação</b></th>
                        <th scope="col"><b>Descrição</b></th>
                        <th scope="col"><b></b></th>
                        <th scope="col"><b></b></th>
                       
                    </tr>  
                    <% 
                      List<Lancamento>  lancamentos = (List<Lancamento>)request.getAttribute("lancamentos"); 

                      for(Lancamento lancamento : lancamentos ){
                    %>
                    <tr>
                        <td><%=lancamento.getCategoria()%> </td>
                        <td><%=lancamento.getData()%></td>
                        <td><%=lancamento.getValor()%></td>
                        <td><%=lancamento.getOperacao()%></td>
                        <td><%=lancamento.getDescricao()%></td>
                        <td><a href="entrada?acao=MostraLancamento&id=<%=lancamento.getId()%>&idConta=${idConta}">Alterar</a></td>
                        <td><a href="entrada?acao=RemoveLancamento&id=<%=lancamento.getId()%>&idConta=${idConta}">Remover</a></td>
                        
                    </tr>
                    <%       
                    }
                    %>
                </thead>
            </table>
           
            
            <table class="table">
                <thead class="thead-light">
                    <tr>
                        <th scope="col"><b>Somatorio Creditos</b></th>
                        <th scope="col"><b>Somatorio Debitos</b></th>
                        <th scope="col"><b>Saldo</b></th>
                       
                    </tr>  
                    <% 
                      Double somaCredito = 0.0 ;  
                      Double somaDebito = 0.0 ;
                      Double saldo = 0.0;
                      List<Lancamento>  creditos = (List<Lancamento>)request.getAttribute("creditos"); 
                      List<Lancamento>  debitos = (List<Lancamento>)request.getAttribute("debitos");
                       
                      for(Lancamento credito : creditos ){
                          somaCredito+=credito.getValor();
                      }
                      
                      for(Lancamento debito : debitos ){
                          somaDebito+=debito.getValor();
                      }
                      
                      saldo = somaCredito - somaDebito ;
                    %>
                    <tr>
                        <td><%=somaCredito%> </td>
                        <td><%=somaDebito%></td>
                        <td><%=Math.round(saldo)%></td>
                    
                        
                    </tr>
                   
                </thead>
            </table>
        </main>
                        
                     
        <%@include file="scripts.jsp" %>
    </body>
</html>
