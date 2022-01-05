/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import aplicacao.Banco;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ramos
 */
public class CadastroAdmin implements Acao{

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nomeAdm");
        String CPF = request.getParameter("cpfAdm");
        String email = request.getParameter("emailAdm");
        String senha = request.getParameter("senhaAdm");
        
        Banco banco = new Banco();
        
        if(banco.existeAdmin(CPF, senha) == null){
            banco.adicionaAdm(CPF, nome, senha, email);
            request.setAttribute("nomeAdm",nome );
            return "forward:sucessoCadastroAdmin.jsp";
        } else {
            return "redirect:entrada?acao=ErroLogin";
        }
        
    }
    
}
