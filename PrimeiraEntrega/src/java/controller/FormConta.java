/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import aplicacao.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.UsuarioDAO;

/**
 *
 * @author Ramos
 */
public class FormConta implements Acao {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        //UsuarioDAO usuariodao = new UsuarioDAO();
        
        HttpSession sessao = request.getSession();
        
       
        
        Usuario usuario =(Usuario) sessao.getAttribute("individuoLogado");
        
        System.out.println("CPF do usuario XXX :" + usuario.getCPF());
        System.out.println("ID do usuario:" + usuario.getId());
        request.getSession().setAttribute("idUsuario",usuario.getId() ); 
        
        return "forward:form-conta.jsp";
    }
    
}
