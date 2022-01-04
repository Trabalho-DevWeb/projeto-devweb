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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ramos
 */
public class Login implements Acao{

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String CPF = request.getParameter("cpf");
        String senha = request.getParameter("senha");
        String tipo = request.getParameter("user");
        
        System.out.println(CPF);
        System.out.println(senha);
        System.out.println(tipo);
        
        Banco banco = new Banco();
        
        Administrador admin = banco.existeAdmin(CPF,senha);
        
      
        if(admin != null && tipo.equals("administrador")){
            System.out.println("Administrador Existe");
            HttpSession sessao = request.getSession();
            sessao.setAttribute("adminLogado",admin);
            return "redirect:entrada?acao=IndexAdm";
        } else {
            return "redirect:entrada?acao=ErroLogin";
        }
        
        
    }
    
}
