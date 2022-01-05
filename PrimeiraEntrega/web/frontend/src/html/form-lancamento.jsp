<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@include file="/frontend/src/html/cabeçalho.html" %>
    <title>Lançamentos</title>
</head>
<body>
    <header class="header">
        <div class="container mt-3 mb-3">
        <%@include file="navbar.jsp" %>
        </div>
    
    </header>

    <main>
        <div class="container"> 
            <form action="">

                <Legend>Lançamento</Legend>

                <label>Tipo:</label>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" value="" id="credito">
                    <label class="form-check-label mr-4" for="credito">Crédito</label>
                    <input class="form-check-input" type="checkbox" value="" id="debito">
                    <label class="form-check-label" for="debito">Débito</label>
                </div>

                <div class="form-group mt-3">
                  <label for="valor">Valor</label>
                  <input type="text" class="form-control" id="valor"required>
                </div>

                <div class="form-group">
                  <label for="nome">Data</label>
                  <input type="date" class="form-control" id="data"required>
                </div>

                <div class="form-group">
                    <label for="banco">Categoria</label>
                    <input type="text" class="form-control" id="banco" list="bancos" placeholder="selecione uma categoria" required>
                    <datalist id="bancos">
                        <option value="Luz"></option>
                        <option value="Água"></option>
                        <option value="Plano de saúde"></option>
                        <option value="Salário"></option>
                        <option value="Outros"></option>                    
                    </datalist>

                <div class="form-group mt-3">
                  <label for="descricao">Descrição</label>
                  <input type="textarea" class="form-control" id="descricao" required>
                </div>


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
        })
        
        })

        

    </script>
</body>
</html>