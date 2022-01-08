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
public class AlteraUsuario implements Acao {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        
        try{
        String nome = request.getParameter("nome");
        String CPF = request.getParameter("cpf");
        String senha = request.getParameter("senha");
        String bloqueado = request.getParameter("suspenso");
    
        Integer id = Integer.parseInt(request.getParameter("id"));
         
        // BancoUsuario banco = new BancoUsuario();
         
         //Usuario usuario = banco.buscaUsuario(id);
         
         UsuarioDAO usuariodao = new UsuarioDAO();
         
         Usuario usuario = usuariodao.getUsuarioPorCPF(CPF);
         
         usuario.setCPF(CPF);
         usuario.setNome(nome);
         usuario.setSenha(senha);
         usuario.setBloqueado(bloqueado);
         
         if(usuariodao.atualizar(usuario)){
             return "redirect:entrada?acao=ListaUsuarios";    
         } else {
             return "forward:erroAtualizar.jsp";
         }
         
        } catch(Exception e){
            System.out.println("Excecao - Altera Usuario");
            return "forward:erroAtualizar.jsp";
        }
    }
    
}
