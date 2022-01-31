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
public class CadastroUsuario implements Acao {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
       try{ 
        
       String nome = request.getParameter("nome");
       String CPF = request.getParameter("cpf");
       String senha = request.getParameter("senha");
       
       
       // BancoUsuario banco = new BancoUsuario();
        
       Usuario usuario = new Usuario();
       
       usuario.setNome(nome);
       usuario.setCPF(CPF);
       usuario.setSenha(senha);
       usuario.setBloqueado("N");
       
       
       UsuarioDAO usuariodao = new UsuarioDAO();
       
       
       
       if(usuariodao.getUserPorCPF(CPF)){
            if(usuariodao.gravar(usuario)){
                request.setAttribute("nomeUser",nome );
                return "forward:sucessoCadastroUsuario.jsp";
            } else {
                return "forward:erroCadastro.jsp";
            }
       }
       
       return "forward:erroUsuarioExistente.jsp";
       } catch(Exception e){
           System.out.println("Exceção - Cadastro Usuario");
           return "forward:erroCadastro.jsp";
       }
    }
    
}
