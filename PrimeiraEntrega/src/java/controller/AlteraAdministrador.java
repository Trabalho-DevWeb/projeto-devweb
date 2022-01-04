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

/**
 *
 * @author Ramos
 */
public class AlteraAdministrador implements  Acao {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        
        String cpf = request.getParameter("cpfAdm");
        String email = request.getParameter("emailAdm");
        String nome = request.getParameter("nomeAdm");
        String senha = request.getParameter("senhaAdm");
        Integer id = Integer.parseInt(request.getParameter("idAdm"));
        
        Banco banco = new Banco();
        
        Administrador admin = banco.buscaAdmin(id);
        
        admin.setCPF(cpf);
        admin.setEmail(email);
        admin.setNome(nome);
        admin.setSenha(senha);
        
        
        
        return "redirect:entrada?acao=ListaAdmins";
    }
    
}
