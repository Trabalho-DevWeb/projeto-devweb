<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="cabeçalho.html" %>
        <title>Index</title>
    </head>
    <body>
        <%@include file="navbar.jsp" %>
            <div class="container mt-3">
                <form action="">
                    <legend>Registrar Categoria</legend>
                    <div class="form-group">
                        <label for="categoria">Categoria</label>
                        <input type="text" class="form-control" id="categoria" required>
                        <input type="submit" value="incluir" class="btn btn-primary mt-3" re>
                    </div>          
                </form>
            </div>
        <%@include file="scripts.html" %>
        </script>
    </body>
</html>
