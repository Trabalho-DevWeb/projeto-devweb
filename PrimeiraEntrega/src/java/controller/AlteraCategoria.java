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
import model.CategoriaDAO;

/**
 *
 * @author Ramos
 */
public class AlteraCategoria implements Acao {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         
        try{
        
        String descricao = request.getParameter("descricao");
         Integer id = Integer.parseInt(request.getParameter("id"));
         
         //BancoCategoria banco = new BancoCategoria();
         
        // Categoria categoria = banco.buscaCategoria(id);
        
        CategoriaDAO categoriadao = new CategoriaDAO();
        
        Categoria categoria = categoriadao.getCategoriaPorID(id);
         
        categoria.setDescricao(descricao);
         
        if(categoriadao.atualizar(categoria)){
            
          return "redirect:entrada?acao=ListaCategorias";   
        } else {
            return "forward:erroAtualizar.jsp";
        }
         
        } catch(Exception e){
            System.out.println("Excecao - Altera Categoria");
            return "forward:erroAtualizar.jsp";
        }
    }
    
}
