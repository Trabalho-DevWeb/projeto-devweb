<%-- 
    Document   : form-altera-conta
    Created on : 29/01/2022, 20:01:30
    Author     : Ramos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="aplicacao.Conta" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <%@include file="/frontend/src/html/cabeçalho.html" %>
    <title>Conta</title>
  </head>
  <body>
    <div class="container mt-3">
        <%@include file="navbar-2nd.jsp" %>
    </div>
    <div class="container mt-3">

      <form action="/entrada?acao=AlteraConta" method="POST">

        <Legend>Cadastro Conta</Legend>

      <!--  <div class="form-group">
          <label for="nome">Nome</label>
          <input type="text" class="form-control" name="nomeUsuario" id="nome" placeholder="Nome de usuario" required>
        </div>
       --> 
         <div class="form-group">
          <label for="agencia">Agencia</label>
          <input type="text" class="form-control" name="agencia" value="${conta.agencia}" id="conta" placeholder="Agencia" required>
        </div>
        
         <div class="form-group">
          <label for="conta">Conta</label>
          <input type="text" class="form-control" name="conta" value="${conta.conta_corrente}" id="conta" placeholder="Conta" required>
        </div>
        
        <div class="form-group">
          <label for="contabanco">Banco</label>
          
          <% 
              Conta conta = (Conta)request.getAttribute("conta");
             
              String contaNome = conta.getNome();
              
              
                
            
            %> 
           <select id="contabanco" name="contabanco" value="<%=contaNome%>" class="form-control" onchange="nomearBanco()" placeholder="Nome do Banco" required> 
            <option value=" "></option>
            <option value="conta itaú">Itaú</option>
            <option value="conta bb">BB</option>
          </select>
          
          <div class="form-group">
              <label for="numerobanco">Número do Banco</label>  
            <input class="form-control" name="numerobanco" value="${conta.banco}"type="text" id="numerobanco" value="" readonly>
          </div>      
          
          
        <!--  <input type="text" class="form-control" name="banco" id="banco" list="bancos" placeholder="Nº do Banco" required>
          <datalist id="bancos">
            <option value="001"></option>
            <option value="341"></option>
          </datalist>
          <input type="text" class="form-control" name="contaBanco" id="banco" list="bancos" placeholder="Nome do banco" required>
          <datalist id="bancos">
            <option value="conta BB"></option>
            <option value="conta itaú"></option>
          </datalist> -->
       
        </div>
        
       
       
       <!--<input type="hidden" value="${idUsuario}" name="idUsuario"> -->
            
       <input type="hidden" value="${conta.id}" name="id">
        
        <input class="btn btn-primary mt-3" type="submit" value="Enviar">
      </form>


    </div>

    <%@include file="scripts.jsp" %>
    
    <script>
        function nomearBanco(){
            let conta = document.getElementById("contabanco").value;
            let numeroConta = document.getElementById("numerobanco");
         
            
            if(conta === "conta itaú"){
               numeroConta.setAttribute('value','001') ;
            } else if(conta ==="conta bb") {
               numeroConta.setAttribute('value','341') ;
            } else {
               numeroConta.setAttribute('value','-') ;
            }
        }
        
        
        
        
    </script>
 
  </body>
</html>
