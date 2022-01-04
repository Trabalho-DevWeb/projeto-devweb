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
public class RemoveUsuario implements Acao {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        
        BancoUsuario banco = new BancoUsuario();
        
        Usuario usuario = banco.buscaUsuario(id);
        
        banco.removeUsuario(usuario);
        
        return "redirect:entrada?acao=ListaUsuarios";
    }
    
}
