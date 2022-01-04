/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import aplicacao.BancoCategoria;
import aplicacao.Categoria;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ramos
 */
public class MostraCategoria implements Acao {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
       Integer idAux = Integer.parseInt(id);
       
       BancoCategoria banco = new BancoCategoria();
       
       Categoria categoria = banco.buscaCategoria(idAux);
       
       request.setAttribute("categoria", categoria);
       
       return "forward:form-altera-categoria.jsp";
    }
    
}
