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
import model.AdminDAO;

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
        
        
        

        
        //Banco banco = new Banco();
        
        //Administrador admin = banco.existeAdmin(CPF,senha);
        
        AdminDAO admindao = new AdminDAO();
        
        Administrador admin = admindao.getAdministradorPorCPF(CPF);
        
            Administrador administrador = new Administrador();
            administrador.setCPF(CPF);
            administrador.setSenha(senha);
        
       
        
       try{
        if(administrador.getCPF().equals(admin.getCPF())&& administrador.getSenha().equals(admin.getSenha()) && tipo.equals("administrador")){
            System.out.println("Administrador Existe");
            HttpSession sessao = request.getSession();
            sessao.setAttribute("adminLogado",admin);
            return "redirect:entrada?acao=IndexAdm";
        } else {
            return "forward:erroLogin.jsp";
        }
       
       } catch (NullPointerException e){
           System.out.println("Erro "+ e.getMessage());
           System.out.println("CHEGOU AQUI !!!#!@!#!#!#!");
           return "forward:erroLogin.jsp";
       } 
         
        
    }
    
}
