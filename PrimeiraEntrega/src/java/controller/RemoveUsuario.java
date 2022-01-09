/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import aplicacao.BancoUsuario;
import aplicacao.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.UsuarioDAO;


/**
 *
 * @author Ramos
 */
public class RemoveUsuario implements Acao {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        
       // BancoUsuario banco = new BancoUsuario();
        
       // Usuario usuario = banco.buscaUsuario(id);
        
          try{
        Integer id = Integer.parseInt(request.getParameter("id"));
        
        
        
        UsuarioDAO usuariodao = new UsuarioDAO();
        
        
        if(usuariodao.excluir(id)){
           return "redirect:entrada?acao=ListaUsuarios"; 
        } else {
            return "forward:erroRemover.jsp";
        }
        } catch(Exception e){
            System.out.println("Excecao - Remover Usuario");
            return "forward:erroRemover.jsp";
        }
        
    }
    
}
