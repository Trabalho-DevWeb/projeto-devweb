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
public class RemoveCategoria implements Acao {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //BancoCategoria banco = new BancoCategoria();
        
        //Categoria categoria = banco.buscaCategoria(id);
        
        try{
        Integer id = Integer.parseInt(request.getParameter("id"));
        
        CategoriaDAO categoriadao = new CategoriaDAO();
        
        
        if(categoriadao.excluir(id)){
            return "redirect:entrada?acao=ListaCategorias";    
        } else {
            return "forward:erroRemover.jsp";
        }
       
        } catch(Exception e){
            System.out.println("Excecao - Remover Categoria");
            return "forward:erroRemover.jsp";
        }
    }
    
}
