/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import aplicacao.BancoUsuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ramos
 */
public class CadastroUsuario implements Acao {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String nome = request.getParameter("nome");
       String CPF = request.getParameter("cpf");
       String email = request.getParameter("email");
       String senha = request.getParameter("senha");
        
        BancoUsuario banco = new BancoUsuario();
        
        if(banco.usuarioExiste(CPF,senha) == null){
            banco.adicionaUsuario(CPF,nome,senha);
            request.setAttribute("nomeUser",nome );
            return "forward:sucessoCadastroUsuario.jsp";
        } else {
            return "redirect:entrada?acao=ErroLogin";
        }
    }
    
}
