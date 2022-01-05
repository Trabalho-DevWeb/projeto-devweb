/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import aplicacao.BancoUsuario;
import aplicacao.Usuario;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ramos
 */
public class ListaUsuarios implements Acao{

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BancoUsuario banco = new BancoUsuario();
        
        List<Usuario> lista = banco.getListaUsuario();
        
        request.setAttribute("usuarios", lista);
        
        return "forward:listaUsuarios.jsp";
    }
    
}
