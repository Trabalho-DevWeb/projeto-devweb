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

/**
 *
 * @author Ramos
 */
public class AlteraUsuario implements Acao {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String CPF = request.getParameter("cpf");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        Integer id = Integer.parseInt(request.getParameter("id"));
         
         BancoUsuario banco = new BancoUsuario();
         
         Usuario usuario = banco.buscaUsuario(id);
         
         usuario.setCPF(CPF);
         usuario.setEmail(email);
         usuario.setNome(nome);
         usuario.setSenha(senha);
         
         return "redirect:entrada?acao=ListaUsuarios";
    }
    
}
