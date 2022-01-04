<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/frontend/src/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/frontend/src/css/global.css">
    <title>Lançamentos</title>
</head>
<body>
    <header class="header">
        <div class="container mt-3 mb-3">
            <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
                <ul class="navbar-nav">
                    <li class="nav-item"><a class="nav-link" href="index.html">Página Inicial</a></li>
                    <li class="nav-item"><a class="nav-link" href="login.html">Login</a></li>
                    <li class="nav-item"><a class="nav-link" href="form-categoria.html">form-categoria</a></li>
                    <li class="nav-item"><a class="nav-link" href="form-conta.html">form-conta</a></li>
                    <li class="nav-item"><a class="nav-link" href="form-usuario.html">form-usuario</a></li>
                    <li class="nav-item active"><a class="nav-link" href="form-lancamento.html">form-lancamento</a></li>
                    <li class="nav-item"><a class="nav-link" href="form-administrador.html">form-administrador</a></li>
                    <li class="nav-item"><a class="nav-link" href="menu-temporario.html">menu-temporario</a></li>
                </ul>
            </nav>
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

    <script src="<%=request.getContextPath()%>/frontend/src/scripts/jquery-3.4.1.min.js"></script>
    <script src="<%=request.getContextPath()%>/frontend/src/scripts/jquery.mask.min.js"></script>
    <script src="<%=request.getContextPath()%>/frontend/src/scripts/popper.min.js"></script>
    <script src="<%=request.getContextPath()%>/frontend/src/scripts/bootstrap.min.js"></script>

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