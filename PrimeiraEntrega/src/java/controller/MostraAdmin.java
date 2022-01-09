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
import model.AdminDAO;

/**
 *
 * @author Ramos
 */
public class MostraAdmin implements Acao {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String id = request.getParameter("id");
       Integer idAux = Integer.parseInt(id);
       
       //Banco banco = new Banco();
      // Administrador admin = banco.buscaAdmin(idAux); 
      
      AdminDAO admindao = new AdminDAO();
      Administrador admin = admindao.getAdministradorPorID(idAux);
       
      
      
       request.setAttribute("admin", admin);
       
       return "forward:form-altera-administrador.jsp";
       
       
    }
    
}
