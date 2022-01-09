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
public class CadastroCategoria implements Acao{

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        try{
        String descricao = request.getParameter("descricao");
        
        //BancoCategoria banco = new BancoCategoria();        
       // Banco banco = new Banco();
       Categoria categoria = new Categoria();
       
       categoria.setDescricao(descricao);
   
       CategoriaDAO categoriadao = new CategoriaDAO();
       
       if(categoriadao.gravar(categoria)){
            request.setAttribute("descricao",descricao );
            return "forward:sucessoCadastro.jsp";
       } else{
           return "forward:erroCadastro.jsp";
       }
        
        } catch(Exception e){
            System.out.println("Exceção - Cadastor Categoria");
            return "forward:erroCadastro.jsp";
        }
    }
    
}
