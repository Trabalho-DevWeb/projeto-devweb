/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import aplicacao.Administrador;
import aplicacao.Banco;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.AdminDAO;

/**
 *
 * @author Ramos
 */
public class RemoveAdmin implements Acao{

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        try{
        Integer id = Integer.parseInt(request.getParameter("id"));
        
        //Banco banco = new Banco();
        
        //Administrador adm = banco.buscaAdmin(id);
        
        AdminDAO admindao = new AdminDAO();
        
        
        if(admindao.excluir(id)){
           return "redirect:entrada?acao=ListaAdmins"; 
        } else {
            return "forward:erroRemover.jsp";
        }
        } catch(Exception e){
            System.out.println("Excecao - Remover Administrador");
            return "forward:erroRemover.jsp";
        }
        
        
    }
    
}
