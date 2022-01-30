<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="aplicacao.Conta" %>
<%@page import="aplicacao.Categoria" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@include file="/frontend/src/html/cabeçalho.html" %>
    <title>Lançamentos</title>
</head>
<body>
    <header class="header">
        <div class="container mt-3 mb-3">
        <%@include file="navbar-2nd.jsp" %>
        </div>
    
    </header>

    <main>
        <div class="container"> 
            <form action="/entrada?acao=CadastroLancamento" method="POST">

                <Legend>Lançamento</Legend>

                <label>Tipo:</label>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="cartao" value="C" id="credito">
                    <label class="form-check-label mr-4" for="credito">Crédito</label>
                    <input class="form-check-input" type="radio" name="cartao" value="D" id="debito">
                    <label class="form-check-label" for="debito">Débito</label>
                </div>

                <div class="form-group mt-3">
                  <label for="valor">Valor</label>
                  <input type="text" name="valor" class="form-control" id="valor"required>
                </div>

                <div class="form-group">
                  <label for="nome">Data</label>
                  <input type="date" name="data" class="form-control" id="data"required>
                </div>

                <div class="form-group">
                    <label for="categoria">Categoria</label>
                   <!-- <input type="text" class="form-control" name="categoria" id="categoria"  placeholder="selecione uma categoria" required> -->
                    <select name="categoria" class="form-control" id="categoria" required>
                       <% 
                          List<Categoria> categorias = (List<Categoria>) request.getAttribute("categorias");
                          
                          for(Categoria categoria : categorias){
                              System.out.println("Categoria:"+categoria.getDescricao()+" " + categoria.getId());
                        %>      
                        <option value="<%=categoria.getId()%>"><%=categoria.getDescricao()%></option>
                        <%
                         }
                      
                        %>                     
                    </select>
                </div>
               
          
                 <div class="form-group mt-3">
                  <label for="descricao">Descrição</label>
                  <input type="" name="descricao" class="form-control" id="descricao" required>
                </div>   
                    
                <div class="form-group mt-3">
                  <label for="conta">Conta</label>
                  <!--<input type="text" name="conta" class="form-control" id="conta" required> -->
                  <select name="conta" class="form-control" id="conta" required>
                      <% 
                         
                        
                          List<Conta> contas = (List<Conta>) request.getAttribute("contas");
                          
                          for(Conta conta : contas){
                       
                        %>               
                        <option value="<%=conta.getId()%>"><%=conta.getConta_corrente()%></option>
                        <% }
                        %>                  
                  </select>
                </div>
                
                <!--<input type="hidden" value="${idUsuario}" name="idUsuario"> -->

                <input class="btn btn-primary" type="submit" value="Lançar">
            </form>

        </div>

    </main>

    <%@include file="scripts.jsp" %>

    <script>
        $(document).ready(function() {
            $('#valor').mask('#.##0,00',{reverse:true});
            $('form').submit(function() {
            if($('#credito').is(':checked') || $('#debito').is(':checked')) {
                alert('Lançamento confirmado');
            } else {
                alert('Marcar credito ou debito');
            }
        });
        
        });

        

    </script>
</body>
</html>