/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import aplicacao.BancoCategoria;
import aplicacao.Categoria;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ramos
 */
public class ListaCategorias implements Acao{

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BancoCategoria banco = new BancoCategoria();
        
        List<Categoria> lista = banco.getListaCategoria();
        
        request.setAttribute("categorias", lista);
        
        return "forward:listaCategorias.jsp";
    }
    
}
