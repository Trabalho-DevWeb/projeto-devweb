/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ContaDAO;


/**
 *
 * @author Ramos
 */
public class RemoveConta implements Acao{

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         try{
        Integer id = Integer.parseInt(request.getParameter("id"));
        
        //Banco banco = new Banco();
        
        //Administrador adm = banco.buscaAdmin(id);
        
        ContaDAO contadao = new ContaDAO();
        
        
        
        
        
        if(contadao.excluir(id)){
           return "redirect:entrada?acao=ListaContas"; 
        } else {
            return "forward:erroRemoverConta.jsp";
        }
        } catch(Exception e){
            System.out.println("Excecao - Remover Conta");
            return "forward:erroRemoverConta.jsp";
        }
        
    }
    
}
