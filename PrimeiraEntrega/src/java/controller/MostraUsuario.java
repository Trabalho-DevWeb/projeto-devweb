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
public class MostraUsuario implements Acao{

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        
       String id = request.getParameter("id");
       Integer idAux = Integer.parseInt(id);
       
       //BancoUsuario banco = new BancoUsuario();
       
       //Usuario usuario = banco.buscaUsuario(idAux);
       
       UsuarioDAO usuariodao = new UsuarioDAO();
       
       Usuario usuario = usuariodao.getUsuarioPorID(idAux);
       
       request.setAttribute("usuario", usuario);
       
       return "forward:form-altera-usuario.jsp";
    }
    
}
