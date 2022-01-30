/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import aplicacao.Conta;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ContaDAO;

/**
 *
 * @author Ramos
 */
public class MostraConta implements Acao{

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String id = request.getParameter("id");
       Integer idAux = Integer.parseInt(id);
       
       //Banco banco = new Banco();
      // Administrador admin = banco.buscaAdmin(idAux); 
      
       ContaDAO contadao = new ContaDAO();
       Conta conta = contadao.getContaPorId(idAux);
       
      
      
       request.setAttribute("conta", conta);
       
       return "forward:form-altera-conta.jsp";
    }
    
}
